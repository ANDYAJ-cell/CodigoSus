package model;

public class Ticket {
    private Pasajero pasajero;
    private Asiento asiento;
    private double precio;

    public Ticket(Pasajero pasajero, Asiento asiento, double precio) {
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.precio = precio;
    }

    public String toString() {
        return "Ticket: " + pasajero + " / Asiento: " + asiento + " / $" + precio;
    }

    public double getPrecio() {
        return 0;
    }

    public Pasajero getPasajero() {
        return null;
    }

    public Object getAsiento() {
        return null;
    }
}
