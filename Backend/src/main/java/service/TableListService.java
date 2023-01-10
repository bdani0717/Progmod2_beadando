package service;


import bussiness.Table;
import bussiness.TableList;
import bussiness.TableStateEnum;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.json.JSONArray;
import view.TableView;

import java.io.File;
import java.util.ArrayList;

public class TableListService {

    private static final String pathToXml = "tablelist.xml";

    public static Boolean add(Table table) {
        try {
            TableList tableList = readTableListFromXml();

            tableList.add(table);

            return saveTableListToXml(tableList);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public static JSONArray getTables() {
        JSONArray freeTableList = new JSONArray();

        try {
            TableList tableList = readTableListFromXml();

            tableList.getList().forEach(table -> {
                ArrayList<String> availability = new ArrayList<>();

                for(int time = 8; time < 20; time++) {
                    int index = time - 8;

                    availability.add(index, TableStateEnum.Free.toString());
                }

                ReservationListService.getReservationsByTableId(table.getTableId()).getList().forEach(reservation -> {
                    int index = reservation.getReservationTime() - 8;
                    availability.set(index, TableStateEnum.Reserved.toString());
                });

                freeTableList.put(new TableView(table, availability).getJson());
            });
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return freeTableList;
    }

    public static Boolean setTableState(Integer tableId, TableStateEnum state) {
        try {
            TableList tableList = readTableListFromXml();

            for(Table table : tableList.getList()) {
                if(table.getTableId() == tableId) {
                    table.setTableState(state);
                    return saveTableListToXml(tableList);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }


    private static TableList readTableListFromXml() {
        TableList tableList;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TableList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            tableList = (TableList) unmarshaller.unmarshal(new File(TableListService.pathToXml));

        } catch (Exception e) {
            tableList = new TableList();
            System.out.println(e.toString());
        }

        return tableList;
    }

    private static Boolean saveTableListToXml(TableList tableList) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TableList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            File file = new File(TableListService.pathToXml);
            marshaller.marshal(tableList, file);

            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return false;
    }
}
