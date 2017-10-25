package org.jwonkafx.core;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jwonkafx.db.ConexionSqlServer;
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.Persona;
import org.jwonkafx.model.Rol;
import org.jwonkafx.model.Usuario;
public class ControladorEmpleado
{
    public void insert(Empleado emp) throws Exception
    {
        String query="{CALL InsertarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionSqlServer conex = new ConexionSqlServer();
        CallableStatement cmd = conex.open().prepareCall(query);
        cmd.setString(1, emp.getPersona().getNombre());
        cmd.setString(2, emp.getPersona().getPaterno());
        cmd.setString(3, emp.getPersona().getMaterno());
        cmd.setString(4, emp.getPersona().getGenero());
        cmd.setString(5, emp.getPersona().getFechaNacimiento());
        cmd.setString(6, emp.getPersona().getCodigoPostal());
        cmd.setString(7,emp.getPersona().getDomicilio());
        cmd.setString(8, emp.getPersona().getFotografia());
        cmd.setString(9, emp.getPersona().getCurp());
        cmd.setString(10, emp.getPersona().getRfc());
        cmd.setFloat(11,emp.getSalario());
        cmd.setString(12,emp.getCodigo());
        cmd.setString(13,emp.getUsuario().getPassword());
        cmd.setString(14, emp.getRol().getDescripcion());
        
        cmd.registerOutParameter(15, java.sql.Types.INTEGER);
        cmd.registerOutParameter(16, java.sql.Types.INTEGER);
        cmd.registerOutParameter(17, java.sql.Types.INTEGER);
        cmd.registerOutParameter(18, java.sql.Types.INTEGER);
        cmd.executeUpdate();
        emp.getRol().setIdRol(cmd.getInt(15));
        emp.getUsuario().setIdUsuario(cmd.getInt(16));
        emp.getPersona().setIdPersona(cmd.getInt(17));
        emp.setIdEmpleado(cmd.getInt(18));
        cmd.close();
        conex.close();
    }
    
    public void update(Empleado emp) throws Exception
    {
        //Se define la consulta que invoca al procedimiento almacenado
        String sql = "{CALL UpdateEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        //Instanciamos un obj de conexion con SQL Server
        ConexionSqlServer conn = new ConexionSqlServer();
        
        //Abrimos la conexion con SQL Server y generamos un objeto para invocar al procedimiento almacenado
        
        CallableStatement cstmt = conn.open().prepareCall(sql);
        
        //Se establecen los valores de los parametros
        cstmt.setString(1, emp.getPersona().getNombre());
        cstmt.setString(2, emp.getPersona().getPaterno());
        cstmt.setString(3, emp.getPersona().getMaterno());
        cstmt.setString(4, emp.getPersona().getGenero());
        cstmt.setString(5, emp.getPersona().getFechaNacimiento());
        cstmt.setString(6, emp.getPersona().getCodigoPostal());
        cstmt.setString(7, emp.getPersona().getDomicilio());
        cstmt.setString(8, emp.getPersona().getFotografia());
        cstmt.setString(9, emp.getPersona().getCurp());
        cstmt.setString(10, emp.getPersona().getRfc());
        cstmt.setFloat(11, emp.getSalario());
        cstmt.setString(12, emp.getCodigo());
        cstmt.setString(13, emp.getUsuario().getPassword());
        cstmt.setString(14, emp.getRol().getDescripcion());
        cstmt.setInt(15, emp.getPersona().getIdPersona());
        cstmt.setInt(16, emp.getRol().getIdRol());
        cstmt.setInt(17, emp.getUsuario().getIdUsuario());
        cstmt.setInt(18, emp.getIdEmpleado());
        
        //Se ejecuta la sentencia
        cstmt.executeUpdate();
        
        //Se cierra la conexion
        cstmt.close();
        conn.close();
    }
    
    public void delete(int idEmpleado, int idUsuario) throws Exception
    {
        //Se define la consulta que invoca al procedimiento almacenado
        String sql = "{ CALL EliminarEmpleado(?, ?) }";
        //Instanciamos un obj de conexion con SQL Server
        ConexionSqlServer conn = new ConexionSqlServer();
        
        //Abrimos la conexion con SQL Server y generamos un objeto para invocar al procedimiento almacenado
        
        CallableStatement cstmt = conn.open().prepareCall(sql);
        
        //Se establecen los valores de los parametros
        cstmt.setInt(1, idEmpleado);
        cstmt.setInt(2, idUsuario);
        //Se ejecuta la sentencia
        cstmt.executeUpdate();
        
        //Se cierra la conexion
        cstmt.close();
        conn.close();
    }
    
    public ObservableList<Empleado> getAll(String filtro) throws Exception
    {
       Persona p = null;
       Usuario u = null;
       Rol r = null;
       String query ="SELECT * FROM V_Empleados;";
       ObservableList<Empleado> empleados = FXCollections.observableArrayList();
       ConexionSqlServer conex = new ConexionSqlServer();
       PreparedStatement cmd = conex.open().prepareCall(query);
       ResultSet rs=cmd.executeQuery();
       Empleado emp;
       while(rs.next())
       {
           emp = new Empleado();
           p = new Persona();
           u = new Usuario();
           r = new Rol();
           emp.setActivo(rs.getInt("Activo"));
           emp.setCodigo(rs.getString("Codigo"));
           p.setCodigoPostal(rs.getString("CP"));
           p.setCurp(rs.getString("Curp"));
           p.setDomicilio(rs.getString("Domicilio"));
           emp.setFechaIngreso(rs.getString("FechaIngreso"));
           p.setFechaNacimiento(rs.getString("FechaNacimiento"));
           p.setFotografia(rs.getString("Fotografia"));
           p.setGenero(rs.getString("Genero"));
           emp.setIdEmpleado(rs.getInt("IdEmpleado"));
           p.setIdPersona(rs.getInt("IdPersona"));
           p.setMaterno(rs.getString("ApellidoMaterno"));
           p.setPaterno(rs.getString("ApellidoPaterno"));
           p.setNombre(rs.getString("Nombre"));
           p.setRfc(rs.getString("Rfc"));
           emp.setSalario(rs.getInt("Salario"));
           u.setIdUsuario(rs.getInt("IdUsuario"));
           u.setPassword(rs.getString("Password"));
           r.setDescripcion(rs.getString("Descripcion"));
           r.setIdRol(rs.getInt("IdRol"));
           u.setUserName(rs.getString("Username"));
           emp.setPersona(p);
           emp.setRol(r);
           emp.setUsuario(u);
           empleados.add(emp);
           
       }
       return empleados;
    }
}