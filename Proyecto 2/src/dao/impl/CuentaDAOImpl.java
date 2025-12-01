package dao.impl;

import dao.CuentaDAO;
import model.Cuenta;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAOImpl implements CuentaDAO {

    public void save(Cuenta c) throws Exception {
        String sql = "INSERT INTO cuenta(numeroCuenta,tipo,saldo,activa,cliente_id,porcentajeInteres,limiteCredito,tipoCredito) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNumeroCuenta());
            ps.setString(2, c.getTipo());
            ps.setDouble(3, c.getSaldo());
            ps.setBoolean(4, c.isActiva());
            ps.setInt(5, c.getClienteId());
            if (c.getPorcentajeInteres() == null) ps.setNull(6, Types.DOUBLE);
            else ps.setDouble(6, c.getPorcentajeInteres());
            if (c.getLimiteCredito() == null) ps.setNull(7, Types.DOUBLE);
            else ps.setDouble(7, c.getLimiteCredito());
            if (c.getTipoCredito() == null) ps.setNull(8, Types.VARCHAR);
            else ps.setString(8, c.getTipoCredito());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                }
            }
        }
    }

    public Cuenta findByNumero(String numero) throws Exception {
        String sql = "SELECT * FROM cuenta WHERE numeroCuenta=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, numero);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        }
        return null;
    }

    public List<Cuenta> findByClienteId(int clienteId) throws Exception {
        List<Cuenta> list = new ArrayList<>();
        String sql = "SELECT * FROM cuenta WHERE cliente_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, clienteId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        }
        return list;
    }

    public void update(Cuenta c) throws Exception {
        String sql = "UPDATE cuenta SET saldo=?, activa=? WHERE numeroCuenta=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, c.getSaldo());
            ps.setBoolean(2, c.isActiva());
            ps.setString(3, c.getNumeroCuenta());
            ps.executeUpdate();
        }
    }

    public List<Cuenta> findAll() throws Exception {
        List<Cuenta> list = new ArrayList<>();
        String sql = "SELECT * FROM cuenta";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        }
        return list;
    }

    private Cuenta map(ResultSet rs) throws SQLException {
        return new Cuenta(
                rs.getInt("id"),
                rs.getString("numeroCuenta"),
                rs.getString("tipo"),
                rs.getDouble("saldo"),
                rs.getBoolean("activa"),
                rs.getInt("cliente_id"),
                rs.getObject("porcentajeInteres") == null ? null : rs.getDouble("porcentajeInteres"),
                rs.getObject("limiteCredito") == null ? null : rs.getDouble("limiteCredito"),
                rs.getString("tipoCredito")
        );
    }
}
