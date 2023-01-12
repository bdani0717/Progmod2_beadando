package service;

import bussiness.Reservation;
import bussiness.ReservationList;
import bussiness.TableStateEnum;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.json.JSONObject;

import java.io.File;

public class ReservationListService {

    private static final String pathToXml = "reservationlist.xml";

    public static JSONObject add(Reservation reservation) {
        JSONObject result = new JSONObject();

        try {
            ReservationList reservationList = readReservationListFromXml();

            for(Reservation r : reservationList.getList()) {
                if(r.getTableId() == reservation.getTableId() &&
                        r.getReservationTime() == reservation.getReservationTime()) {
                    result.put("status", "conflict");
                    return result;
                }
            }

            TableListService.setTableState(reservation.getTableId(), TableStateEnum.Reserved);
            reservationList.getList().add(reservation);

            if(saveReservationListToXml(reservationList)) {
                result.put("status", "success");
                return result;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        result.put("status", "failed");
        return result;
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

    public static JSONObject delete(Integer reservationId) {
        JSONObject result = new JSONObject();

        try {
            ReservationList reservationList = readReservationListFromXml();

            result.put("deleteStatus", reservationList.removeById(reservationId));

            if(saveReservationListToXml(reservationList)) {
                result.put("saveStatus", "saved");
                return result;
            }


        } catch (Exception e) {
            System.out.println(e.toString());
            result.put("error", e.toString());
        }

        result.put("saveStatus", "failed to save");
        return result;
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
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File(ReservationListService.pathToXml);
            marshaller.marshal(reservationList, file);

            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return false;
    }
}
