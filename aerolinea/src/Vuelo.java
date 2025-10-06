public class Vuelo {
    private String codigo;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private String fechaHora; // formato simple como String (p.ej. "10/11/2025 08:30")
    private Avion avion;
    private Tiquete[] tiquetes; // colección fija de tiquetes para este vuelo
    private int tiquetesVendidos;

    public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, String fechaHora, Avion avion) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.avion = avion;
        this.tiquetes = new Tiquete[avion.getAsientos().length];
        this.tiquetesVendidos = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public Avion getAvion() {
        return avion;
    }

    public Tiquete venderTiquete(Pasajero p, String numAsiento, double precio) {
        Asiento a = avion.buscarAsiento(numAsiento);
        if (a == null) {
            System.out.println("Asiento no encontrado: " + numAsiento);
            return null;
        }
        if (!a.estaDisponible()) {
            System.out.println("Asiento no disponible: " + numAsiento);
            return null;
        }
        a.reservar();
        String id = codigo + "-" + (tiquetesVendidos + 1);
        Tiquete t = new Tiquete(id, p, this, a, precio);
        tiquetes[tiquetesVendidos] = t;
        tiquetesVendidos++;
        return t;
    }

    public boolean cancelarTiquete(Tiquete t) {
        if (t == null) return false;
        // buscar y quitar
        for (int i = 0; i < tiquetesVendidos; i++) {
            if (tiquetes[i] == t) {
                // liberar asiento
                t.getAsiento().liberar();
                // desplazar array hacia atrás
                for (int j = i; j < tiquetesVendidos - 1; j++) {
                    tiquetes[j] = tiquetes[j + 1];
                }
                tiquetes[tiquetesVendidos - 1] = null;
                tiquetesVendidos--;
                return true;
            }
        }
        return false;
    }

    public void mostrarInfo() {
        System.out.println("Vuelo " + codigo + " | " + origen.getCodigo() + " -> " + destino.getCodigo() +
                " | " + fechaHora + " | Avión: " + avion.getModelo() + " (" + avion.getMatricula() + ")");
    }

    public void mostrarTiquetesVendidos() {
        System.out.println("Tiquetes vendidos en " + codigo + ":");
        for (int i = 0; i < tiquetesVendidos; i++) {
            System.out.println(tiquetes[i].toString());
        }
    }
}
