package util;

import model.ReactionModel;

import java.io.IOException;
import java.util.List;

/**
 * Created by Maciej on 08.04.2017.
 * 01:45
 * Project: MiSS.
 */
public interface IReactionRepositoryParser {

    boolean addNewReaction(String name, String newReactionFormula) throws IOException;

    List<ReactionModel> getReaction() throws IOException;

}
