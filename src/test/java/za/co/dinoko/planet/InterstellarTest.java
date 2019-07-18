package za.co.dinoko.planet;

import java.math.BigDecimal;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hmhlongo
 */
public class InterstellarTest {

    private static final Logger L = LoggerFactory.getLogger(InterstellarTest.class);

    public InterstellarTest() {
    }

    @Test
    public void shortestPathBug() throws Exception {

        Planet planA = new Planet("A", Interstellar.INFINITY);
        Planet planB = new Planet("B", Interstellar.INFINITY);
        Planet planC = new Planet("C", Interstellar.INFINITY);
        Planet planD = new Planet("D", Interstellar.INFINITY);
        Planet planE = new Planet("E", Interstellar.INFINITY);
        Planet planF = new Planet("F", Interstellar.INFINITY);

        planA.addDestination(planB, new BigDecimal(10));
        planA.addDestination(planC, new BigDecimal(15));

        planB.addDestination(planD, new BigDecimal(12));
        planB.addDestination(planF, new BigDecimal(15));

        planC.addDestination(planE, new BigDecimal(10));

        planD.addDestination(planE, new BigDecimal(2));
        planD.addDestination(planF, new BigDecimal(1));

        planF.addDestination(planE, new BigDecimal(5));

        Interstellar stellar = new Interstellar();

        stellar.addPlanet(planA);
        stellar.addPlanet(planB);
        stellar.addPlanet(planC);
        stellar.addPlanet(planD);
        stellar.addPlanet(planE);
        stellar.addPlanet(planF);

        new Processing().calculateShortestPathFromSource(planA);

        L.info("SSSSS: {}, {}", planF.getShortestPath(), planF.getDistance());

    }

}
