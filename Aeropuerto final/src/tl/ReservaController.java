package tl;

import bl.ReservaBL;
import model.Reserva;

public class ReservaController {

    private ReservaBL bl = new ReservaBL();

    public void agregarReserva(Reserva reserva) {
        try {
            bl.registrar(reserva);
            System.out.println("Reserva registrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar reserva: " + e.getMessage());
        }
    }
}
