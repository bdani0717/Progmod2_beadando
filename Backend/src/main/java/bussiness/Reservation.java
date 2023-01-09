package bussiness;

import java.util.Date;

public class Reservation {
    private Integer reservationId;
    private Integer tableId;
    private Date reservationDate;
    private String name;
    private String email;

    public Reservation(Integer reservationId, Integer tableId, Date reservationDate, String name, String email) {
        this.reservationId = reservationId;
        this.tableId = tableId;
        this.reservationDate = reservationDate;
        this.name = name;
        this.email = email;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
