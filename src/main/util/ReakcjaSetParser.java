package util;

import enums.CzastkaEnum;
import model.ReakcjaModel;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maciej on 03.04.2017.
 * 22:15
 * Project: MiSS.
 */
public class ReakcjaSetParser {

    private String pattern = "->";


    public boolean dodajNowaReakcja(String nazwa, String wzorNowejReakcji) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<String> reakcjaPodzielona = podzielReakcje(wzorNowejReakcji);

        try(Writer writer = new FileWriter("Output.json")) {

            Map<CzastkaEnum, Integer> lewaStronaReakcji = parseCzescRekacji(reakcjaPodzielona.get(0));
            Map<CzastkaEnum, Integer> prawaStronaReakcji = parseCzescRekacji(reakcjaPodzielona.get(1));

            ReakcjaModel nowaReakcja = new ReakcjaModel(nazwa, lewaStronaReakcji, prawaStronaReakcji);
//            gson.toJson(nowaReakcja, writer);
            mapper.writeValue(writer, nowaReakcja);
            writer.close();
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public List<ReakcjaModel> pobierzReakcje() throws IOException {
        List<ReakcjaModel> result = new LinkedList<>();
        ObjectMapper mapper = new ObjectMapper();
        String filename = "Output.json";
//        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
//            Gson gson = new GsonBuilder().create();
//            ReakcjaModel rm = gson.fromJson(reader, ReakcjaModel.class);
//            result.add(rm);
//        }
//        Gson gson = new Gson();
//        JsonReader reader = new JsonReader(new FileReader(filename));

        ReakcjaModel rm = mapper.readValue(new File(filename), ReakcjaModel.class);
        result.add(rm);

        return result;
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
