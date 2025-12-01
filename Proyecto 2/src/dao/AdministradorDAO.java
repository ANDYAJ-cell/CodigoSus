package dao;

import model.Administrador;

public interface AdministradorDAO {
    Administrador findByEmailAndPassword(String email, String password) throws Exception;
    void save(Administrador admin) throws Exception;
}
