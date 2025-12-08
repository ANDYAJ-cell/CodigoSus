package model;

public class PagoSimple implements ProcesadorPagos {

    public boolean procesar(double monto) {
        System.out.println("Procesando pago simulado de $" + monto);
        return true;
    }
}
