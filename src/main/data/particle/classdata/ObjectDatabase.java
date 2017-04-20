package data.particle.classdata;

import enums.CzastkaEnum;
import javafx.geometry.Point2D;
import logic.Czastka;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maciej on 20.04.2017.
 * 14:27
 * Project: MiSS.
 */
public class ObjectDatabase {

    private List<Czastka> czastkaList = new LinkedList<>();

    public ObjectDatabase() {
        generateParticleSet();
    }

    public List<Czastka> getCzastkaList() {
        return czastkaList;
    }

    public void setCzastkaList(List<Czastka> czastkaList) {
        this.czastkaList = czastkaList;
    }

    private void generateParticleSet() {
        czastkaList.add(new Czastka(CzastkaEnum.AKONITAN, new Point2D(0,0)));
        czastkaList.add(new Czastka(CzastkaEnum.AKONITAN, new Point2D(0,1)));
        czastkaList.add(new Czastka(CzastkaEnum.AKONITAN, new Point2D(1,1)));
        czastkaList.add(new Czastka(CzastkaEnum.CYTRYNIAN, new Point2D(1,0)));
    }

}
