package service;

import bussiness.Reservation;

public class ReservationListService {
    public static Boolean add(Reservation reservation) {
        try {


            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
}
