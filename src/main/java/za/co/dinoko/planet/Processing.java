package za.co.dinoko.planet;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Processing {

    private static final Logger L = LoggerFactory.getLogger(Processing.class);

    public void calculateShortestPathFromSource(Planet source) {

        source.setDistance(BigDecimal.ZERO);

        Set<Planet> good = new HashSet<>();
        Set<Planet> evaluate = new HashSet<>();
        evaluate.add(source);

        while (!evaluate.isEmpty()) {
            Planet currentPlanet = getLowestDistancePlanet(evaluate);
            evaluate.remove(currentPlanet);
            for (Entry<Planet, BigDecimal> adjacencyPair : currentPlanet.getAdjacentPlanets().entrySet()) {
                Planet adjacentPlanet = adjacencyPair.getKey();
                BigDecimal edgeWeigh = adjacencyPair.getValue();

                if (!good.contains(adjacentPlanet)) {
                    CalculateMinimumDistance(adjacentPlanet, edgeWeigh, currentPlanet);
                    evaluate.add(adjacentPlanet);
                }
            }
            good.add(currentPlanet);
        }
    }

    private void CalculateMinimumDistance(Planet evaluationPlanet, BigDecimal edgeWeight, Planet sourcePlanet) {

        if (sourcePlanet.getDistance().add(edgeWeight).compareTo(evaluationPlanet.getDistance()) < 0) {
            evaluationPlanet.setDistance(sourcePlanet.getDistance().add(edgeWeight));
            List<Planet> shortestPath = new LinkedList<>(sourcePlanet.getShortestPath()); // Why new?
            shortestPath.add(sourcePlanet);
            evaluationPlanet.setShortestPath(shortestPath);
        }
    }

    private Planet getLowestDistancePlanet(Set<Planet> unsettledPlanets) {
        Planet lowestDistancePlanet = null;
        BigDecimal lowestDistance = Interstellar.INFINITY;
        for (Planet planet : unsettledPlanets) {
            if (planet.getDistance().compareTo(lowestDistance) < 0) {
                lowestDistance = planet.getDistance();
                lowestDistancePlanet = planet;

            }
        }
        return lowestDistancePlanet;
    }
}
