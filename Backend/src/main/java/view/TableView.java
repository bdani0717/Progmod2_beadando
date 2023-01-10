package view;

import bussiness.Table;
import org.json.JSONObject;

public class TableView {
    public String tableId;
    public String seats;
    public String tableState;

//    public TableView(String tableId, String seats, String tableState) {
//        this.tableId = tableId;
//        this.seats = seats;
//        this.tableState = tableState;
//    }

    public TableView(Table table) {
        this.tableId = table.getTableId().toString();
        this.seats = table.getSeats().toString();
        this.tableState = table.getTableState().toString();
    }

    public JSONObject getJson() {
        JSONObject table = new JSONObject();

        table.put("tabelId", this.tableId);
        table.put("seats", this.seats);
        table.put("tabelState", this.tableState);

        return table;
    }
}
