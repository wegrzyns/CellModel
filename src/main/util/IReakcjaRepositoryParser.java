package util;

import model.ReakcjaModel;

import java.io.IOException;
import java.util.List;

/**
 * Created by Maciej on 08.04.2017.
 * 01:45
 * Project: MiSS.
 */
public interface IReakcjaRepositoryParser {

    boolean dodajNowaReakcja(String nazwa, String wzorNowejReakcji) throws IOException;


}
