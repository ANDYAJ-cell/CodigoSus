package tl;

import bl.VueloBL;
import model.Vuelo;

import java.util.List;

public class VueloController {

    private VueloBL bl = new VueloBL();

    public void agregarVuelo(Vuelo vuelo) {
        try {
            bl.registrar(vuelo);
            System.out.println("Vuelo registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar vuelo: " + e.getMessage());
        }
    }

    public void mostrarVuelos() {
        try {
            List<Vuelo> lista = bl.obtenerTodos();
            lista.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar vuelos: " + e.getMessage());
        }
    }
}
