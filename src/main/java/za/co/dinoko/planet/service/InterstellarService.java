package za.co.dinoko.planet.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import za.co.dinoko.planet.Edge;
import za.co.dinoko.planet.Interstellar;
import za.co.dinoko.planet.Planet;

/**
 *
 * @author hmhlongo
 */
@Service
public class InterstellarService {

    @PersistenceContext
    private EntityManager em;

    // TODO: Add pagination
    public List<Planet> findAll() {
        Query q = em.createQuery("SELECT p FROM Planet p");
        return q.getResultList();
    }

    // TODO: Add pagination
    public List<Edge> fetchGraph() {
        Query q = em.createQuery("SELECT e FROM Edge e");
        return q.getResultList();
    }

    public Planet findById(String name) {
        return em.find(Planet.class, name);
    }

    @Transactional
    public String create(Planet resource) {
        em.persist(resource);
        return resource.getName();
    }

    @Transactional
    public void update(Planet resource) {
        em.merge(resource);
    }

    @Transactional
    public void deleteById(String name) {
        int affected = em.createQuery("DELETE FROM Planet p WHERE p.name = :name")
                .setParameter("name", name)
                .executeUpdate();
    }

    // TODO: use atomic surrogate keys to generate primary keys
    @Transactional
    public Long createRoute(Edge edge) {

        Planet origin = findById(edge.getOrigin().getName());
        Planet destin = findById(edge.getDestination().getName());

        if (origin != null) {
            edge.setOrigin(origin);  // Update
        }

        if (destin != null) {
            edge.setDestination(destin); // Update
        }

        em.persist(edge);
        return edge.getId(); // This should be Generated
    }

    public void calculateShortestPathFromSource(Planet source) {

        source.setDistance(BigDecimal.ZERO);

        Set<Planet> good = new HashSet<>();
        Set<Planet> evaluate = new HashSet<>();
        evaluate.add(source);

        while (!evaluate.isEmpty()) {
            Planet currentPlanet = getLowestDistancePlanet(evaluate);
            evaluate.remove(currentPlanet);
            for (Map.Entry<Planet, BigDecimal> adjacencyPair : currentPlanet.getAdjacentPlanets().entrySet()) {
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
