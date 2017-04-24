package logic;

import com.google.inject.Guice;
import com.google.inject.Injector;
import data.particle.ObjectDataReader;
import injector.AppInjector;
import logic.reaction.IReaction;
import logic.reaction.Reaction;
import model.ReactionModel;
import util.ReactionRepositoryParser;
import enums.ParticleType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Engine {

    private static final String ISOMERIZATION = "isomerization";
    private static final String LOG_FILE_NAME = "reaction_logs.log";
    public static final String REACTION_LOGGER_NAME = "MyLog";


    public static void main(String[] args) throws InterruptedException {

        Injector injector = Guice.createInjector(new AppInjector());

        configureLogging();

        HashMap<ResourcesPool, ResourcesPool> reakcjaIzomeryzacji = prepareIsomerationReaction();

        Cell cell = prepareCell();

        IReaction izomeryzacja = new Reaction(ISOMERIZATION, reakcjaIzomeryzacji, cell);
        izomeryzacja.reaguj();

        ReactionRepositoryParser rsp = new ReactionRepositoryParser();
        try {
            rsp.addNewReaction("ok", "2_WODA + 5_AKONITAN -> 4_WODA + 3_AKONITAN");
            List<ReactionModel> r = rsp.getReaction();
            r.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Cell prepareCell() {
        ObjectDataReader objectDataReader = new ObjectDataReader();
        ResourcesPool zasobyKomorki =  new ResourcesPool(objectDataReader.getParticles());
        return new Cell(zasobyKomorki);

    }

    private static HashMap<ResourcesPool, ResourcesPool> prepareIsomerationReaction() {
        HashMap<ResourcesPool, ResourcesPool> reakcjaIzomeryzacji = new LinkedHashMap<>();
        ResourcesPool substraty1 = new ResourcesPool(new HashMap<>());
        ResourcesPool produkty1 = new ResourcesPool(new HashMap<>());
        ResourcesPool substraty2 = new ResourcesPool(new HashMap<>());
        ResourcesPool produkty2 = new ResourcesPool(new HashMap<>());

        List<Particle>  particleStubList = new ArrayList<>();
        particleStubList.add(new Particle(ParticleType.Citrate, null));


        substraty1.getResources().put(ParticleType.Citrate, generateSimpleReactionParticleList(ParticleType.Citrate));
        produkty1.getResources().put(ParticleType.AKONITAN, generateSimpleReactionParticleList(ParticleType.AKONITAN));
        produkty1.getResources().put(ParticleType.WODA, generateSimpleReactionParticleList(ParticleType.WODA));

        reakcjaIzomeryzacji.put(substraty1, produkty1);

        substraty2.getResources().put(ParticleType.AKONITAN, generateSimpleReactionParticleList(ParticleType.AKONITAN));
        substraty2.getResources().put(ParticleType.WODA, generateSimpleReactionParticleList(ParticleType.WODA));
        produkty2.getResources().put(ParticleType.Isocitrate, generateSimpleReactionParticleList(ParticleType.Isocitrate));

        reakcjaIzomeryzacji.put(substraty2, produkty2);

        return reakcjaIzomeryzacji;
    }

    private static List<Particle> generateSimpleReactionParticleList(ParticleType particleType) {
        List<Particle> reactionParticleList = new ArrayList<>();
        reactionParticleList.add(new Particle(particleType, null));

        return reactionParticleList;
    }

    private static void configureLogging() {
        Logger logger = Logger.getLogger(REACTION_LOGGER_NAME);
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            System.out.println(System.getProperty("user.dir"));
            fh = new FileHandler(System.getProperty("user.dir")+"\\"+LOG_FILE_NAME, true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            //remove console from logger
            logger.setUseParentHandlers(false);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

}
