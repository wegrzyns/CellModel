package data.particle.classdata;

import enums.ParticleType;
import javafx.geometry.Point2D;
import logic.Location;
import logic.Particle;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maciej on 20.04.2017.
 * 14:27
 * Project: MiSS.
 */
public class ObjectDatabase {

    private List<Particle> particleList = new LinkedList<>();

    public ObjectDatabase() {
        generateParticleSet();
    }

    public List<Particle> getParticleList() {
        return particleList;
    }

    public void setParticleList(List<Particle> particleList) {
        this.particleList = particleList;
    }

    private void generateParticleSet() {
        particleList.add(new Particle(ParticleType.AKONITAN, new Location(new Point2D(0,0))));
        particleList.add(new Particle(ParticleType.AKONITAN, new Location(new Point2D(0,1))));
        particleList.add(new Particle(ParticleType.AKONITAN, new Location(new Point2D(1,1))));
        particleList.add(new Particle(ParticleType.CYTRYNIAN, new Location(new Point2D(1,0))));
    }

}
