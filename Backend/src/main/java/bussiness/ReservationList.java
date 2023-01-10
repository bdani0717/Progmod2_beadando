package bussiness;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name = "reservationList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationList {

    @XmlElement(name = "reservation")
    private ArrayList<Reservation> reservationList;

    public ReservationList() {
        this.reservationList = new ArrayList<>();
    }

    public void add(Reservation reservation) {
        this.reservationList.add(reservation);
    }

    public ArrayList<Reservation> getList() {
        return reservationList;
    }

    public void setReservationList(ArrayList<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
