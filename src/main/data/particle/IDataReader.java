package data.particle;

import logic.Particle;

import java.util.List;

/**
 * Created by Maciej on 20.04.2017.
 * 14:21
 * Project: MiSS.
 */
public interface IDataReader {

    List<Particle> getParticles();

    void replaceParticle(Particle c1, Particle c2);

    void removeParticle(Particle c);

    void addParticle(Particle c);

}
