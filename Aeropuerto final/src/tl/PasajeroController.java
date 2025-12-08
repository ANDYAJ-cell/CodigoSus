package tl;

import bl.PasajeroBL;
import model.Pasajero;

public class PasajeroController {
    private PasajeroBL bl = new PasajeroBL();

    public void agregarPasajero(String nombre, String pasaporte, String contacto) {
        try {
            bl.registrarPasajero(new Pasajero(nombre, pasaporte, contacto));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarPasajeros() {

    }
}
