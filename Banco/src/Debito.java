import java.math.BigDecimal;
import java.math.RoundingMode;

public class Debito extends BankAccount {
    private BigDecimal porcentajeInteres;

    public Debito(BigDecimal initialBalance, BigDecimal porcentajeInteres) {
        super(initialBalance, true);
        if (initialBalance.setScale(2, RoundingMode.HALF_EVEN).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La cuenta débito no puede iniciarse con saldo negativo.");
        }
        this.porcentajeInteres = porcentajeInteres.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getPorcentajeInteres() { return porcentajeInteres; }
    public void setPorcentajeInteres(BigDecimal porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public void deposito(BigDecimal amount) {
        if (!isActive()) throw new IllegalStateException("Cuenta inactiva.");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Monto inválido.");
        setBalance(getBalance().add(amount));
    }

    @Override
    public void retiro(BigDecimal amount) {
        if (!isActive()) throw new IllegalStateException("Cuenta inactiva.");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Monto inválido.");
        BigDecimal newBalance = getBalance().subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("No se puede retirar: saldo insuficiente (no permitido saldo negativo).");
        }
        setBalance(newBalance);
    }

    @Override
    public void pago(BigDecimal amount) {
        retiro(amount);
    }

    public void generarInteres() {
        if (!isActive()) throw new IllegalStateException("Cuenta inactiva.");
        BigDecimal factor = porcentajeInteres.divide(new BigDecimal("100"));
        BigDecimal intereses = getBalance().multiply(factor).setScale(2, RoundingMode.HALF_EVEN);
        setBalance(getBalance().add(intereses));
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", porcentajeInteres=" + porcentajeInteres +
                "}";
    }
}
