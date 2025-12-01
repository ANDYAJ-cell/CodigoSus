package dao;

import model.Cuenta;
import java.util.List;

public interface CuentaDAO {
    void save(Cuenta c) throws Exception;
    Cuenta findByNumero(String numero) throws Exception;
    List<Cuenta> findByClienteId(int clienteId) throws Exception;
    void update(Cuenta c) throws Exception;
    List<Cuenta> findAll() throws Exception;
}
