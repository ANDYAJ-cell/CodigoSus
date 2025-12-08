package dl;

import model.Reserva;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservaDAO {

    public void insertar(Reserva reserva) throws Exception {
        Connection conn = DBConnection.getConnection();

        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO reservas (vuelo, pasajero, precio) VALUES (?, ?, ?)"
        );

        stmt.setString(1, reserva.getVuelo().equals());
        stmt.setString(2, reserva.getPasajero().getPasaporte());
        stmt.setDouble(3, reserva.getTicket().getPrecio());

        stmt.executeUpdate();
        conn.close();
    }
}
