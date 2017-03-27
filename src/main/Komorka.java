import java.util.List;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Komorka {

    private List<Reagent> reagenty;

    public Komorka(List<Reagent> reagenty) {
        this.reagenty = reagenty;
    }

    public List<Reagent> getReagenty() {
        return reagenty;
    }

    public void setReagenty(List<Reagent> reagenty) {
        this.reagenty = reagenty;
    }
}
