package logic;

import enums.CzastkaEnum;
import javafx.geometry.Point2D;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Czastka {

    private CzastkaEnum nazwa;
    private Point2D location;

    public Czastka(CzastkaEnum nazwa, Point2D location) {
        this.nazwa = nazwa;
        this.location = location;
    }

    public CzastkaEnum getNazwa() {
        return nazwa;
    }

    public void setNazwa(CzastkaEnum nazwa) {
        this.nazwa = nazwa;
    }

    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Czastka czastka = (Czastka) o;

        if (nazwa != czastka.nazwa) return false;
        return location != null ? location.equals(czastka.location) : czastka.location == null;

    }

    @Override
    public int hashCode() {
        int result = nazwa.hashCode();
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
