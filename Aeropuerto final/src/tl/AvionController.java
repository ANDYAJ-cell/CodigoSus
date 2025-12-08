package tl;

import bl.AvionBL;
import model.Avion;

import java.util.List;

public class AvionController {

    private AvionBL bl = new AvionBL();

    public void agregarAvion(String modelo, String matricula, int cantidadAsientos) {
        try {
            bl.registrar(new Avion(modelo, matricula, cantidadAsientos));
            System.out.println("Avión registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar avión: " + e.getMessage());
        }
    }

    public void mostrarAviones() {
        try {
            List<Avion> lista = bl.obtenerTodos();
            lista.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar aviones: " + e.getMessage());
        }
    }
}
