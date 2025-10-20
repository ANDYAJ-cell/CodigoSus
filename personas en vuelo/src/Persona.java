// Clase Estudiante
class Estudiante {
    private String nombre;
    private int id;

    public Estudiante(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}

// Clase Universidad (Agregación con Estudiantes)
import java.util.List;

class Universidad {
    private String nombre;
    private List<Estudiante> estudiantes; // Agregación: la universidad tiene estudiantes

    public Universidad(String nombre, List<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
    }

    public void mostrarEstudiantes() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Lista de estudiantes:");
        for (Estudiante e : estudiantes) {
            System.out.println(" - " + e.getNombre() + " (ID: " + e.getId() + ")");
        }
    }
}

// Clase principal con el main
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creamos estudiantes (existen independientemente de la universidad)
        Estudiante e1 = new Estudiante("Ana", 101);
        Estudiante e2 = new Estudiante("Luis", 102);
        Estudiante e3 = new Estudiante("María", 103);

        // Los agrupamos en una lista
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add(e1);
        listaEstudiantes.add(e2);
        listaEstudiantes.add(e3);

        // Creamos la universidad y le asociamos los estudiantes
        Universidad uni = new Universidad("Universidad Nacional", listaEstudiantes);

        // Mostramos los estudiantes asociados a la universidad
        uni.mostrarEstudiantes();
    }
}
