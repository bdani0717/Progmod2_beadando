package bussiness;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.Objects;

@XmlRootElement(name = "reservationList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationList implements IReservationList{

    @XmlElement(name = "reservation")
    private ArrayList<Reservation> reservationList;

    public ReservationList() {
        this.reservationList = new ArrayList<>();
    }

    public Boolean add(Reservation reservation) {
        return this.reservationList.add(reservation);
    }

    public Boolean removeById(Integer reservationId) {
        int deleteIndex = -1;

        for(int i = 0; i < this.reservationList.size(); i++) {
            if(Objects.equals(this.reservationList.get(i).getReservationId(), reservationId)) {
                deleteIndex = i;
                break;
            }
        }

        if(deleteIndex != -1) {
            this.reservationList.remove(deleteIndex);
            return true;
        }

        return false;
    }

    public ArrayList<Reservation> getList() {
        return reservationList;
    }

    public void setReservationList(ArrayList<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
