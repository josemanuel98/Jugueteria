/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui.components;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.Persona;
import org.jwonkafx.model.Rol;
import org.jwonkafx.model.Usuario;

/**
 *
 * @author Josem
 */
public class TableAdapterEmpleado {
    public static void adapt(TableView<Empleado> tbl){
        TableColumn<Empleado, Integer> tcIdEmpleado = new TableColumn("Cve. Empleado");
        TableColumn<Empleado, String> tcCodigoEmpleado = new TableColumn("Codigo Empleado");
        TableColumn<Empleado, Float> tcSalario = new TableColumn("Salario");
        TableColumn<Empleado, String> tcFechaIngreso = new TableColumn("Fecha Ingreso");
        TableColumn<Empleado, Integer> tcActivo = new TableColumn("Activo");
        TableColumn<Empleado, Persona> tcIdPersona = new TableColumn("Cve. Persona");
        TableColumn<Empleado, Persona> tcNombre = new TableColumn("Nombre");
        TableColumn<Empleado, Persona> tcApellidoPaterno = new TableColumn("Apellido Paterno");
        TableColumn<Empleado, Persona> tcApellidoMaterno = new TableColumn("Apellido Materno");
        TableColumn<Empleado, Persona> tcGenero = new TableColumn("Genero");
        TableColumn<Empleado, Persona> tcRfc = new TableColumn("RFC");
        TableColumn<Empleado, Persona> tcCurp = new TableColumn("CURP");
        TableColumn<Empleado, Persona> tcFechaNacimiento = new TableColumn("Fecha Nacimiento");
        TableColumn<Empleado, Persona> tcCodigoPostal = new TableColumn("Codigo Postal");
        TableColumn<Empleado, Persona> tcFotografia = new TableColumn("Fotografia");
        TableColumn<Empleado, Persona> tcDomicilio = new TableColumn("Domicilio");
        TableColumn<Empleado, Usuario> tcIdUsuario = new TableColumn("Cve. Usuario");
        TableColumn<Empleado, Usuario> tcPassword = new TableColumn("Password");
        TableColumn<Empleado, Usuario> tcUserName = new TableColumn("UserName");
        TableColumn<Empleado, Rol> tcDescripcion = new TableColumn("Descripción");
        TableColumn<Empleado, Rol> tcIdRol = new TableColumn("Cve. Rol");
        
        tcIdEmpleado.setCellFactory(new Callback<TableColumn<Empleado, Integer>, TableCell<Empleado, Integer>>(){
            @Override
            public TableCell<Empleado, Integer> call(TableColumn<Empleado, Integer> param){
                return new TableCell<Empleado, Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getIdEmpleado());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcCodigoEmpleado.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>(){
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param){
                return new TableCell<Empleado, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getCodigo());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcSalario.setCellFactory(new Callback<TableColumn<Empleado, Float>, TableCell<Empleado, Float>>(){
            @Override
            public TableCell<Empleado, Float> call(TableColumn<Empleado, Float> param){
                return new TableCell<Empleado, Float>(){
                    @Override
                    protected void updateItem(Float item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getSalario());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcFechaIngreso.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>(){
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param){
                return new TableCell<Empleado, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getFechaIngreso());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcActivo.setCellFactory(new Callback<TableColumn<Empleado, Integer>, TableCell<Empleado, Integer>>(){
            @Override
            public TableCell<Empleado, Integer> call(TableColumn<Empleado, Integer> param){
                return new TableCell<Empleado, Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getActivo());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcIdPersona.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getIdPersona());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcNombre.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getNombre());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcApellidoPaterno.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getPaterno());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcApellidoMaterno.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getMaterno());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcGenero.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getGenero());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcRfc.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getRfc());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcCurp.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getCurp());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcFechaNacimiento.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getFechaNacimiento());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcCodigoPostal.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getCodigoPostal());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcFotografia.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getFotografia());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcDomicilio.setCellFactory(new Callback<TableColumn<Empleado, Persona>, TableCell<Empleado, Persona>>(){
            @Override
            public TableCell<Empleado, Persona> call(TableColumn<Empleado, Persona> param){
                return new TableCell<Empleado, Persona>(){
                    @Override
                    protected void updateItem(Persona item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getPersona().getDomicilio());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcIdUsuario.setCellFactory(new Callback<TableColumn<Empleado, Usuario>, TableCell<Empleado, Usuario>>(){
            @Override
            public TableCell<Empleado, Usuario> call(TableColumn<Empleado, Usuario> param){
                return new TableCell<Empleado, Usuario>(){
                    @Override
                    protected void updateItem(Usuario item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getUsuario().getIdUsuario());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcPassword.setCellFactory(new Callback<TableColumn<Empleado, Usuario>, TableCell<Empleado, Usuario>>(){
            @Override
            public TableCell<Empleado, Usuario> call(TableColumn<Empleado, Usuario> param){
                return new TableCell<Empleado, Usuario>(){
                    @Override
                    protected void updateItem(Usuario item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getUsuario().getPassword());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcUserName.setCellFactory(new Callback<TableColumn<Empleado, Usuario>, TableCell<Empleado, Usuario>>(){
            @Override
            public TableCell<Empleado, Usuario> call(TableColumn<Empleado, Usuario> param){
                return new TableCell<Empleado, Usuario>(){
                    @Override
                    protected void updateItem(Usuario item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getUsuario().getUserName());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcDescripcion.setCellFactory(new Callback<TableColumn<Empleado, Rol>, TableCell<Empleado, Rol>>(){
            @Override
            public TableCell<Empleado, Rol> call(TableColumn<Empleado, Rol> param){
                return new TableCell<Empleado, Rol>(){
                    @Override
                    protected void updateItem(Rol item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getRol().getDescripcion());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tcIdRol.setCellFactory(new Callback<TableColumn<Empleado, Rol>, TableCell<Empleado, Rol>>(){
            @Override
            public TableCell<Empleado, Rol> call(TableColumn<Empleado, Rol> param){
                return new TableCell<Empleado, Rol>(){
                    @Override
                    protected void updateItem(Rol item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex() >= 0 && getIndex() < tbl.getItems().size()){
                            textProperty().set("" + tbl.getItems().get(getIndex()).getRol().getIdRol());
                        }else{
                            setText(null);
                        }
                    };
                };
            }
        });
        
        tbl.getColumns().clear();
        tbl.getColumns().addAll(
                tcIdEmpleado,
                tcCodigoEmpleado,
                tcSalario,
                tcFechaIngreso,
                tcActivo,
                tcIdPersona, 
                tcNombre, 
                tcApellidoPaterno, 
                tcApellidoMaterno,
                tcGenero,
                tcRfc,
                tcCurp,
                tcFechaNacimiento,
                tcCodigoPostal,
                tcFotografia,
                tcDomicilio,
                tcIdUsuario,
                tcPassword,
                tcUserName,
                tcDescripcion,
                tcIdRol
        );
    }
}
