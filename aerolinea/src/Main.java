public class Main {
    public static void main(String[] args) {
        // Crear aeropuertos
        Aeropuerto sjc = new Aeropuerto("SJC", "Juan Santamaría", "San José");
        Aeropuerto mia = new Aeropuerto("MIA", "Miami Intl", "Miami");

        // Mostrar aeropuertos
        sjc.mostrar();
        mia.mostrar();
        System.out.println();

        // Crear aviones
        Avion avion1 = new Avion("TI-ABC", "Boeing 737", 5, 4); // 5 filas x 4 asientos = 20 asientos
        Avion avion2 = new Avion("TI-XYZ", "Airbus A320", 4, 3); // 12 asientos

        // Crear vuelos
        Vuelo vuelo1 = new Vuelo("AE101", sjc, mia, "10/11/2025 08:30", avion1);
        Vuelo vuelo2 = new Vuelo("AE202", mia, sjc, "11/11/2025 14:00", avion2);

        // Mostrar vuelos
        vuelo1.mostrarInfo();
        vuelo2.mostrarInfo();
        System.out.println();

        // Crear pasajero
        Pasajero p = new Pasajero("Andy Arias", "119680562");

        // Crear procesador de pago simple (inyección de dependencia)
        ProcesadorPago procesador = new PagoSimple();

        // Crear reserva
        Reserva reserva = new Reserva(p, vuelo1, procesador);

        // Intentar reservar el asiento "3A" por $300
        boolean exito = reserva.realizarReserva("3A", 300.0, "VISA **** 1234");
        System.out.println();

        if (exito) {
            reserva.mostrarReserva();
            System.out.println();
            vuelo1.mostrarTiquetesVendidos();
            System.out.println();
            System.out.println("Estado de asientos del avión luego de la reserva:");
            avion1.mostrarAsientos();
        } else {
            System.out.println("Reserva fallida.");
        }
    }
}
