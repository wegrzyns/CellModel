package logic;

import enums.ParticleType;

import java.util.*;

public class ResourcesPool {
    private final Map<ParticleType, List<Particle>> resources;

    public ResourcesPool(Map<ParticleType, List<Particle>> resources) {
        this.resources = resources;
    }

    public ResourcesPool(List<Particle> particleList) {
        LinkedHashMap<ParticleType, List<Particle>> resourceMap = new LinkedHashMap<>();
        particleList.forEach( particle -> {
            if(!resourceMap.containsKey(particle.getParticleType())) {
                List<Particle> particles = new LinkedList<>();
                particles.add(particle);
                resourceMap.put(particle.getParticleType(), particles);
            }
            else {
                resourceMap.get(particle.getParticleType()).add(particle);
            }
        });
        resources = resourceMap;
    }


    public Map<ParticleType, List<Particle>> getResources() {
        return resources;
    }

    public Set<ParticleType> getAvailableParticleTypes() {
        return getResources().keySet();
    }

    public void removeElementsOfParticleType(ParticleType particleType, int n) {
        for(int i=0; i < n; i++) {
            getResources().get(particleType).remove(0);
        }
    }

    public int getSizeOfParticleType(ParticleType particleType) {
        return getResources().get(particleType).size();
    }

    public boolean containsParticleType(ParticleType particleType) {
        return getResources().containsKey(particleType);
    }

    public void addElementsOfParticleType(ParticleType particleType, List<Particle> newParticles) {
        getResources().get(particleType).addAll(newParticles);
    }

    public void addElementOfParticleType(ParticleType particleType, Particle particle) {
        getResources().get(particleType).add(particle);
    }

    public List<Particle> getElementsOfParticleType(ParticleType particleType) {
        return getResources().get(particleType);
    }

    public void addParticleType(ParticleType particleType) {

        getResources().put(particleType, new LinkedList<>());
    }

    @Override
    public String toString() {
        return "ResourcesPool{" +
                "resources=" + printResources() +
                '}';
    }

    private String printResources() {
        StringBuilder  sb = new StringBuilder();
        resources.forEach((r, l) -> sb.append("\n\t").append(r.toString()).append(" : ").append(l.size()));
        return sb.toString();
    }
}
