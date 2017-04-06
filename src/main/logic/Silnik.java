package logic;

import model.ReakcjaModel;
import util.ReakcjaSetParser;
import decorators.CellResourceMap;
import enums.CzastkaEnum;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Silnik {

    private static final String IZOMERYZACJA = "izomeryzacja";
    private static final String LOG_FILE_NAME = "reaction_logs.log";
    public static final String REACTION_LOGGER_NAME = "MyLog";


    public static void main(String[] args) throws InterruptedException {

        configureLogging();

        HashMap<CellResourceMap, CellResourceMap> reakcjaIzomeryzacji = prepareIzomerationReaction();

        Komorka komorka = prepareCell();

        Reakcja izomeryzacja = new Reakcja(IZOMERYZACJA, reakcjaIzomeryzacji, komorka);
        izomeryzacja.reaguj();

        ReakcjaSetParser rsp = new ReakcjaSetParser();
        try {
            rsp.dodajNowaReakcja("ok", "2_Woda + 5_Akonitan -> 4_Woda + 3_Akonitan");
            List<ReakcjaModel> r = rsp.pobierzReakcje();
            r.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Komorka prepareCell() {
        CellResourceMap zasobyKomorki =  new CellResourceMap();
        zasobyKomorki.put(CzastkaEnum.CYTRYNIAN, 100);
        return new Komorka(zasobyKomorki);

    }

    private static HashMap<CellResourceMap, CellResourceMap> prepareIzomerationReaction() {
        HashMap<CellResourceMap, CellResourceMap> reakcjaIzomeryzacji = new LinkedHashMap<>();
        CellResourceMap substraty1 = new CellResourceMap();
        CellResourceMap produkty1 = new CellResourceMap();
        CellResourceMap substraty2 = new CellResourceMap();
        CellResourceMap produkty2 = new CellResourceMap();

        substraty1.put(CzastkaEnum.CYTRYNIAN, 1);
        produkty1.put(CzastkaEnum.AKONITAN, 1);
        produkty1.put(CzastkaEnum.WODA, 1);

        reakcjaIzomeryzacji.put(substraty1, produkty1);

        substraty2.put(CzastkaEnum.AKONITAN, 1);
        substraty2.put(CzastkaEnum.WODA, 1);
        produkty2.put(CzastkaEnum.IZOCYTRYNIAN, 1);

        reakcjaIzomeryzacji.put(substraty2, produkty2);

        return reakcjaIzomeryzacji;
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
