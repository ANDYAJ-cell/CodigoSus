import java.math.BigDecimal;
import java.math.RoundingMode;

public class Credito extends BankAccount {
    private final BigDecimal limiteCredito;
    private final String tipo;
    public Credito(BigDecimal limiteCredito, String tipo) {
        super(BigDecimal.ZERO, true);
        if (limiteCredito.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Límite de crédito debe ser positivo.");
        }
        this.limiteCredito = limiteCredito.setScale(2, RoundingMode.HALF_EVEN);
        this.tipo = tipo;
    }

    public BigDecimal getLimiteCredito() { return limiteCredito; }
    public String getTipo() { return tipo; }

    @Override
    public void deposito(BigDecimal amount) {
        throw new UnsupportedOperationException("Las cuentas de crédito no aceptan depósitos directos. Use payment/abono para reducir deuda.");
    }

    @Override
    public void retiro(BigDecimal amount) {
        if (!isActive()) throw new IllegalStateException("Cuenta inactiva.");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Monto inválido.");
        BigDecimal newBalance = getBalance().subtract(amount).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal limiteNegativo = limiteCredito.negate();
        if (newBalance.compareTo(limiteNegativo) < 0) {
            throw new IllegalStateException("No se puede retirar: se excede el límite de crédito.");
        }
        setBalance(newBalance);
    }

    @Override
    public void pago(BigDecimal amount) {
        if (!isActive()) throw new IllegalStateException("Cuenta inactiva.");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Monto inválido.");
        BigDecimal newBalance = getBalance().add(amount).setScale(2, RoundingMode.HALF_EVEN);
        if (newBalance.compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalStateException("No se puede abonar: el saldo de una cuenta de crédito no puede ser positivo.");
        }
        setBalance(newBalance);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", tipo='" + tipo + '\'' +
                ", limiteCredito=" + limiteCredito +
                "}";
    }
}
