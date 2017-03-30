import enums.CzastkaEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Komorka {

    private Map<CzastkaEnum, Integer> mapaCzastek = new HashMap<>();

    public Komorka(Map<CzastkaEnum, Integer> mapaCzastek) {
        this.mapaCzastek = mapaCzastek;
    }

    public Map<CzastkaEnum, Integer> getMapaCzastek() {
        return mapaCzastek;
    }

    public void setMapaCzastek(Map<CzastkaEnum, Integer> mapaCzastek) {
        this.mapaCzastek = mapaCzastek;
    }

    public boolean pobierzCzastkiDoReakcji(Map<CzastkaEnum, Integer> wymaganeCzastki) {
        if (!contains(wymaganeCzastki))
            return false;
        for (CzastkaEnum czastka : wymaganeCzastki.keySet()) {
            int iloscCzastekwKomorce = mapaCzastek.get(czastka);
            int iloscCzastekDoUsuniecia = wymaganeCzastki.get(czastka);
            int iloscCzastek = iloscCzastekwKomorce - iloscCzastekDoUsuniecia;
            mapaCzastek.put(czastka, iloscCzastek);
        }

        return true;
    }

    public void dodajCzastkiPoReakcji(Map<CzastkaEnum, Integer> dodawaneCzastki) {

        for (CzastkaEnum czastka : dodawaneCzastki.keySet()) {
            if (mapaCzastek.containsKey(czastka)) {
                synchronized (mapaCzastek) {
                    int aktualnaIlosc = mapaCzastek.get(czastka);
                    int nowaIlosc = aktualnaIlosc + dodawaneCzastki.get(czastka);
                    mapaCzastek.put(czastka, nowaIlosc);
                }
            } else {
                mapaCzastek.put(czastka, dodawaneCzastki.get(czastka));
            }
        }

    }

    private boolean contains(Map<CzastkaEnum, Integer> wymaganeCzastki) {
        for (CzastkaEnum czastka : wymaganeCzastki.keySet()) {
            if(!mapaCzastek.containsKey(czastka)) return false;
            if(mapaCzastek.get(czastka) < wymaganeCzastki.get(czastka)) return false;
        }
        return true;
    }

}
