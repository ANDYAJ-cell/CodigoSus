public class cliente {
    String nombre;
    String apellido;
    String cedula;
    char sexo;
    String ubicacion;

    cliente(String nombreObjeto, String apellidoObjeto, String cedulaObjeto, char sexoObjeto, String ubicacionObjeto) {
        nombre = nombreObjeto;
        apellido = apellidoObjeto;
        cedula = cedulaObjeto;
        sexo = sexoObjeto;
        ubicacion = ubicacionObjeto;

    }
    cliente(String nombreObjeto, String apellidoObjeto, String cedulaObjeto, String ubicacionObjeto) {
        nombre = nombreObjeto;
        apellido = apellidoObjeto;
        cedula = cedulaObjeto;
        ubicacion = ubicacionObjeto;

    }

    cliente() {




    }
    public void suscribirse(Sus sub){
        System.out.println(nombre + " "+ apellido+ "  adquirio una suscripcion "+ sub.Tipo);


    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public char getSexo() {
        return sexo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String toString() {
        return "cliente{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + "\n"  + ", cedula=" + cedula + ", sexo=" + sexo + ", ubicacion='" + ubicacion + "\n" + '}';
    }
    public boolean equals(cliente clienteComparar){

        return getCedula().equals(clienteComparar. getCedula());
    }
}
