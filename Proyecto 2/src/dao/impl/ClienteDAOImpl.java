package dao.impl;

import dao.ClienteDAO;
import model.Cliente;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    public void save(Cliente c) throws Exception {
        String sql = "INSERT INTO cliente(nombreCompleto, cedula, correoElectronico, contrasenia, sexo, profesion, direccion) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNombreCompleto());
            ps.setString(2, c.getCedula());
            ps.setString(3, c.getCorreoElectronico());
            ps.setString(4, c.getContrasenia());
            ps.setString(5, c.getSexo());
            ps.setString(6, c.getProfesion());
            ps.setString(7, c.getDireccion());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) c.setId(rs.getInt(1));
            }
        }
    }

    public Cliente findByEmailAndPassword(String email, String password) throws Exception {
        String sql = "SELECT * FROM cliente WHERE correoElectronico=? AND contrasenia=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    public Cliente findById(int id) throws Exception {
        String sql = "SELECT * FROM cliente WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        }
        return null;
    }

    public List<Cliente> findAll() throws Exception {
        List<Cliente> list = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }

    private Cliente map(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getInt("id"),
                rs.getString("nombreCompleto"),
                rs.getString("cedula"),
                rs.getString("correoElectronico"),
                rs.getString("contrasenia"),
                rs.getString("sexo"),
                rs.getString("profesion"),
                rs.getString("direccion")
        );
    }
}
