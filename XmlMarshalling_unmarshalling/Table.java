import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
@XmlAccessorType (XmlAccessType.FIELD)
public class Table {
    private int id;
    private int seatNumber;
    tableState state;

    public Table(int id, int seatNumber, tableState state) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.state = state;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    @XmlElement
    public tableState getState() {
        return state;
    }

    public void setState(tableState state) {
        this.state = state;
    }
}

enum tableState{
    reserved, occupied, free
}