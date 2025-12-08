package bl;

import dl.PasajeroDAO;
import model.Pasajero;

public class PasajeroBL {
    private PasajeroDAO dao = new PasajeroDAO();

    public void registrarPasajero(Pasajero p) throws Exception {
        dao.insertar(p);
    }
}
