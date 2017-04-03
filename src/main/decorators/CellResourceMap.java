package decorators;

import enums.CzastkaEnum;

import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Krzysiu on 03.04.2017.
 */
public class CellResourceMap extends LinkedHashMap<CzastkaEnum, Integer> {


    @Override
    public String toString() {
        StringBuilder resourcesStringBuilder = new StringBuilder("\n");
        for(Map.Entry<CzastkaEnum, Integer> resource: entrySet()) {
            resourcesStringBuilder
                    .append(resource.getKey())
                    .append(" x ")
                    .append(resource.getValue())
                    .append('\n');
        }
        return resourcesStringBuilder.toString();
    }

    public String toReactionString() {
        StringBuilder reactionStringBuilder = new StringBuilder("");
        int entrySetSize = entrySet().size();
        int counter = 1;
        for(Map.Entry<CzastkaEnum, Integer> resource: entrySet()) {
            reactionStringBuilder
                    .append(resource.getValue())
                    .append(resource.getKey().toString());
            if( counter  >= 1 && counter < entrySetSize) {
                reactionStringBuilder.append(" + ");
            }
            else{
                reactionStringBuilder.append(" ");
            }
            counter++;

        }
        return reactionStringBuilder.toString();
    }
}
