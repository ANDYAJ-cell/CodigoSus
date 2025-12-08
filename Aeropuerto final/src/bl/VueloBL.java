package bl;

import dl.VueloDAO;
import model.Vuelo;

import java.util.List;

public class VueloBL {

    private VueloDAO dao = new VueloDAO();

    public void registrar(Vuelo vuelo) throws Exception {
        dao.insertar(vuelo);
    }

    public List<Vuelo> obtenerTodos() throws Exception {
        return dao.obtenerTodos();
    }
}
