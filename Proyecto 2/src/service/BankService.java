package service;

import dao.ClienteDAO;
import dao.CuentaDAO;
import dao.AdministradorDAO;
import dao.impl.ClienteDAOImpl;
import dao.impl.CuentaDAOImpl;
import dao.impl.AdministradorDAOImpl;
import model.Cliente;
import model.Cuenta;

import java.util.List;

public class BankService {
    private ClienteDAO clienteDAO = new ClienteDAOImpl();
    private CuentaDAO cuentaDAO = new CuentaDAOImpl();
    private AdministradorDAO adminDAO = new AdministradorDAOImpl();

    // Admin login
    public boolean validarAdmin(String email, String password) throws Exception {
        return adminDAO.findByEmailAndPassword(email, password) != null;
    }

    public void registrarCliente(Cliente c) throws Exception {
        clienteDAO.save(c);
    }

    public Cliente loginCliente(String email, String password) throws Exception {
        return clienteDAO.findByEmailAndPassword(email, password);
    }

    public void crearCuenta(Cuenta c) throws Exception {
        // Validaciones según tipo
        String tipo = c.getTipo();
        if ("AHORRO".equals(tipo)) {
            if (c.getSaldo() < 100.0) throw new IllegalArgumentException("Cuenta ahorro debe iniciar >= 100");
        } else if ("DEBITO".equals(tipo)) {
            if (c.getSaldo() < 0.0) throw new IllegalArgumentException("Cuenta débito saldo inicial inválido");
        } else if ("CREDITO".equals(tipo)) {
            if (c.getSaldo() != 0.0) throw new IllegalArgumentException("Cuenta crédito debe iniciar con saldo 0");
            if (c.getLimiteCredito() == null || c.getLimiteCredito() <= 0) throw new IllegalArgumentException("Límite de crédito inválido");
        } else {
            throw new IllegalArgumentException("Tipo de cuenta desconocido");
        }
        cuentaDAO.save(c);
    }

    public List<Cliente> listarClientes() throws Exception {
        return clienteDAO.findAll();
    }

    public List<Cuenta> cuentasDeCliente(int clienteId) throws Exception {
        return cuentaDAO.findByClienteId(clienteId);
    }

    public Cuenta buscarCuenta(String numero) throws Exception {
        return cuentaDAO.findByNumero(numero);
    }

    public void depositar(String numeroCuenta, double monto) throws Exception {
        Cuenta c = cuentaDAO.findByNumero(numeroCuenta);
        if (c == null) throw new IllegalArgumentException("Cuenta no encontrada");
        if (!c.isActiva()) throw new IllegalStateException("Cuenta inactiva");
        String tipo = c.getTipo();
        if ("CREDITO".equals(tipo)) throw new IllegalArgumentException("No se permiten depósitos en cuenta crédito (usar abonar)");
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
        c.setSaldo(c.getSaldo() + monto);
        cuentaDAO.update(c);
    }

    public void retirar(String numeroCuenta, double monto) throws Exception {
        Cuenta c = cuentaDAO.findByNumero(numeroCuenta);
        if (c == null) throw new IllegalArgumentException("Cuenta no encontrada");
        if (!c.isActiva()) throw new IllegalStateException("Cuenta inactiva");
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");

        String tipo = c.getTipo();
        if ("AHORRO".equals(tipo)) {
            double nuevo = c.getSaldo() - monto;
            if (nuevo < 100.0) throw new IllegalArgumentException("No puede dejar la cuenta de ahorro por debajo de 100");
            c.setSaldo(nuevo);
        } else if ("DEBITO".equals(tipo)) {
            double nuevo = c.getSaldo() - monto;
            if (nuevo < 0.0) throw new IllegalArgumentException("Saldo insuficiente en cuenta débito");
            c.setSaldo(nuevo);
        } else if ("CREDITO".equals(tipo)) {
            // retirar en crédito significa usar crédito (saldo negativo)
            double nuevo = c.getSaldo() - monto; // saldo - monto (ej: 0 - 100 => -100)
            double limite = c.getLimiteCredito() == null ? 0.0 : c.getLimiteCredito();
            if (Math.abs(nuevo) > limite) throw new IllegalArgumentException("Excede límite de crédito");
            c.setSaldo(nuevo);
        }
        cuentaDAO.update(c);
    }

    public void abonarCredito(String numeroCuenta, double monto) throws Exception {
        Cuenta c = cuentaDAO.findByNumero(numeroCuenta);
        if (c == null) throw new IllegalArgumentException("Cuenta no encontrada");
        if (!"CREDITO".equals(c.getTipo())) throw new IllegalArgumentException("Cuenta no es de tipo crédito");
        if (!c.isActiva()) throw new IllegalStateException("Cuenta inactiva");
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
        double nuevo = c.getSaldo() + monto;
        if (nuevo > 0) throw new IllegalArgumentException("Abono imposible: dejaría saldo positivo en cuenta crédito");
        c.setSaldo(nuevo);
        cuentaDAO.update(c);
    }

    public void generarIntereses(String numeroCuenta) throws Exception {
        Cuenta c = cuentaDAO.findByNumero(numeroCuenta);
        if (c == null) throw new IllegalArgumentException("Cuenta no encontrada");
        if (!c.isActiva()) throw new IllegalStateException("Cuenta inactiva");
        if (c.getPorcentajeInteres() == null || c.getPorcentajeInteres() <= 0) return;
        double interes = c.getSaldo() * c.getPorcentajeInteres();
        c.setSaldo(c.getSaldo() + interes);
        cuentaDAO.update(c);
    }
}
