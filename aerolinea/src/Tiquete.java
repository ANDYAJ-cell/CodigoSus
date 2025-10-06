public class Tiquete {
    private String id;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private Asiento asiento;
    private double precio;

    public Tiquete(String id, Pasajero pasajero, Vuelo vuelo, Asiento asiento, double precio) {
        this.id = id;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public String toString() {
        return "Tiquete{" +
                "id='" + id + '\'' +
                ", pasajero=" + pasajero.getNombre() +
                ", vuelo=" + vuelo.getCodigo() +
                ", asiento=" + asiento.getNumero() +
                ", precio=" + precio +
                '}';
    }
}
