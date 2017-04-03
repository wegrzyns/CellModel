import decorators.CellResourceMap;
import enums.CzastkaEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Reakcja {

    private static Logger logger = Logger.getLogger(Silnik.REACTION_LOGGER_NAME);
    private String nazwa;
    private Map<CellResourceMap, CellResourceMap> reactionMapping;
    private Komorka komorka;

    public Reakcja(String nazwa, Map<CellResourceMap, CellResourceMap> reactionMapping, Komorka komorka) {
        this.nazwa = nazwa;
        this.reactionMapping = reactionMapping;
        this.komorka = komorka;
    }

    public void reaguj() {
        for(Map.Entry<CellResourceMap, CellResourceMap> reaction: reactionMapping.entrySet() ) {
            if( pobierzCzastkiDoReakcji(reaction.getKey()) ) {
                dodajCzastkiPoReakcji(reaction.getValue());

                logger.info(createReactionLog(reaction.getKey(), reaction.getValue()));
            }
            else{
                logger.info("Insufficient resources to perform reaction \"" +
                        createReactionLog(reaction.getKey(), reaction.getValue()) + "\"");
                logger.info("Aborting reaction");
                break;
            }

        }
    }

    private boolean pobierzCzastkiDoReakcji(CellResourceMap wymaganeCzastki) {
        if (!contains(wymaganeCzastki))
            return false;
        for (CzastkaEnum czastka : wymaganeCzastki.keySet()) {
            int iloscCzastekwKomorce = komorka.getMapaCzastek().get(czastka);
            int iloscCzastekDoUsuniecia = wymaganeCzastki.get(czastka);
            int iloscCzastek = iloscCzastekwKomorce - iloscCzastekDoUsuniecia;
            komorka.getMapaCzastek().put(czastka, iloscCzastek);
        }

        return true;
    }

    private void dodajCzastkiPoReakcji(CellResourceMap dodawaneCzastki) {

        for (CzastkaEnum czastka : dodawaneCzastki.keySet()) {
            if (komorka.getMapaCzastek().containsKey(czastka)) {
                synchronized (komorka.getMapaCzastek()) {
                    int aktualnaIlosc = komorka.getMapaCzastek().get(czastka);
                    int nowaIlosc = aktualnaIlosc + dodawaneCzastki.get(czastka);
                    komorka.getMapaCzastek().put(czastka, nowaIlosc);
                }
            } else {
                komorka.getMapaCzastek().put(czastka, dodawaneCzastki.get(czastka));
            }
        }

    }

    private boolean contains(CellResourceMap wymaganeCzastki) {
        for (CzastkaEnum czastka : wymaganeCzastki.keySet()) {
            if(!komorka.getMapaCzastek().containsKey(czastka)) return false;
            if(komorka.getMapaCzastek().get(czastka) < wymaganeCzastki.get(czastka)) return false;
        }
        return true;
    }

    private String createReactionLog(CellResourceMap substraty, CellResourceMap produkty) {
        String reactionLog = nazwa +
                ": " +
                substraty.toReactionString() +
                " -> " +
                produkty.toReactionString();
        return reactionLog;
    }
}
