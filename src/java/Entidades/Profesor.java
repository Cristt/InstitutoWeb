
package Entidades;


public class Profesor{
    
    private int idprofesor;
    private String nombre;
    private String apellido;
 
    private String ListaProfesorAsignatura;

    public Profesor(int idprofesor, String nombre, String apellido, String ListaProfesorAsignatura) {
        super ();
        this.idprofesor = idprofesor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ListaProfesorAsignatura = ListaProfesorAsignatura;
    }

    public Profesor() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getListaProfesorAsignatura() {
        return ListaProfesorAsignatura;
    }

    public void setListaProfesorAsignatura(String ListaProfesorAsignatura) {
        this.ListaProfesorAsignatura = ListaProfesorAsignatura;
    }
    
    
}
    
  
    

