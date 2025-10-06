public class Pasajero {
    private String nombre;
    private String documento; // cédula o pasaporte

    public Pasajero(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void mostrar() {
        System.out.println("Pasajero: " + nombre + " | Doc: " + documento);
    }
}
