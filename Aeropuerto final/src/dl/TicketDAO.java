package dl;

import model.Ticket;
import utils.DBConnection;

import java.sql.*;

public class TicketDAO {

    public void insertar(Ticket ticket, String numeroVuelo) throws Exception {
        Connection conn = DBConnection.getConnection();

        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO tickets (vuelo, pasajero, asiento, precio) VALUES (?, ?, ?, ?)"
        );

        stmt.setString(1, numeroVuelo);
        stmt.setString(2, ticket.getPasajero().getPasaporte());
        stmt.setString(3, String.valueOf(ticket.getAsiento().getClass()));
        stmt.setDouble(4, ticket.getPrecio());

        stmt.executeUpdate();
        conn.close();
    }
}
