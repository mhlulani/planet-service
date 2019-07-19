package za.co.dinoko.planet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author hmhlongo
 */
@Entity
public class Planet implements Serializable {

    @Id
    private String name;
    private String description;
    @Transient
    private Map<Planet, BigDecimal> adjacentPlanets;
    @Transient
    private BigDecimal distance;
    @Transient
    private List<Planet> shortestPath;

    public Planet() {
        this(null);
    }

    public Planet(String name) {
        this.name = name;
        this.distance = Interstellar.INFINITY;
        this.shortestPath = new LinkedList<>();
        this.adjacentPlanets = new HashMap<>();
    }

    public void addDestination(Planet destination, BigDecimal distance) {
        adjacentPlanets.put(destination, distance);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdjacentPlanets(Map<Planet, BigDecimal> adjacentPlanets) {
        this.adjacentPlanets = adjacentPlanets;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Planet> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Planet> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Map<Planet, BigDecimal> getAdjacentPlanets() {
        return adjacentPlanets;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planet other = (Planet) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Planet{" + "name=" + name + ", distance=" + distance + '}';
    }
}
