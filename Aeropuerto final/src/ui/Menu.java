package ui;

import model.*;
import tl.*;

import java.util.Scanner;

public class Menu {

    private static final Scanner input = new Scanner(System.in);

    private static final PasajeroController pasajeroCtrl = new PasajeroController();
    private static final AvionController avionCtrl = new AvionController();
    private static final VueloController vueloCtrl = new VueloController();
    private static final ReservaController reservaCtrl = new ReservaController();

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarPasajero();
                case 2 -> registrarAvion();
                case 3 -> registrarVuelo();
                case 4 -> registrarReserva();
                case 5 -> listarPasajeros();
                case 6 -> listarAviones();
                case 7 -> listarVuelos();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE AEROLÍNEA ===");
        System.out.println("1. Registrar Pasajero");
        System.out.println("2. Registrar Avión");
        System.out.println("3. Registrar Vuelo");
        System.out.println("4. Registrar Reserva");
        System.out.println("5. Listar Pasajeros");
        System.out.println("6. Listar Aviones");
        System.out.println("7. Listar Vuelos");
        System.out.println("0. Salir");
    }

    private static void registrarPasajero() {
        System.out.println("\n--- Registrar Pasajero ---");
        String nombre = leerTexto("Nombre: ");
        String pasaporte = leerTexto("Pasaporte: ");
        String contacto = leerTexto("Contacto: ");

        pasajeroCtrl.agregarPasajero(nombre, pasaporte, contacto);
    }

    private static void registrarAvion() {
        System.out.println("\n--- Registrar Avión ---");
        String modelo = leerTexto("Modelo: ");
        String matricula = leerTexto("Matrícula: ");
        int asientos = leerEntero("Cantidad de asientos: ");

        avionCtrl.agregarAvion(modelo, matricula, asientos);
    }

    private static void registrarVuelo() {
        System.out.println("\n--- Registrar Vuelo ---");

        String numero = leerTexto("Número de vuelo: ");
        String origenCod = leerTexto("Código aeropuerto origen: ");
        String destinoCod = leerTexto("Código aeropuerto destino: ");
        String fechaHora = leerTexto("Fecha y hora: ");

        Aeropuerto origen = new Aeropuerto(origenCod, "", "");
        Aeropuerto destino = new Aeropuerto(destinoCod, "", "");

        System.out.println("\nAdvertencia: El sistema asignará un avión temporal para este ejemplo.");
        Avion avion = new Avion("A320", "TEMP-001", 10);

        Vuelo vuelo = new Vuelo(numero, origen, destino, avion, fechaHora);

        vueloCtrl.agregarVuelo(vuelo);
    }

    private static void registrarReserva() {
        System.out.println("\n--- Registrar Reserva ---");

        String nombre = leerTexto("Nombre pasajero: ");
        String pasaporte = leerTexto("Pasaporte pasajero: ");
        String contacto = leerTexto("Contacto: ");

        Pasajero pasajero = new Pasajero(nombre, pasaporte, contacto);

        String numeroVuelo = leerTexto("Número de vuelo a reservar: ");

        // Se crea un vuelo de ejemplo
        System.out.println("\nAdvertencia: El avión y el vuelo se toman como demostración.");
        Aeropuerto origen = new Aeropuerto("SJO", "Juan Santamaría", "Alajuela");
        Aeropuerto destino = new Aeropuerto("LIO", "Limón", "Limón");
        Avion avion = new Avion("A320", "TEMP-001", 10);
        Vuelo vuelo = new Vuelo(numeroVuelo, origen, destino, avion, "2025-12-05 14:00");

        ProcesadorPagos pago = new PagoSimple();
        Reserva reserva = new Reserva(vuelo, pasajero, pago, 250.00);

        reservaCtrl.agregarReserva(reserva);

        System.out.println("Ticket generado:");
        System.out.println(reserva.getTicket());
    }

    private static void listarPasajeros() {
        System.out.println("\n--- Lista de Pasajeros ---");
        pasajeroCtrl.mostrarPasajeros();
    }

    private static void listarAviones() {
        System.out.println("\n--- Lista de Aviones ---");
        avionCtrl.mostrarAviones();
    }

    private static void listarVuelos() {
        System.out.println("\n--- Lista de Vuelos ---");
        vueloCtrl.mostrarVuelos();
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!input.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            input.next();
        }
        return input.nextInt();
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return input.next();
    }
}
