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

    public Reakcja(String nazwa, Map<Map<CzastkaEnum, Integer>, Map<CzastkaEnum, Integer>> reactionMapping) {
        this.nazwa = nazwa;
        this.reactionMapping = reactionMapping;
    }

    public Map<CzastkaEnum, Integer> reaguj(Map<CzastkaEnum, Integer> reagenty) {

        logger.info("Reaction mapping not found for \"" + reagenty.toString() + "\"");
        return null;
    }

    private void createReactionLog(Map<CzastkaEnum, Integer> substrat, Map<CzastkaEnum, Integer> produkt) {
        String reactionLog = nazwa +
                ": " +
                substrat.toString() +
                " -> " +
                produkt.toString();
        logger.info(reactionLog);
    }
}
