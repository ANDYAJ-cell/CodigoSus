
public class Administrador extends Usuario {

    public Administrador(String nombreCompleto, String cedula, String correo, String contraseña) {
        super(nombreCompleto, cedula, correo, contraseña);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", cedula='" + getCedula() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                '}';
    }
}
