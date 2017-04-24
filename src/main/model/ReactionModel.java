package model;

import enums.ParticleType;

import java.util.Map;

/**
 * Created by Maciej on 03.04.2017.
 * 23:42
 * Project: MiSS.
 */
public class ReactionModel {

    private String name;
    private Map<ParticleType, Integer> leftSide;
    private Map<ParticleType, Integer> rightSide;

    public ReactionModel() {
    }

    public ReactionModel(String name, Map<ParticleType, Integer> leftSide, Map<ParticleType, Integer> rightSide) {
        this.name = name;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<ParticleType, Integer> getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(Map<ParticleType, Integer> leftSide) {
        this.leftSide = leftSide;
    }

    public Map<ParticleType, Integer> getRightSide() {
        return rightSide;
    }

    public void setRightSide(Map<ParticleType, Integer> rightSide) {
        this.rightSide = rightSide;
    }

    @Override
    public String toString() {
        return "ReactionModel{" +
                "name='" + name + '\'' +
                ", leftSide=" + leftSide +
                ", rightSide=" + rightSide +
                '}';
    }
}
