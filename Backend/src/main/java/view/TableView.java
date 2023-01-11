package view;

import bussiness.Table;
import org.json.JSONObject;

import java.util.ArrayList;

public class TableView {
    public String tableId;
    public String seats;
    public ArrayList<String> availability;

    public TableView(Table table, ArrayList<String> availability) {
        this.tableId = table.getTableId().toString();
        this.seats = table.getSeats().toString();
        this.availability = availability;
    }

    public JSONObject getJson() {
        JSONObject table = new JSONObject();

        table.put("tableId", this.tableId);
        table.put("seats", this.seats);

        for(Integer i = 0; i < this.availability.size(); i++) {
//            int startTime = i + 8;
//            int endTime = startTime + 1;
//            char timeAsChar = 'a';
//            timeAsChar += i;
//            String time = startTime + "_" + endTime;
//            String time = "" + timeAsChar;
            table.put(i.toString(), this.availability.get(i));
        }

        return table;
    }
}
