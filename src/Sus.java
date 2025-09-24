public class Sus {

    String Tipo;
    int Costo;
    int Periodicidad;

    Sus( String TipoO, int CostoO, int PeriodicidadO){
        Tipo = TipoO;
        Costo =  CostoO;
        Periodicidad =  PeriodicidadO;

    }

    public String getTipo() {
        return Tipo;
    }

    public int getCosto() {
        return Costo;
    }

    public int getPeriodicidad() {
        return Periodicidad;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public void setCosto(int costo) {
        Costo = costo;
    }

    public void setPeriodicidad(int periodicidad) {
        Periodicidad = periodicidad;
    }

    public boolean equals(Sus SusComparar){

        return getTipo().equals(SusComparar.getTipo());
    }

    public String toString() {

        return "Tipo: " + Tipo + ", Costo: " + Costo + ", Periodicidad: " + Periodicidad;

    }
}
