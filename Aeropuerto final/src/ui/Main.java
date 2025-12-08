package ui;

import model.*;
import tl.PasajeroController;

public class Main {
    public static void main(String[] args) {
        Aeropuerto sjo = new Aeropuerto("SJO", "Juan Santamaría", "San José");
        Aeropuerto lio = new Aeropuerto("LIO", "Limon", "Limon");

        Avion avion = new Avion("A320", "TI-ABC", 5);

        Vuelo vuelo = new Vuelo("CR123", sjo, lio, avion, "2025-12-01 12:00");

        PasajeroController ctrl = new PasajeroController();
        ctrl.agregarPasajero("Andy", "P12345", "8888-8888");

        Pasajero pasajero = new Pasajero("Andy", "P12345", "8888-8888");

        Reserva reserva = new Reserva(vuelo, pasajero, new PagoSimple(), 200);

        System.out.println("Reserva realizada:");
        System.out.println(reserva.getTicket());
    }
}
