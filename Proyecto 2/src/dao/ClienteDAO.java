package dao;

import model.Cliente;
import java.util.List;

public interface ClienteDAO {
    void save(Cliente c) throws Exception;
    Cliente findByEmailAndPassword(String email, String password) throws Exception;
    Cliente findById(int id) throws Exception;
    List<Cliente> findAll() throws Exception;
}
