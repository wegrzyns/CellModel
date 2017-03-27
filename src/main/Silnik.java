import javafx.geometry.Point2D;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Silnik {
    private static final String CYTRYNIAN = "Cytrynian";
    private static final String IZOCYTRYNIAN = "Izocytrynian";
    private static final String AKONITAN = "cis-Akonitan";
    private static final String IZOMERYZACJA = "izomeryzacja";
    private static final String LOG_FILE_NAME = "reaction_logs.log";


    public static void main(String[] args) {
        configureLogging();

        HashMap<Reagent, Reagent> mapaIzomeryzacji = new HashMap<>();

        mapaIzomeryzacji.put(generujSubstrat(CYTRYNIAN), generujProdukt(AKONITAN));
        mapaIzomeryzacji.put(generujSubstrat(AKONITAN), generujProdukt(IZOCYTRYNIAN));

        Reakcja izomeryzacja = new Reakcja(IZOMERYZACJA, mapaIzomeryzacji);

        Substrat czastka1 = generujSubstrat(AKONITAN);
        System.out.println(izomeryzacja.Reaguj(czastka1).getCzastka().getNazwa());

    }

    private static Substrat generujSubstrat(String nazwa) {
        Czastka czastka = new Czastka(nazwa, new Point2D(0,0));
        return new Substrat(czastka, 1);
    }

    private static Produkt generujProdukt(String nazwa) {
        Czastka czastka = new Czastka(nazwa, new Point2D(0,0));
        return new Produkt(czastka, 1);
    }

    private static void configureLogging() {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            System.out.println(System.getProperty("user.dir"));
            fh = new FileHandler(System.getProperty("user.dir")+"\\"+LOG_FILE_NAME);
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
