package za.co.dinoko.planet.rest;

import java.util.List;
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
import za.co.dinoko.planet.Planet;
import za.co.dinoko.planet.service.InterstellarService;

// TODO: API Input Validation needs improvement
@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private InterstellarService service;

    @GetMapping
    public List<Planet> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{name}")
    public Planet findById(@PathVariable("name") String name) {
        return service.findById(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Planet resource) {
        return service.create(resource);
    }

    @PutMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("name") String name, @RequestBody Planet resource) {

        service.update(resource);
    }

    @DeleteMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("name") String name) {
        service.deleteById(name);
    }
}
