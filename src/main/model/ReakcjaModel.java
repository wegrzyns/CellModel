package model;

import enums.ParticleType;

import java.util.Map;

/**
 * Created by Maciej on 03.04.2017.
 * 23:42
 * Project: MiSS.
 */
public class ReakcjaModel {

    private String nazwa;
    private Map<ParticleType, Integer> lewaStrona;
    private Map<ParticleType, Integer> prawaStrona;

    public ReakcjaModel() {
    }

    public ReakcjaModel(String nazwa, Map<ParticleType, Integer> lewaStrona, Map<ParticleType, Integer> prawaStrona) {
        this.nazwa = nazwa;
        this.lewaStrona = lewaStrona;
        this.prawaStrona = prawaStrona;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Map<ParticleType, Integer> getLewaStrona() {
        return lewaStrona;
    }

    public void setLewaStrona(Map<ParticleType, Integer> lewaStrona) {
        this.lewaStrona = lewaStrona;
    }

    public Map<ParticleType, Integer> getPrawaStrona() {
        return prawaStrona;
    }

    public void setPrawaStrona(Map<ParticleType, Integer> prawaStrona) {
        this.prawaStrona = prawaStrona;
    }

    @Override
    public String toString() {
        return "ReakcjaModel{" +
                "nazwa='" + nazwa + '\'' +
                ", lewaStrona=" + lewaStrona +
                ", prawaStrona=" + prawaStrona +
                '}';
    }
}
