import java.util.ArrayList;
import java.util.List;

public class Electronic {
    private List<Electronic> cellPhone;

    public Electronic() {
        cellPhone = new ArrayList<>();
    }

    public void addcellPhone(cellPhone cellPhone) {
        cellPhone.add(cellPhone);
    }

    public void removecellPhone(cellPhone cellPhone) {
        cellPhone.remove(cellPhone);
    }

    public List<cellPhone> getcellPhone() {
        return cellPhone;
    }

    private List<Electronic> tablet;

    public Electronic() {
        tablet = new ArrayList<>(null);
    }

    public void addtablet(tablet tablet) {
        tablet.add(tablet);
    }

    public void removetablet(tablet tab) {
        tablet.remove(tablet);
    }

    public List<tablet> tablet() {
        return tablet;

    // Other methods related to electronic functionality
    // ...

    //
}
