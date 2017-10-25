/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui;

import com.github.sarxos.webcam.Webcam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.grios.jwebcam.WebCamAdapterFX;
import org.jwonkafx.core.ControladorEmpleado;
import org.jwonkafx.gui.components.TableAdapterEmpleado;
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.Persona;
import org.jwonkafx.model.Rol;
import org.jwonkafx.model.Usuario;

/**
 *
 * @author Josem
 */
public class EmpleadoWindow {
    
    @FXML TextField txtIdPersona;
    @FXML TextField txtIdEmpleado;
    @FXML TextField txtIdUsuario;
    @FXML TextField txtIdRol;
    @FXML TextField txtNombre;
    @FXML TextField txtPaterno;
    @FXML TextField txtMaterno;
    @FXML TextField txtCodigoPostal;
    @FXML TextField txtRfc;
    @FXML DatePicker dpkFechaNacimiento;
    @FXML TextField txtDomicilio;
    @FXML TextField txtCurp;
    @FXML TextField txtSalario;
    @FXML TextField txtPassword;
    @FXML ComboBox cmbRol;
    @FXML ComboBox cmbGenero;
    @FXML CheckBox chbActivo;
    @FXML ImageView imgvFoto;
    @FXML AnchorPane pnlRoot;
    @FXML ImageView imgvCamaraWeb;
    @FXML ComboBox cmbCamarasWeb;
    @FXML TextField txtFiltro;
    @FXML TextField txtCodigo;
    @FXML Button btnCrearNuevo;
    @FXML Button btnGuardar;
    @FXML Button btnEliminar;
    @FXML Button btnConsultar;
    @FXML Button btnBuscar;
    @FXML Button btnTomarFoto;
    @FXML Button btnIniciarCamaraWeb;
    @FXML TableView<Empleado> tblEmpleados;
    
    FXMLLoader fxmll;
    Scene scene;
    Stage window;
    ControladorEmpleado cc;
    WebCamAdapterFX webcamfx;
    Alert alertDefault;
    
    public void start() throws Exception{
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_empleados.fxml"));
        fxmll.setController(this);;
        fxmll.load();
        
        tblEmpleados.setItems(FXCollections.observableArrayList());
        TableAdapterEmpleado.adapt(tblEmpleados);
        
        btnGuardar.setOnAction(evt -> {
            guardar();
        });
        
        btnConsultar.setOnAction(evt -> {
            consultar("");
        });
        
        btnIniciarCamaraWeb.setOnAction(evt -> {
            iniciarCamaraWeb();
        });
        
        btnTomarFoto.setOnAction(evt -> {
            tomarFoto();
        });
        
        btnEliminar.setOnAction(evt -> {
            eliminar();
        });
        
        tblEmpleados.setOnMouseClicked(evt -> {
            try{
            llenarContenedores(tblEmpleados.getSelectionModel().selectedItemProperty().getValue());
            }catch(Exception ex){
                ex.printStackTrace();
            }
        });
        
        consultarWebCams();
    }
    
    public AnchorPane getPanelRoot(){
        return pnlRoot;
    }
    
    public void consultarWebCams(){
        //Se consultan las webcams conectadas al equipo y se guardan en un arreglo
        Webcam[] cams = WebCamAdapterFX.getSystemCamDevicesAsArray();
        //Se limpia el ComboBox de la webcam
        cmbCamarasWeb.getItems().clear();
        //Por cada webcam en el arreglo se agrega su nombre en el ComboBox
        for(Webcam w : cams){
            cmbCamarasWeb.getItems().add(w.getName());
        }
    }
    
    private void iniciarCamaraWeb(){
        if(webcamfx == null){
            webcamfx = new WebCamAdapterFX(imgvCamaraWeb);
        }
        
        if(webcamfx.isStarted()){
            webcamfx.stop();
        }
        
        if(cmbCamarasWeb.getSelectionModel().getSelectedItem() != null){
            webcamfx.start(cmbCamarasWeb.getSelectionModel().getSelectedItem().toString());
        }
    }
    
    private void tomarFoto(){
        if(webcamfx != null && webcamfx.isStarted()){
            imgvFoto.setImage(SwingFXUtils.toFXImage(webcamfx.getBufferedImage(), null));
        }
    }
    
