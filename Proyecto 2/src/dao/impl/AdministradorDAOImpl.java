package dao.impl;

import dao.AdministradorDAO;
import model.Administrador;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministradorDAOImpl implements AdministradorDAO {

    public Administrador findByEmailAndPassword(String email, String password) throws Exception {
        String sql = "SELECT id, nombreCompleto, cedula, correoElectronico, contrasenia FROM administrador WHERE correoElectronico=? AND contrasenia=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Administrador(
                            rs.getInt("id"),
                            rs.getString("nombreCompleto"),
                            rs.getString("cedula"),
                            rs.getString("correoElectronico"),
                            rs.getString("contrasenia")
                    );
                }
            }
        }
        return null;
    }

    public void save(Administrador admin) throws Exception {
        String sql = "INSERT INTO administrador(nombreCompleto, cedula, correoElectronico, contrasenia) VALUES(?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, admin.getNombreCompleto());
            ps.setString(2, admin.getCedula());
            ps.setString(3, admin.getCorreoElectronico());
            ps.setString(4, admin.getContrasenia());
            ps.executeUpdate();
        }
    }
}
