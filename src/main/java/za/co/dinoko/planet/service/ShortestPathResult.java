package za.co.dinoko.planet.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author hmhlongo
 */
public class ShortestPathResult implements Serializable {

    private String source;
    private String destination;
    private BigDecimal distance;
    private List<String> route;

    public ShortestPathResult() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }
}
