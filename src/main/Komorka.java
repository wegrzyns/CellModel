import decorators.CellResourceMap;
import enums.CzastkaEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Komorka {

    private Map<CzastkaEnum, Integer> mapaCzastek = new HashMap<>();

    public Komorka(CellResourceMap mapaCzastek) {
        this.mapaCzastek = mapaCzastek;
    }

    public Map<CzastkaEnum, Integer> getMapaCzastek() {
        return mapaCzastek;
    }

    public void setMapaCzastek(Map<CzastkaEnum, Integer> mapaCzastek) {
        this.mapaCzastek = mapaCzastek;
    }

}
