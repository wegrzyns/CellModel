import javafx.geometry.Point2D;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Czastka {

    private String nazwa;
    private Point2D location;

    public Czastka(String nazwa, Point2D location) {
        this.nazwa = nazwa;
        this.location = location;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
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
        if (!(o instanceof Czastka)) return false;

        Czastka czastka = (Czastka) o;

        if (!nazwa.equals(czastka.nazwa)) return false;
        return location != null ? location.equals(czastka.location) : czastka.location == null;
    }

    @Override
    public int hashCode() {
        return nazwa.hashCode();
    }
}
