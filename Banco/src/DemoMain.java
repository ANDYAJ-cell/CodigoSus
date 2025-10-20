import java.math.BigDecimal;

public class DemoMain {
    public static void main(String[] args) {
        System.out.println("=== Demo: Entidades del sistema bancario ===");


        Administrador administrador = new Administrador("María López", "310112233", "admin@banco.com", "admin123");
        System.out.println("Administrador creado: " + administrador);


        Cliente cliente = new Cliente("Juan Pérez", "101010101", "juan@correo.com", "clave",
                "M", "Ingeniero", "San José");
        System.out.println("Cliente creado: " + cliente);

        Ahorros sa = new Ahorros(new BigDecimal("150.00"), new BigDecimal("1.5"));
        Debito da = new Debito(new BigDecimal("50.00"), new BigDecimal("0.5"));
        Credito ca = new Credito(new BigDecimal("1000.00"), "Cashback");

        cliente.addCuenta(sa);
        cliente.addCuenta(da);
        cliente.addCuenta(ca);

        System.out.println("\n-- Estado inicial de las cuentas del cliente --");
        for (BankAccount b : cliente.getCuentas()) {
            System.out.println(b);
        }
        System.out.println("Saldo consolidado: " + cliente.saldoConsolidado());

        System.out.println("\n-- Operaciones: depositos, retiros, pagos, abonos, intereses --");
        sa.deposito(new BigDecimal("200.00"));
        da.deposito(new BigDecimal("150.00"));
        ca.retiro(new BigDecimal("300.00"));


        sa.generarInteres();
        da.generarInteres();

        System.out.println("\n-- Estado después de operaciones --");
        for (BankAccount b : cliente.getCuentas()) {
            System.out.println(b);
        }
        System.out.println("Saldo consolidado: " + cliente.saldoConsolidado());


        System.out.println("\n-- Intento de operación inválida (capturada) --");
        try {
            sa.retiro(new BigDecimal("500.00"));
        } catch (Exception e) {
            System.out.println("Se capturó excepción al retirar de ahorro: " + e.getMessage());
        }

        try {
            da.retiro(new BigDecimal("1000.00"));
        } catch (Exception e) {
            System.out.println("Se capturó excepción al retirar de débito: " + e.getMessage());
        }

        try {
            ca.pago(new BigDecimal("400.00"));
        } catch (Exception e) {
            System.out.println("Se capturó excepción al abonar en crédito: " + e.getMessage());
        }

        try {
            ca.pago(new BigDecimal("200.00"));
            System.out.println("Abono válido realizado en cuenta de crédito.");
        } catch (Exception e) {
            System.out.println("Error en abono de crédito: " + e.getMessage());
        }

        System.out.println("\n-- Estado final de las cuentas --");
        for (BankAccount b : cliente.getCuentas()) {
            System.out.println(b);
        }
        System.out.println("Saldo consolidado final: " + cliente.saldoConsolidado());

        System.out.println("=== Demo finalizado ===");
    }
}
