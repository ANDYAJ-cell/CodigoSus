import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente extends Usuario {
    private String sexo;
    private String profesion;
    private String direccion;
    private final List<BankAccount> cuentas;

    public Cliente(String nombreCompleto, String cedula, String correoElectronico, String contrasenia,
                  String sexo, String profesion, String direccion) {
        super(nombreCompleto, cedula, correoElectronico, contrasenia);
        this.sexo = sexo;
        this.profesion = profesion;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }


    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getProfesion() { return profesion; }
    public void setProfesion(String profesion) { this.profesion = profesion; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<BankAccount> getCuentas() { return new ArrayList<>(cuentas); }


    public void addCuenta(BankAccount cuenta) {
        if (cuenta != null) cuentas.add(cuenta);
    }

    public void removeCuenta(BankAccount cuenta) {
        cuentas.remove(cuenta);
    }


    public BigDecimal saldoConsolidado() {
        BigDecimal total = BigDecimal.ZERO.setScale(2);
        for (BankAccount c : cuentas) total = total.add(c.getBalance());
        return total;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", cedula='" + getCedula() + '\'' +
                ", correoElectronico='" + getCorreo() + '\'' +
                ", sexo='" + sexo + '\'' +
                ", profesion='" + profesion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numCuentas=" + cuentas.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getCedula(), cliente.getCedula());
    }


}
