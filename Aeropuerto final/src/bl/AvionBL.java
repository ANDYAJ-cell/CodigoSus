package bl;

import dl.AvionDAO;
import model.Avion;

import java.util.List;

public class AvionBL {

    private AvionDAO dao = new AvionDAO();

    public void registrar(Avion avion) throws Exception {
        dao.insertar(avion);
    }

    public List<Avion> obtenerTodos() throws Exception {
        return dao.obtenerTodos();
    }
}
