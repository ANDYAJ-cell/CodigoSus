public class Asiento {
    private String numero;
    private Clase clase;
    private boolean disponible;

    public Asiento(String numero, Clase clase) {
        this.numero = numero;
        this.clase = clase;
        this.disponible = true;
    }

    public String getNumero() {
        return numero;
    }

    public Clase getClase() {
        return clase;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void reservar() {
        if (!disponible) {
            throw new IllegalStateException("Asiento ya reservado: " + numero);
        }
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    public String toString() {
        return numero + " (" + clase + ") - " + (disponible ? "Disponible" : "Ocupado");
    }
}
