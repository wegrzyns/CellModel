package data.particle;

import data.particle.classdata.ObjectDatabase;
import logic.Particle;

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
    public List<Particle> getParticles() {
        return od.getParticleList();
    }

    @Override
    public void replaceParticle(Particle c1, Particle c2) {
        removeParticle(c1);
        addParticle(c2);
    }

    @Override
    public void removeParticle(Particle c) {
        od.getParticleList().remove(c);
    }

    @Override
    public void addParticle(Particle c) {
        od.getParticleList().add(c);
    }
}
