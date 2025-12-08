package dl;

import model.Avion;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDAO {

    public void insertar(Avion avion) throws Exception {
        Connection conn = DBConnection.getConnection();

        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO aviones (matricula, modelo, cantidad_asientos) VALUES (?, ?, ?)"
        );

        stmt.setString(1, avion.getMatricula());
        stmt.setString(2, avion.getModelo());
        stmt.setInt(3, avion.getAsientos().size());

        stmt.executeUpdate();
        conn.close();
    }

    public List<Avion> obtenerTodos() throws Exception {
        Connection conn = DBConnection.getConnection();
        List<Avion> lista = new ArrayList<>();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM aviones");

        while (rs.next()) {
            Avion avion = new Avion(
                    rs.getString("modelo"),
                    rs.getString("matricula"),
                    rs.getInt("cantidad_asientos")
            );

            lista.add(avion);
        }

        conn.close();
        return lista;
    }
}
