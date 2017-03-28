
package Entidades;


public class Alumno {
    
    private int idalumno;
    private String nombre;
    //Establece relacion alumnos - profesores
    
    private String apellido;
    public String ListaAlumnoProfesor;

    public Alumno() {
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

    public Alumno(int idalumno, String nombre, String apellido, String ListaAlumnoProfesor) {
        super();
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ListaAlumnoProfesor = ListaAlumnoProfesor;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getListaAlumnoProfesor() {
        return ListaAlumnoProfesor;
    }

    public void setListaAlumnoProfesor(String ListaAlumnoProfesor) {
        this.ListaAlumnoProfesor = ListaAlumnoProfesor;
    }
    


    
}
