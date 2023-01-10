package bussiness;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.Time;
import java.util.Date;


@XmlRootElement(name = "reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {
    private Integer reservationId;
    private Integer tableId;
//    private Date reservationDate;
    private Integer reservationTime;
    private String name;
    private String email;

    public Reservation() {
    }

    public Reservation(Integer reservationId, Integer tableId, Integer reservationTime, String name, String email) {
        this.reservationId = reservationId;
        this.tableId = tableId;
        this.reservationTime = reservationTime;
        this.name = name;
        this.email = email;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public Integer getReservationTime() {
        return reservationTime;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public void setReservationTime(Integer reservationTime) {
        if(reservationTime < 0 || reservationTime > 23) {
            return;
        } else {
            this.reservationTime = reservationTime;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
