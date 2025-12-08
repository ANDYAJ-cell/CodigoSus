package tl;

import bl.TicketBL;
import model.Ticket;

public class TicketController {

    private TicketBL bl = new TicketBL();

    public void agregarTicket(Ticket ticket, String vuelo) {
        try {
            bl.registrar(ticket, vuelo);
            System.out.println("Ticket registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar ticket: " + e.getMessage());
        }
    }
}
