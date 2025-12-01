package model;

public class Cuenta {
    private int id;
    private String numeroCuenta;
    private String tipo; // AHORRO, DEBITO, CREDITO
    private double saldo;
    private boolean activa;
    private int clienteId;
    private Double porcentajeInteres; // nullable
    private Double limiteCredito;     // nullable
    private String tipoCredito;       // nullable

    public Cuenta() {}

    // constructor conveniente
    public Cuenta(int id, String numeroCuenta, String tipo, double saldo, boolean activa,
                  int clienteId, Double porcentajeInteres, Double limiteCredito, String tipoCredito) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.activa = activa;
        this.clienteId = clienteId;
        this.porcentajeInteres = porcentajeInteres;
        this.limiteCredito = limiteCredito;
        this.tipoCredito = tipoCredito;
    }

    // getters y setters
    public int getId() { return id; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTipo() { return tipo; }
    public double getSaldo() { return saldo; }
    public boolean isActiva() { return activa; }
    public int getClienteId() { return clienteId; }
    public Double getPorcentajeInteres() { return porcentajeInteres; }
    public Double getLimiteCredito() { return limiteCredito; }
    public String getTipoCredito() { return tipoCredito; }

    public void setSaldo(double s) { this.saldo = s; }
    public void setActiva(boolean a) { this.activa = a; }

    @Override
    public String toString() {
        return String.format("Cuenta{id=%d, nro='%s', tipo=%s, saldo=%.2f, activa=%s, clienteId=%d}",
                id, numeroCuenta, tipo, saldo, activa, clienteId);
    }
}
