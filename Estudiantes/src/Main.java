public class Main {
    public static void main(String[] args) {
        // Crear estudiantes
        Estudiante e1 = new Estudiante("Ana", 101);
        Estudiante e2 = new Estudiante("Luis", 102);
        Estudiante e3 = new Estudiante("María", 103);

        // Crear universidad con un solo estudiante
        Uni uni = new Uni("Universidad Técnica", e1);

        // Mostrar info
        uni.mostrarEstudiante();
    }
}
