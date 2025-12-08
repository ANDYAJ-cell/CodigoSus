package dl;

import model.Vuelo;
import model.Aeropuerto;
import model.Avion;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {

    public void insertar(Vuelo vuelo) throws Exception {
        Connection conn = DBConnection.getConnection();

        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO vuelos (numero, origen, destino, avion, fecha_hora) VALUES (?, ?, ?, ?, ?)"
        );

        stmt.setString(1, vuelo.getNumeroVuelo());
        stmt.setString(2, vuelo.getOrigen().getCodigo());
        stmt.setString(3, vuelo.getDestino().getCodigo());
        stmt.setString(4, vuelo.getAvion().getMatricula());
        stmt.setString(5, vuelo.getFechaHora());

        stmt.executeUpdate();
        conn.close();
    }

    public List<Vuelo> obtenerTodos() throws Exception {
        Connection conn = DBConnection.getConnection();
        List<Vuelo> lista = new ArrayList<>();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM vuelos");

        while (rs.next()) {
            // Para construir un Vuelo real necesitarías:
            // buscar AeropuertoDAO y AvionDAO para obtener los objetos completos
            Aeropuerto origen = new Aeropuerto(rs.getString("origen"), "", "");
            Aeropuerto destino = new Aeropuerto(rs.getString("destino"), "", "");
            Avion avion = new Avion("A320", rs.getString("avion"), 10);

            Vuelo vuelo = new Vuelo(
                    rs.getString("numero"),
                    origen,
                    destino,
                    avion,
                    rs.getString("fecha_hora")
            );

            lista.add(vuelo);
        }

        conn.close();
        return lista;
    }
}
