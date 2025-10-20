import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.math.RoundingMode;

public abstract class BankAccount {
    private final String numeroCuenta;
    private boolean activo;
    private BigDecimal balance;
    private final LocalDateTime createdAt;

    public BankAccount(BigDecimal initialBalance, boolean activo) {
        this.numeroCuenta = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.activo = activo;
        this.balance = initialBalance.setScale(2, RoundingMode.HALF_EVEN);
        this.createdAt = LocalDateTime.now();
    }

    // Getters y setters
    public String getAccountNumber() { return numeroCuenta; }
    public boolean isActive() { return activo; }
    public void setActive(boolean active) { this.activo = active; }

    public BigDecimal getBalance() { return balance; }
    protected void setBalance(BigDecimal balance) {
        this.balance = balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public abstract void deposito(BigDecimal amount);
    public abstract void retiro(BigDecimal amount);
    public abstract void pago(BigDecimal amount);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", activo=" + activo +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(numeroCuenta, that.numeroCuenta);
    }


}
