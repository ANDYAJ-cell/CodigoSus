package model;

public class Pasajero {
    private String nombre;
    private String pasaporte;
    private String contacto;

    public Pasajero(String nombre, String pasaporte, String contacto) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.contacto = contacto;
    }

    public String getNombre() { return nombre; }
    public String getPasaporte() { return pasaporte; }

    public String toString() {
        return nombre + " - " + pasaporte;
    }
}
