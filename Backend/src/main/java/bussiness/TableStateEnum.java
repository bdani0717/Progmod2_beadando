package bussiness;

public enum TableStateEnum {
    Reserved(0), Free(1), Occupied(2);

    public final Integer no;

    private TableStateEnum(int id) {
        this.no = id;
    }

    public static TableStateEnum StatusFromInt(int id) {
        switch (id) {
            case 0:
                return TableStateEnum.Reserved;
            case 1:
                return TableStateEnum.Free;
            case 2:
                return TableStateEnum.Occupied;
        }

        return TableStateEnum.Free;
    }

    public String toString() {
        switch (this.no) {
            case 0:
                return "Reserved";
            case 1:
                return "Free";
            case 2:
                return "Occupied";
        }
        return null;
    }
}
