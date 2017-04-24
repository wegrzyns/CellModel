package logic;

import enums.ParticleType;
import javafx.geometry.Point2D;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Particle {

    private final ParticleType particleType;
    private Location location;
    private double energy;

    public Particle(ParticleType nazwa, Location location) {
        this.particleType = nazwa;
        this.location = location;
    }

    public ParticleType getParticleType() {
        return particleType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}
