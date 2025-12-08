package model;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String numeroVuelo;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private Avion avion;
    private String fechaHora;
    private List<Ticket> tickets = new ArrayList<>();

    public Vuelo(String numeroVuelo, Aeropuerto origen, Aeropuerto destino, Avion avion, String fechaHora) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.avion = avion;
        this.fechaHora = fechaHora;
    }

    public void agregarTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return List.copyOf(tickets);
    }

    public String toString() {
        return numeroVuelo + " | " + origen + " → " + destino + " | " + fechaHora;
    }

    public Avion getAvion() {
        return null;
    }

    public String getNumeroVuelo() {
        return "";
    }

    public Aeropuerto getOrigen() {
        return null;
    }

    public Aeropuerto getDestino() {
        return null;
    }

    public String getFechaHora() {
        return "";
    }
}
