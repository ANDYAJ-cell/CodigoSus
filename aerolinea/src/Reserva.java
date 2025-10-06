public class Reserva {
    private Pasajero pasajero;
    private Vuelo vuelo;
    private Tiquete tiquete;
    private ProcesadorPago procesador;

    public Reserva(Pasajero pasajero, Vuelo vuelo, ProcesadorPago procesador) {
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.procesador = procesador;
    }

    // Intenta reservar un asiento pagando con procesador; devuelve true si ok
    public boolean realizarReserva(String numeroAsiento, double precio, String detallesPago) {
        // Procesar pago (dependencia)
        boolean aprobado = procesador.procesarPago(precio, detallesPago);
        if (!aprobado) {
            System.out.println("Pago rechazado. Reserva no realizada.");
            return false;
        }
        // Vender tiquete (el vuelo crea el Tiquete y marca asiento como reservado)
        Tiquete t = vuelo.venderTiquete(pasajero, numeroAsiento, precio);
        if (t == null) {
            System.out.println("No se pudo crear tiquete (asiento inválido o no disponible).");
            return false;
        }
        this.tiquete = t;
        System.out.println("Reserva realizada correctamente. ID tiquete: " + t.getId());
        return true;
    }

    public void mostrarReserva() {
        if (tiquete == null) {
            System.out.println("No hay reserva para mostrar.");
            return;
        }
        System.out.println("=== RESERVA ===");
        System.out.println("Pasajero: " + pasajero.getNombre());
        System.out.println("Vuelo: " + vuelo.getCodigo());
        System.out.println("Asiento: " + tiquete.getAsiento().getNumero());
        System.out.println("Precio: $" + tiquete.getPrecio());
        System.out.println("Tiquete ID: " + tiquete.getId());
        System.out.println("===============");
    }

    public Tiquete getTiquete() {
        return tiquete;
    }
}
