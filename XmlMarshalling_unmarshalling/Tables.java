import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
@XmlAccessorType (XmlAccessType.FIELD)
public class Tables {
    @XmlElement(name = "table")

    private List<Table> tables = null;

    public List<Table> getEmployees() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
