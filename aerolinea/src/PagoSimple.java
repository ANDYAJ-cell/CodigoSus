public class PagoSimple implements ProcesadorPago {

    @Override
    public boolean procesarPago(double monto, String detalles) {
        if (monto <= 0) {
            System.out.println("Monto inválido para pago: " + monto);
            return false;
        }
        if (detalles == null || detalles.trim().isEmpty()) {
            System.out.println("Detalles de pago inválidos.");
            return false;
        }
        // Simulación: imprimimos y devolvemos aprobado
        System.out.println("Procesando pago de $" + monto + " con detalles: " + detalles);
        System.out.println("Pago aprobado (simulado).");
        return true;
    }
}
