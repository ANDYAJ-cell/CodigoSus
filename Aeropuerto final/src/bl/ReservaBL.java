package bl;

import dl.ReservaDAO;
import model.Reserva;

public class ReservaBL {

    private ReservaDAO dao = new ReservaDAO();

    public void registrar(Reserva reserva) throws Exception {
        dao.insertar(reserva);
    }
}
