package data.particle;

import logic.Czastka;

import java.util.List;

/**
 * Created by Maciej on 20.04.2017.
 * 14:21
 * Project: MiSS.
 */
public interface IDataReader {

    List<Czastka> getParticles();

    void replaceParticle(Czastka c1, Czastka c2);

    void removeParticle(Czastka c);

    void addParticle(Czastka c);

}
