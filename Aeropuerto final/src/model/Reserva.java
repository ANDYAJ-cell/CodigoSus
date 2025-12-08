package model;

public class Reserva {
    private Vuelo vuelo;
    private Pasajero pasajero;
    private Ticket ticket;

    public Reserva(Vuelo vuelo, Pasajero pasajero, ProcesadorPagos procesador, double precio) {
        this.vuelo = vuelo;
        this.pasajero = pasajero;

        if (procesador.procesar(precio)) {
            Asiento asientoLibre = vuelo.getAvion().getAsientos().stream()
                    .filter(Asiento::isDisponible)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No hay asientos disponibles"));

            asientoLibre.reservar();

            ticket = new Ticket(pasajero, asientoLibre, precio);
            vuelo.agregarTicket(ticket);
        }
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Object getVuelo() {
        return null;
    }

    public Pasajero getPasajero() {
        return null;
    }
}
