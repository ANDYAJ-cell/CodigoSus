public class Avion {
    private String matricula;
    private String modelo;
    private Asiento[] asientos; // composición: asientos pertenecen al avión

    public Avion(String matricula, String modelo, int filas, int asientosPorFila) {
        this.matricula = matricula;
        this.modelo = modelo;
        int total = filas * asientosPorFila;
        this.asientos = new Asiento[total];
        generarAsientos(filas, asientosPorFila);
    }

    private void generarAsientos(int filas, int asientosPorFila) {
        // Genera asientos: filas 1..filas, letras A,B,C...
        for (int f = 1; f <= filas; f++) {
            for (int s = 0; s < asientosPorFila; s++) {
                int index = (f - 1) * asientosPorFila + s;
                char letra = (char) ('A' + s);
                String numero = f + "" + letra;
                Clase clase = (f <= 2) ? Clase.EJECUTIVA : Clase.ECONOMICA; // ejemplo simple
                asientos[index] = new Asiento(numero, clase);
            }
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public Asiento[] getAsientos() {
        return asientos;
    }

    public Asiento buscarAsiento(String numero) {
        if (numero == null) return null;
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i] != null && asientos[i].getNumero().equalsIgnoreCase(numero)) {
                return asientos[i];
            }
        }
        return null;
    }

    public void mostrarAsientos() {
        System.out.println("Asientos del avión " + modelo + " (" + matricula + "):");
        for (int i = 0; i < asientos.length; i++) {
            System.out.println(asientos[i].toString());
        }
    }
}
