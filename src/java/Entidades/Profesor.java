
package Entidades;


public class Profesor extends Persona{
    
    private int idprofesor;
    private String direccion;
    private String telefono;
 
    private String ListaProfesorAsignatura;

        public Profesor() {
            super();
    }
    
    public Profesor(String direccion, String telefono, int idprofesor, String ListaProfesorAsignatura, String nombre, String apellidos, int edad) {
        super(nombre, apellidos, edad);
        this.direccion = direccion;
        this.telefono = telefono;
        this.idprofesor = idprofesor;
        this.ListaProfesorAsignatura = ListaProfesorAsignatura;
    }

    public String getListaProfesorAsignatura() {
        return ListaProfesorAsignatura;
    }

    public String setListaProfesorAsignatura() {
        this.ListaProfesorAsignatura = ListaProfesorAsignatura;
        return null;
    }

    public void setListaProfesorAsignatura(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public int getidprofesor() {
        return idprofesor;
    }

    public void idprofesor(int idProfesor) {
        this.idprofesor = idProfesor;
    }

    public void setidProfesor(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


    }
    
    
  
    

