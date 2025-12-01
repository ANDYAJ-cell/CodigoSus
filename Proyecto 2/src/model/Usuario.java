package model;

public abstract class Usuario {
    protected int id;
    protected String nombreCompleto;
    protected String cedula;
    protected String correoElectronico;
    protected String contrasenia;

    public Usuario() {}

    public Usuario(int id, String nombreCompleto, String cedula, String correoElectronico, String contrasenia) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    // getters y setters
    public int getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getCedula() { return cedula; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getContrasenia() { return contrasenia; }

    public void setId(int id) { this.id = id; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
}
