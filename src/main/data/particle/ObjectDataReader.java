package data.particle;

import data.particle.classdata.ObjectDatabase;
import logic.Czastka;

import java.util.List;

/**
 * Created by Maciej on 20.04.2017.
 * 14:22
 * Project: MiSS.
 */
public class ObjectDataReader implements IDataReader {

    private ObjectDatabase od = new ObjectDatabase();

    public ObjectDataReader() {
    }

    @Override
    public List<Czastka> getParticles() {
        return od.getCzastkaList();
    }

    @Override
    public void replaceParticle(Czastka c1, Czastka c2) {
        removeParticle(c1);
        addParticle(c2);
    }

    @Override
    public void removeParticle(Czastka c) {
        od.getCzastkaList().remove(c);
    }

    @Override
    public void addParticle(Czastka c) {
        od.getCzastkaList().add(c);
    }
}
