package za.co.dinoko.planet.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.dinoko.planet.Edge;
import za.co.dinoko.planet.Interstellar;
import za.co.dinoko.planet.Planet;
import za.co.dinoko.planet.service.InterstellarService;
import za.co.dinoko.planet.service.ShortestPathResult;

@RestController
@RequestMapping("/milkyway")
public class MilkyController {

    @Autowired
    private InterstellarService service;

    @GetMapping
    public List<Edge> fetchGraph() {
        return service.fetchGraph();
    }

    @PostMapping
    public Long newRoute(@RequestBody Edge edge) {
        return service.createRoute(edge);
    }

    @GetMapping(value = "/shortest-distance")
    public ShortestPathResult shortestFrom(@RequestParam("from") String from, @RequestParam("to") String to) {

        Planet start = null;
        Planet end = null;

        List<Edge> graph = service.fetchGraph();

        for (Edge edge : graph) {

            Planet origin = edge.getOrigin();
            Planet destin = edge.getDestination();

            if (start == null) {
                // Get reference of the selected planet by name
                if (from.equals(origin.getName())) {
                    start = origin;
                } else if (from.equals(destin.getName())) {
                    start = destin;
                }
            }

            if (end == null) {
                // Get reference of the selected planet by name
                if (to.equals(origin.getName())) {
                    end = origin;
                } else if (to.equals(destin.getName())) {
                    end = destin;
                }
            }

            origin.addDestination(destin, edge.getDistance());
        }

        if (start == null) {
            throw new IllegalStateException("Invalid source planet selected");
        }

        // TODO: cater for cases where there is no way to get to a spacific planet
        if (end == null) {
            throw new IllegalStateException("Invalid end planet selected");
        }

        service.calculateShortestPathFromSource(start);

        ShortestPathResult result = new ShortestPathResult();

        result.setSource(String.format("%s(%s)", start.getDescription(), start.getName()));
        result.setDestination(String.format("%s(%s)", end.getDescription(), end.getName()));
        result.setDistance(end.getDistance().multiply(Interstellar.LIGHT_YEAR_CONSTANT));
        result.setRoute(new ArrayList<>());
        end.getShortestPath().stream().forEach(p -> result.getRoute().add(String.format("%s(%s)", p.getDescription(), p.getName())));
        result.getRoute().add(String.format("%s(%s)", end.getDescription(), end.getName())); // This is just for extra clarity
        return result;
    }
}
