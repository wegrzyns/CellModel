package logic.reaction;

import enums.ParticleType;
import logic.Cell;
import logic.Engine;
import logic.ResourcesPool;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Krzysiu on 27.03.2017.
 */

public class Reaction implements IReaction {

    private Logger logger = Logger.getLogger(Engine.REACTION_LOGGER_NAME);
    private String nazwa;
    private Map<ResourcesPool, ResourcesPool> reactionMapping;
    private Cell cell;

    public Reaction(String nazwa, HashMap<ResourcesPool, ResourcesPool> reactionMapping, Cell cell) {
        this.nazwa = nazwa;
        this.reactionMapping = reactionMapping;
        this.cell = cell;
    }

    public void reaguj() {
        for(Map.Entry<ResourcesPool, ResourcesPool> reaction: reactionMapping.entrySet() ) {
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

    private boolean pobierzCzastkiDoReakcji(ResourcesPool wymaganeCzastki) {
        if (!contains(wymaganeCzastki))
            return false;
        for (ParticleType czastka : wymaganeCzastki.getAvailableParticleTypes()) {
            int iloscCzastekDoUsuniecia = wymaganeCzastki.getSizeOfParticleType(czastka);
            cell.getResoucersPool().removeElementsOfParticleType(czastka, iloscCzastekDoUsuniecia);
        }

        return true;
    }

    private void dodajCzastkiPoReakcji(ResourcesPool dodawaneCzastki) {

        for (ParticleType czastka : dodawaneCzastki.getAvailableParticleTypes()) {
            if (!cell.getResoucersPool().containsParticleType(czastka)) {
                cell.getResoucersPool().addParticleType(czastka);
            }
            cell.getResoucersPool()
                    .addElementsOfParticleType(czastka, dodawaneCzastki.getElementsOfParticleType(czastka));
        }

    }

    private boolean contains(ResourcesPool wymaganeCzastki) {
        for (ParticleType czastka : wymaganeCzastki.getResources().keySet()) {
            if(!cell.getResoucersPool().getResources().containsKey(czastka)) return false;
            if(cell.getResoucersPool().getResources().get(czastka).size()
                    < wymaganeCzastki.getResources().get(czastka).size()) return false;
        }
        return true;
    }

    private String createReactionLog(ResourcesPool substraty, ResourcesPool produkty) {
        String reactionLog = nazwa +
                ": " +
                substraty +
                " -> " +
                produkty;
        return reactionLog;
    }

}
