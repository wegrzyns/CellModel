package data.reaction;

import data.reaction.classdata.JsonDatabase;
import logic.ResourcesPool;
import model.ReactionModel;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Maciej on 24.04.2017.
 * 23:34
 * Project: MiSS.
 */
public class JsonReactionReader implements IReactionReader {

    private JsonDatabase database = new JsonDatabase();

    @Override
    public List<ReactionModel> getReactions() throws IOException {
        return database.getReactions();
    }
}
