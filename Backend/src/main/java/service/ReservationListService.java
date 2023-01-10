package service;

import bussiness.Reservation;
import bussiness.ReservationList;
import bussiness.TableStateEnum;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class ReservationListService {

    private static final String pathToXml = "reservationlist.xml";

    public static Boolean add(Reservation reservation) {
        try {
            ReservationList reservationList = readReservationListFromXml();

            for(Reservation r : reservationList.getList()) {
                if(r.getTableId() == reservation.getTableId() &&
                        r.getReservationTime() == reservation.getReservationTime()) {
                    return false;
                }
            }

            TableListService.setTableState(reservation.getTableId(), TableStateEnum.Reserved);
            reservationList.getList().add(reservation);

            return saveReservationListToXml(reservationList);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return false;
    }

    public static ReservationList getReservationsByTableId(Integer tableId) {
        ReservationList reservationList = new ReservationList();

        try {
            readReservationListFromXml().getList().forEach(reservation -> {
               if(reservation.getTableId() == tableId) {
                   reservationList.getList().add(reservation);
               }
            });
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return reservationList;
    }



    private static ReservationList readReservationListFromXml() {
        ReservationList reservationList;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ReservationList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            reservationList = (ReservationList) unmarshaller.unmarshal(new File(ReservationListService.pathToXml));

        } catch (Exception e) {
            reservationList = new ReservationList();
            System.out.println(e.toString());
        }

        return reservationList;
    }

    private static Boolean saveReservationListToXml(ReservationList reservationList) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ReservationList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            File file = new File(ReservationListService.pathToXml);
            marshaller.marshal(reservationList, file);

            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return false;
    }
}
