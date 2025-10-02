public class Uni {
    private String nombre;
    private Estudiante estudiante; // solo un estudiante

    public Uni(String nombre, Estudiante estudiante) {
        this.nombre = nombre;
        this.estudiante = estudiante;
    }

    public void mostrarEstudiante() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Estudiante asociado: "
                + estudiante.getNombre()
                + " (ID: " + estudiante.getID() + ")");
    }
}
