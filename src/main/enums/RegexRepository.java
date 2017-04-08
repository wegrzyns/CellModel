package enums;

/**
 * Created by Maciej on 08.04.2017.
 * 01:49
 * Project: MiSS.
 */
public enum RegexRepository {

    REACTIONRESULT ("->"),
    ELEMENT ("\\w+(\\d*)"),
    ILOSCRODZAJROZDZIEL ("_");


    String regex;

    RegexRepository(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return regex;
    }
}
