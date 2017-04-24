package data.reaction;

import logic.ResourcesPool;
import model.ReactionModel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Maciej on 24.04.2017.
 * 23:34
 * Project: MiSS.
 */
public interface IReactionReader {

    List<ReactionModel> getReactions() throws IOException;

}
