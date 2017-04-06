package enums;

/**
 * Created by Maciej on 30.03.2017.
 * 12:46
 * Project: MiSS.
 */
public enum CzastkaEnum {

    CYTRYNIAN,
    IZOCYTRYNIAN,
    AKONITAN,
    AKONITAZA,
    WODA;


    @Override
    public String toString() {
//        return super.toString().substring(0, 1).toUpperCase() + super.toString().substring(1).toLowerCase();
        return super.toString().toUpperCase();
    }
}
