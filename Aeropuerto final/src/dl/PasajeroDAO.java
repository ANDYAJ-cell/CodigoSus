package dl;

import model.Pasajero;
import utils.DBConnection;
import java.sql.*;

public class PasajeroDAO {

    public void insertar(Pasajero p) throws Exception {
        Connection conn = DBConnection.getConnection();

        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO pasajeros (nombre, pasaporte, contacto) VALUES (?, ?, ?)"
        );

        stmt.setString(1, p.getNombre());
        stmt.setString(2, p.getPasaporte());
        stmt.setString(3, p.getPasaporte());

        stmt.executeUpdate();
        conn.close();
    }
}
