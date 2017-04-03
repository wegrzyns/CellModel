package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import decorators.CellResourceMap;
import enums.CzastkaEnum;
import logic.Komorka;
import logic.Reakcja;
import model.ReakcjaModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maciej on 03.04.2017.
 * 22:15
 * Project: MiSS.
 */
public class NowaReakcjaController {

    private Gson gson = new GsonBuilder().create();
    private String pattern = "->";

    public boolean dodajNowaReakcja(String nazwa, String wzorNowejReakcji) throws IOException {
        List<String> reakcjaPodzielona = podzielReakcje(wzorNowejReakcji);

        try(Writer writer = new FileWriter("Output.json")) {

            Map<CzastkaEnum, Integer> lewaStronaReakcji = parseCzescRekacji(reakcjaPodzielona.get(0));
            Map<CzastkaEnum, Integer> prawaStronaReakcji = parseCzescRekacji(reakcjaPodzielona.get(1));

            ReakcjaModel nowaReakcja = new ReakcjaModel(nazwa, lewaStronaReakcji, prawaStronaReakcji);

            gson.toJson(nowaReakcja, writer);

            writer.close();

            return true;
        } catch (Exception e) {

        }
        return false;
    }

    private List<String> podzielReakcje(String nowaReakcja) {
        return Arrays.asList(nowaReakcja.split(pattern));
    }

    private Map<CzastkaEnum, Integer> parseCzescRekacji(String czescReakcji) {

        Map<CzastkaEnum, Integer> stronaReakcji = new LinkedHashMap<>();

        String elementPatternString = "\\w+(\\d*)";
        String iloscRodzajRozdzielPatternString = "_";
        Pattern elementPattern = Pattern.compile(elementPatternString);
        Matcher czescReakcjiMatcher = elementPattern.matcher(czescReakcji);

        while (czescReakcjiMatcher.find()) {
            for (int i = 0; i < czescReakcjiMatcher.groupCount(); i++) {
                String element = czescReakcjiMatcher.group(i);
                String[] elementRozdzielony = element.split(iloscRodzajRozdzielPatternString);
                String rodzaj = elementRozdzielony[1];
                int ilosc = Integer.parseInt(elementRozdzielony[0]);
                CzastkaEnum czastka = CzastkaEnum.valueOf(rodzaj.toUpperCase());
                if(czastka != null)
                    stronaReakcji.put(czastka, ilosc);
            }
        }

        return stronaReakcji;
    }

}
