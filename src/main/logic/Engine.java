package logic;

import com.google.inject.Guice;
import com.google.inject.Injector;
import data.particle.ObjectDataReader;
import injector.AppInjector;
import logic.reaction.IReakcja;
import logic.reaction.Reakcja;
import model.ReakcjaModel;
import util.ReakcjaRepositoryParser;
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

    private static final String IZOMERYZACJA = "izomeryzacja";
    private static final String LOG_FILE_NAME = "reaction_logs.log";
    public static final String REACTION_LOGGER_NAME = "MyLog";


    public static void main(String[] args) throws InterruptedException {

        Injector injector = Guice.createInjector(new AppInjector());

        configureLogging();

        HashMap<ResourcesPool, ResourcesPool> reakcjaIzomeryzacji = prepareIzomerationReaction();

        Cell cell = prepareCell();

        IReakcja izomeryzacja = new Reakcja(IZOMERYZACJA, reakcjaIzomeryzacji, cell);
        izomeryzacja.reaguj();

        ReakcjaRepositoryParser rsp = new ReakcjaRepositoryParser();
        try {
            rsp.dodajNowaReakcja("ok", "2_Woda + 5_Akonitan -> 4_Woda + 3_Akonitan");
            List<ReakcjaModel> r = rsp.pobierzReakcje();
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

    private static HashMap<ResourcesPool, ResourcesPool> prepareIzomerationReaction() {
        HashMap<ResourcesPool, ResourcesPool> reakcjaIzomeryzacji = new LinkedHashMap<>();
        ResourcesPool substraty1 = new ResourcesPool(new HashMap<>());
        ResourcesPool produkty1 = new ResourcesPool(new HashMap<>());
        ResourcesPool substraty2 = new ResourcesPool(new HashMap<>());
        ResourcesPool produkty2 = new ResourcesPool(new HashMap<>());

        List<Particle>  particleStubList = new ArrayList<>();
        particleStubList.add(new Particle(ParticleType.CYTRYNIAN, null));


        substraty1.getResources().put(ParticleType.CYTRYNIAN, generateSimpleReactionParticleList(ParticleType.CYTRYNIAN));
        produkty1.getResources().put(ParticleType.AKONITAN, generateSimpleReactionParticleList(ParticleType.AKONITAN));
        produkty1.getResources().put(ParticleType.WODA, generateSimpleReactionParticleList(ParticleType.WODA));

        reakcjaIzomeryzacji.put(substraty1, produkty1);

        substraty2.getResources().put(ParticleType.AKONITAN, generateSimpleReactionParticleList(ParticleType.AKONITAN));
        substraty2.getResources().put(ParticleType.WODA, generateSimpleReactionParticleList(ParticleType.WODA));
        produkty2.getResources().put(ParticleType.IZOCYTRYNIAN, generateSimpleReactionParticleList(ParticleType.IZOCYTRYNIAN));

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
