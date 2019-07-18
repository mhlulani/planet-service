package za.co.dinoko.planet.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import za.co.dinoko.planet.Edge;
import za.co.dinoko.planet.Planet;

/**
 *
 * @author hmhlongo
 */
@Service
public class InterstellarService {

    @PersistenceContext
    private EntityManager em;

    public List<Planet> findAll() {
        Query q = em.createQuery("SELECT p FROM Planet p");
        return q.getResultList();
    }

    public List<Edge> fetchGraph() {
        Query q = em.createQuery("SELECT e FROM Edge e");
        return q.getResultList();
    }

    public Planet findById(Long id) {

        return new Planet();
    }

    public Long create(Planet resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Planet resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
