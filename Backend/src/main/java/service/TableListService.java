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

public class TableListService {

    private static final String pathToXml = "tablelist.xml";

    public static Boolean add(Table table) {
        try {
            TableList tableList = readTableListFromXml(pathToXml);

            tableList.add(new Table(4, 4, TableStateEnum.Free));

            return saveTableListToXml(tableList, pathToXml);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public static JSONArray getFreeTables() {
        JSONArray freeTableList = new JSONArray();

        try {
            TableList tableList = readTableListFromXml(pathToXml);

            tableList.getList().forEach(table -> {
                if(table.getTableState() == TableStateEnum.Free) {
                    freeTableList.put(new TableView(table).getJson());
                }
            });

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return freeTableList;
    }

    public static Boolean setTableState(Integer tableId, TableStateEnum state) {
        try {
            TableList tableList = readTableListFromXml(pathToXml);

            for(Table table : tableList.getList()) {
                if(table.getTableId() == tableId) {
                    table.setTableState(state);
                    break;
                }
            }

            return saveTableListToXml(tableList, pathToXml);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }


    private static TableList readTableListFromXml(String path) {
        TableList tableList;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TableList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            tableList = (TableList) unmarshaller.unmarshal(new File(path));

        } catch (Exception e) {
            tableList = new TableList();
            System.out.println(e.toString());
        }

        return tableList;
    }

    private static Boolean saveTableListToXml(TableList tableList, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TableList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            File file = new File(path);
            marshaller.marshal(tableList, file);

            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return false;
    }
}
