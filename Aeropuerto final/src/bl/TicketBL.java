package bl;

import dl.TicketDAO;
import model.Ticket;

public class TicketBL {

    private TicketDAO dao = new TicketDAO();

    public void registrar(Ticket ticket, String numeroVuelo) throws Exception {
        dao.insertar(ticket, numeroVuelo);
    }
}
