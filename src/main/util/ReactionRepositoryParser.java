package util;

import enums.ParticleType;
import enums.RegexRepository;
import model.ReactionModel;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maciej on 03.04.2017.
 * 22:15
 * Project: MiSS.
 */
public class ReactionRepositoryParser implements IReactionRepositoryParser {

    private String pattern = RegexRepository.REACTIONRESULT.toString();


    public boolean addNewReaction(String name, String newReactionFormula) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<String> splitReaction = splitReaction(newReactionFormula);

        try(Writer writer = new FileWriter("ReactionsDataset.json")) {

            Map<ParticleType, Integer> leftReactionSide = parseReactionPart(splitReaction.get(0));
            Map<ParticleType, Integer> rightReactionSide = parseReactionPart(splitReaction.get(1));

            ReactionModel newReaction = new ReactionModel(name, leftReactionSide, rightReactionSide);
            mapper.writeValue(writer, newReaction);
            writer.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ReactionModel> getReaction() throws IOException {
        List<ReactionModel> result = new LinkedList<>();
        ObjectMapper mapper = new ObjectMapper();
        String filename = "ReactionsDataset.json";

        ReactionModel rm = mapper.readValue(new File(filename), ReactionModel.class);
        result.add(rm);

        return result;
    }

    private List<String> splitReaction(String newReaction) {
        return Arrays.asList(newReaction.split(pattern));
    }

    private Map<ParticleType, Integer> parseReactionPart(String reactionPart) {

        Map<ParticleType, Integer> ReactionSide = new LinkedHashMap<>();

        String elementPatternString = RegexRepository.ELEMENT.toString();
        String amountTypeSplitPatternString = RegexRepository.AMOUNTTYPESPLIT.toString();
        Pattern elementPattern = Pattern.compile(elementPatternString);
        Matcher reactionPartMapper = elementPattern.matcher(reactionPart);

        while (reactionPartMapper.find()) {
            for (int i = 0; i < reactionPartMapper.groupCount(); i++) {
                String element = reactionPartMapper.group(i);
                String[] splitElement = element.split(amountTypeSplitPatternString);
                String rodzaj = splitElement[1];
                int ilosc = Integer.parseInt(splitElement[0]);
                ParticleType particle = ParticleType.valueOf(rodzaj);
                if(particle != null)
                    ReactionSide.put(particle, ilosc);
            }
        }

        return ReactionSide;
    }

}