    private void llenarContenedores(Empleado e) throws Exception {
        txtIdPersona.setText("" + e.getPersona().getIdPersona());
        txtIdEmpleado.setText("" + e.getIdEmpleado());
        txtIdUsuario.setText("" + e.getUsuario().getIdUsuario());
        txtIdRol.setText("" + e.getRol().getIdRol());
        txtNombre.setText(e.getPersona().getNombre());
        txtPaterno.setText(e.getPersona().getPaterno());
        txtMaterno.setText(e.getPersona().getMaterno());
        txtDomicilio.setText(e.getPersona().getDomicilio());
        txtSalario.setText("" + e.getSalario());
        txtPassword.setText(e.getUsuario().getPassword());
        cmbRol.setValue(e.getRol().getDescripcion());
        txtCodigo.setText(e.getCodigo());
        txtCodigoPostal.setText(e.getPersona().getCodigoPostal());
        txtDomicilio.setText(e.getPersona().getDomicilio());
        txtCurp.setText(e.getPersona().getCurp());
        txtRfc.setText(e.getPersona().getRfc());
        String date = formatDate(e.getPersona().getFechaNacimiento(), "dd/mm/yyy", "yyy-mm-dd");
        dpkFechaNacimiento.setValue(LocalDate.parse(date));
        dpkFechaNacimiento.setPromptText(e.getPersona().getFechaNacimiento());
        
        try{
            imgvFoto.setImage(SwingFXUtils.toFXImage(WebCamAdapterFX.decodeImageURLSafe(e.getPersona().getFotografia()), null));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        cmbGenero.setValue(e.getPersona().getGenero());
        
        if(e.getActivo() == 1){
            chbActivo.setSelected(true);
        }else{
            chbActivo.setSelected(false);
        }
        txtIdPersona.setText("" + e.getPersona().getIdPersona());
        txtIdUsuario.setText("" + e.getUsuario().getIdUsuario());
        txtIdEmpleado.setText("" + e.getIdEmpleado());
    }
    
    public static String formatDate (String date, String initDateFormat, String endDateFormat) throws ParseException {

    Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
    SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
    String parsedDate = formatter.format(initDate);

    return parsedDate;
}
    
    public void consultar(String filtro){
        ObservableList<Empleado> empleado = null;
        cc = new ControladorEmpleado();
        try{
            empleado = cc.getAll(filtro);
            tblEmpleados.setItems(empleado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void eliminar(){
        Alert alert = new Alert(AlertType.NONE);
            if(!txtIdEmpleado.getText().trim().isEmpty() && !txtIdPersona.getText().trim().isEmpty() && !txtIdUsuario.getText().trim().isEmpty())
            {
                alert.setAlertType(AlertType.CONFIRMATION);
                alert.setContentText("¿Deseas Continuar?");
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try
                        {
                            int idUsuario, idEmpleado;
                            
                            idUsuario = Integer.valueOf(txtIdUsuario.getText());
                            idEmpleado = Integer.valueOf(txtIdEmpleado.getText());
                            
                           
                            cc.delete(idUsuario, idEmpleado);
                            consultar("");
                         
                            
                            
                            alert.setContentText("Empleado Removido Correctamente");
                            alert.show();
                        }catch(Exception e)
                        {
                            alert.setHeaderText("Error");
                            alert.setContentText(e.toString());
                            alert.show();    
                        }
                            
                    }
                });
            }
            else
            {
                alert.setAlertType(AlertType.INFORMATION);
                alert.setHeaderText("Warning");
                alert.setContentText("Proporcione un empleado a eliminar");
                alert.show();
            }
    }
    
    public void guardar(){
        Empleado e = new Empleado();
        Persona p = new Persona();
        Usuario u = new Usuario();
        Rol r = new Rol();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Guardar empleado");
        cc = new ControladorEmpleado();
        try{
                e.setSalario(Float.valueOf(txtSalario.getText()));
                e.setCodigo(txtCodigo.getText());
                e.setActivo((chbActivo.isSelected()?1:0));        
                p.setNombre(txtNombre.getText());
                p.setPaterno(txtPaterno.getText());
                p.setMaterno(txtMaterno.getText());
                p.setGenero(cmbGenero.getSelectionModel().getSelectedItem().toString());
                
                p.setRfc(txtRfc.getText());
                p.setCurp(txtCurp.getText());
                String date_s = dpkFechaNacimiento.getValue().toString();
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                Date date = dt.parse(date_s);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
                p.setFechaNacimiento(dt1.format(date));
                p.setCodigoPostal(txtCodigoPostal.getText());
                p.setDomicilio(txtDomicilio.getText());
                
                if(imgvFoto.getImage() != null)
                {
                    p.setFotografia(WebCamAdapterFX.encodeImageURLSafe(SwingFXUtils.fromFXImage(imgvFoto.getImage(), null)));
                }
                else
                {
                    p.setFotografia("");
                }
                if (!txtIdPersona.getText().trim().isEmpty())
                { 
                    p.setIdPersona(Integer.valueOf(txtIdPersona.getText())); 
                }
                if (!txtIdEmpleado.getText().trim().isEmpty())
                { 
                    e.setIdEmpleado(Integer.valueOf(txtIdEmpleado.getText())); 
                }
                
                u.setPassword(txtPassword.getText());
                
                if (!txtIdUsuario.getText().trim().isEmpty())
                { 
                    u.setIdUsuario(Integer.valueOf(txtIdUsuario.getText())); 
                }
                
                if (!txtIdRol.getText().trim().isEmpty())
                { 
                    r.setIdRol(Integer.valueOf(txtIdRol.getText())); 
                }
                r.setDescripcion(cmbRol.getSelectionModel().getSelectedItem().toString());
                
                e.setPersona(p);
                e.setUsuario(u);
                e.setRol(r);
        
                if(e.getIdEmpleado()>0 && e.getUsuario().getIdUsuario()>0)
                {
                    cc.update(e);
                    consultar("");
                }
                else
                {
                    cc.insert(e);
                    consultar("");
                }
        
                alert.setContentText("Empleado registrado");
                alert.show();
        
            }catch (Exception ex)
            {
                ex.printStackTrace();
                alert.setContentText("Error");
                alert.show();
            }
    }
    
    
}
