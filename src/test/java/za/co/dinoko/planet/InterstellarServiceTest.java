package za.co.dinoko.planet;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.dinoko.planet.service.InterstellarService;

// TODO: There is a lot more unit tests required here
/**
 *
 * @author hmhlongo
 */
@RunWith(MockitoJUnitRunner.class)
public class InterstellarServiceTest {

    private static final Logger L = LoggerFactory.getLogger(InterstellarServiceTest.class);

    @Mock
    private EntityManager em;

    @InjectMocks
    private InterstellarService service;

    public InterstellarServiceTest() {
    }

    @Test
    public void calculate() throws Exception {

        Planet planA = new Planet("A");
        Planet planB = new Planet("B");
        Planet planC = new Planet("C");

        planA.addDestination(planB, new BigDecimal(10));
        planA.addDestination(planC, new BigDecimal(15));

        service.calculateShortestPathFromSource(planA);

        Assert.assertTrue("Invalid Planet", planB.getDistance().equals(new BigDecimal(10)));
    }

}
