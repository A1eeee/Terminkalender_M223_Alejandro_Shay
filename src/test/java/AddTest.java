import controller.AddBean;
import controller.ReservationsListeBean;
import model.ListKeys;
import model.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTest {

    AddBean addBean;
    ReservationsListeBean listeBean;


    @BeforeEach
    void setUp() {
        addBean = new AddBean();
        listeBean = new ReservationsListeBean();
        addBean.getReservation().setFirstName("Globi");
    }

    @Test
    void addR(){
        addBean.addReservation();
       // Reservation test = addBean.getReservationsListeBean().getReservationsListe().getReservation("Globi");
        //.out.println(test);
    }

}
