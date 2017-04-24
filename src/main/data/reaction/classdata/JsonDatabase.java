package data.reaction.classdata;

import model.ReactionModel;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maciej on 24.04.2017.
 * 23:34
 * Project: MiSS.
 */
public class JsonDatabase {

    private String databasePath = "ReactionsDataset.json";

    public List<ReactionModel> getReactions() throws IOException {
        List<ReactionModel> result = new LinkedList<>();
        ObjectMapper mapper = new ObjectMapper();

        ReactionModel[] rm = mapper.readValue(new File(databasePath), ReactionModel[].class);
        Collections.addAll(result, rm);

        return result;
    }

}
