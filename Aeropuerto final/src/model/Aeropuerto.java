package model;

public class Aeropuerto {
    private String codigo;
    private String nombre;
    private String ciudad;

    public Aeropuerto(String codigo, String nombre, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }

    public String toString() {
        return codigo + " - " + nombre + " (" + ciudad + ")";
    }
}
