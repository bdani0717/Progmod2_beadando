package bussiness;

import java.util.ArrayList;

public interface IReservationList {
    Boolean add(Reservation reservation);
    Boolean removeById(Integer reservationId);
    ArrayList<Reservation> getList();
}
