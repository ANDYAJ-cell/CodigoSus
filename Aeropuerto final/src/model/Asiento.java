package model;

public class Asiento {
    private String numero;
    private String clase;
    private boolean disponible = true;

    public Asiento(String numero, String clase) {
        this.numero = numero;
        this.clase = clase;
    }

    public boolean isDisponible() { return disponible; }

    public void reservar() {
        this.disponible = false;
    }

    public String toString() {
        return numero + " (" + clase + ") - " + (disponible ? "Libre" : "Ocupado");
    }
}
