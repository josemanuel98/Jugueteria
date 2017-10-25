package org.jwonkafx.model;
public class Empleado
{
    private int idEmpleado;
    private float salario;
    private String codigo;
    private String fechaIngreso;
    private int activo;
    private Persona persona;
    private Usuario usuario;
    private Rol rol;
    
    public Rol getRol()
    {
        return rol;
    }
    public void setRol(Rol rol)
    {
        this.rol = rol;
    }
    public int getIdEmpleado()
    {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado)
    {
        this.idEmpleado = idEmpleado;
    }
    public float getSalario()
    {
        return salario;
    }
    public void setSalario(float salario)
    {
        this.salario = salario;
    }
    public String getCodigo()
    {
        return codigo;
    }
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }
    public String getFechaIngreso()
    {
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso)
    {
        this.fechaIngreso = fechaIngreso;
    }
    public int getActivo()
    {
        return activo;
    }
    public void setActivo(int activo)
    {
        this.activo = activo;
    }
    public Persona getPersona()
    {
        return persona;
    }
    public void setPersona(Persona persona)
    {
        this.persona = persona;
    }
    public Usuario getUsuario()
    {
        return usuario;
    }
    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }          
}
