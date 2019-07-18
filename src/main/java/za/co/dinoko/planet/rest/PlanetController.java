package za.co.dinoko.planet.rest;

import java.util.List;
import jdk.internal.jline.internal.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import za.co.dinoko.planet.Edge;
import za.co.dinoko.planet.Planet;
import za.co.dinoko.planet.service.InterstellarService;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private InterstellarService service;

    @GetMapping
    public List<Planet> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "_graph")
    public List<Edge> findGraph() {
        return service.fetchGraph();
    }

    @GetMapping(value = "/{id}")
    public Planet findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Planet resource) {
        Preconditions.checkNotNull(resource);
        return service.create(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Planet resource) {
        Preconditions.checkNotNull(resource);
        service.update(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
