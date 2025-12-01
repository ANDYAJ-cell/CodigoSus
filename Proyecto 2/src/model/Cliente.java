package model;

public class Cliente extends Usuario {
    private String sexo;
    private String profesion;
    private String direccion;

    public Cliente() {}

    public Cliente(int id, String nombreCompleto, String cedula, String correoElectronico, String contrasenia,
                   String sexo, String profesion, String direccion) {
        super(id, nombreCompleto, cedula, correoElectronico, contrasenia);
        this.sexo = sexo;
        this.profesion = profesion;
        this.direccion = direccion;
    }

    public String getSexo() { return sexo; }
    public String getProfesion() { return profesion; }
    public String getDireccion() { return direccion; }

    public void setSexo(String s) { this.sexo = s; }
    public void setProfesion(String p) { this.profesion = p; }
    public void setDireccion(String d) { this.direccion = d; }

    public String toString() {
        return String.format("Cliente{id=%d, nombre='%s', cedula='%s', email='%s'}",
                id, nombreCompleto, cedula, correoElectronico);
    }
}
