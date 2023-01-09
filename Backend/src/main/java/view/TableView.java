package view;

import org.json.JSONObject;

public class TableView {
    public String TableId;
    public String Seats;
    public String TableState;

    public TableView(String tableId, String seats, String tableState) {
        TableId = tableId;
        Seats = seats;
        TableState = tableState;
    }

    public JSONObject getJson() {
        JSONObject table = new JSONObject();

        table.put("tabelId", TableId);
        table.put("seats", Seats);
        table.put("tabelState", TableState);

        return table;
    }
}
