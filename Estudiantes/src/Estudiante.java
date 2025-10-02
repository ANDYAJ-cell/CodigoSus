public class Estudiante {
    private String nombre;
    private int ID;

    public Estudiante(String nombre, int ID) {
        this.nombre = nombre;
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }
}
