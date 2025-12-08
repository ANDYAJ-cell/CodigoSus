package model;

import java.util.ArrayList;
import java.util.List;

public class Avion {
    private String modelo;
    private String matricula;
    private List<Asiento> asientos;

    public Avion(String modelo, String matricula, int cantidadAsientos) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.asientos = new ArrayList<>();

        for (int i = 1; i <= cantidadAsientos; i++) {
            asientos.add(new Asiento("A" + i, "Economico"));
        }
    }

    public List<Asiento> getAsientos() {
        return List.copyOf(asientos);
    }

    public String toString() {
        return modelo + " (" + matricula + ")";
    }

    public String getMatricula() {
        return null;
    }

    public String getModelo() {
        return null;
    }
}
