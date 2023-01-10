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
            ReservationList reservationList = readReservationListFromXml(pathToXml);

            TableListService.setTableState(reservation.getTableId(), TableStateEnum.Reserved);
            reservationList.getList().add(reservation);

            return saveReservationListToXml(reservationList, pathToXml);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }



    private static ReservationList readReservationListFromXml(String path) {
        ReservationList reservationList;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ReservationList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            reservationList = (ReservationList) unmarshaller.unmarshal(new File(path));

        } catch (Exception e) {
            reservationList = new ReservationList();
            System.out.println(e.toString());
        }

        return reservationList;
    }

    private static Boolean saveReservationListToXml(ReservationList reservationList, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ReservationList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            File file = new File(path);
            marshaller.marshal(reservationList, file);

            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return false;
    }
}
