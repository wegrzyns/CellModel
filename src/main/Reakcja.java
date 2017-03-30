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
    private Map<Map<CzastkaEnum, Integer>, Map<CzastkaEnum, Integer>> reactionMapping;

    public Reakcja(String nazwa, HashMap<Reagent, Reagent> reactionMapping) {
        this.nazwa = nazwa;
        this.reactionMapping = reactionMapping;
    }

    public Reagent reaguj(Reagent reagent) {
        if (reactionMapping.containsKey(reagent)) {
            createReactionLog(reagent, reactionMapping.get(reagent));
            return reactionMapping.get(reagent);
        }
        logger.info("Reaction mapping not found for \"" + reagent.toString() + "\"");
        return reagent;
    }

    private void createReactionLog(Reagent substrat, Reagent produkt) {
        String reactionLog = nazwa +
                ": " +
                substrat.toString() +
                " -> " +
                produkt.toString();
        logger.info(reactionLog);
    }
}
