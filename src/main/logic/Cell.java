package logic;

import enums.ParticleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Krzysiu on 27.03.2017.
 */
public class Cell {

    private ResourcesPool resoucersPool;

    public Cell(ResourcesPool resourcesPool) {
        this.resoucersPool = resourcesPool;
    }

    public ResourcesPool getResoucersPool() {
        return resoucersPool;
    }

    public void setResoucersPool(ResourcesPool resoucersPool) {
        this.resoucersPool = resoucersPool;
    }
}
