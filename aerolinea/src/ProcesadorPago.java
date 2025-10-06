public interface ProcesadorPago {
    // devuelve true si el pago fue aprobado
    boolean procesarPago(double monto, String detalles);
}
