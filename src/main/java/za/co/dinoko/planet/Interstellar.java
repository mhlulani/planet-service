package za.co.dinoko.planet;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Interstellar {

    public static final BigDecimal INFINITY = BigDecimal.valueOf(Long.MAX_VALUE);
    public static final BigDecimal LIGHT_YEAR_CONSTANT = BigDecimal.valueOf(9_460_730_472_580_800L); // meters
    public static final BigDecimal PASSENGER_TRAVEL_SPEED = BigDecimal.valueOf(7_500_000_000_000L); // meters per second

    private Set<Planet> planets = new HashSet<>();

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }
}
