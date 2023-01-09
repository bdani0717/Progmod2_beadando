package bussiness;

public class Table {
    private Integer tableId;
    private Integer seats;
    private TableStateEnum tableState;

    public Table(Integer tableId, Integer seats, TableStateEnum tableState) {
        this.tableId = tableId;
        this.seats = seats;
        this.tableState = tableState;
    }

    public Integer getTableId() {
        return this.tableId;
    }

    public Integer getSeats() {
        return this.seats;
    }

    public TableStateEnum getTableState() {
        return this.tableState;
    }

    public void setTableState(TableStateEnum tableState) {
        this.tableState = tableState;
    }
}
