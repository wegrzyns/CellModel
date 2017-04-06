package model;

import enums.CzastkaEnum;

import java.util.Map;

/**
 * Created by Maciej on 03.04.2017.
 * 23:42
 * Project: MiSS.
 */
public class ReakcjaModel {

    private String nazwa;
    private Map<CzastkaEnum, Integer> lewaStrona;
    private Map<CzastkaEnum, Integer> prawaStrona;

    public ReakcjaModel() {
    }

    public ReakcjaModel(String nazwa, Map<CzastkaEnum, Integer> lewaStrona, Map<CzastkaEnum, Integer> prawaStrona) {
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

    public Map<CzastkaEnum, Integer> getLewaStrona() {
        return lewaStrona;
    }

    public void setLewaStrona(Map<CzastkaEnum, Integer> lewaStrona) {
        this.lewaStrona = lewaStrona;
    }

    public Map<CzastkaEnum, Integer> getPrawaStrona() {
        return prawaStrona;
    }

    public void setPrawaStrona(Map<CzastkaEnum, Integer> prawaStrona) {
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
