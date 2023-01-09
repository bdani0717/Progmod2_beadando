package service;


import bussiness.Table;
import org.json.JSONArray;

public class TableListService {
    public static Boolean add(Table table) {
        try {


            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public static JSONArray getFreeTables() {
        JSONArray freeTableList = new JSONArray();

        try {

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return freeTableList;
    }
}
