
package Entidades;

import java.util.ArrayList;


public class Alumno extends Persona{
    
    private int idalumno;
    private String fechaAlta;
    //Establece relacion alumnos - profesores
    public String ListaAlumnoProfesor;
    private String direccion;
    private String telefono; 

    public Alumno(String telefono) {
        this.telefono = telefono;
    }

    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

    public Alumno(String fechaAlta, String ListaAlumnoProfesor) {
        super();
        this.fechaAlta = fechaAlta;
        this.ListaAlumnoProfesor = ListaAlumnoProfesor;
    }

    public Alumno() {
        super();
    }

    
    
    public Alumno(String nombre, String apellidos, int edad, String fechaAlta, String ListaAlumnoProfesor) {
        super(nombre, apellidos, edad);
        this.fechaAlta = fechaAlta;
        this.ListaAlumnoProfesor = ListaAlumnoProfesor;
    }

    
    public String getListaAlumnoProfesor() {
        return ListaAlumnoProfesor;
    }

    public String setListaAlumnoProfesor() {
        this.ListaAlumnoProfesor = ListaAlumnoProfesor;
        return null;
    }

    
    public void setListaAlumnoProfesor(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getidalumno() {
        return idalumno;
    }

    public void setidalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setidAlumno(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    
}
