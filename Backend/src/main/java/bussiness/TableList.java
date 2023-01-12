package bussiness;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name = "tableList")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableList implements ITableList {

    @XmlElement(name = "table")
    private ArrayList<Table> tableList;

    public TableList() {
        this.tableList = new ArrayList<>();
    }

    public Boolean add(Table table) {
        return this.tableList.add(table);
    }

    public ArrayList<Table> getList() {
        return tableList;
    }

    public void setTableList(ArrayList<Table> tableList) {
        this.tableList = tableList;
    }
}
