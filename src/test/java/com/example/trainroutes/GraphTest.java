package com.example.trainroutes;

import com.example.trainroutes.strategy.ExactStopsStrategy;
import com.example.trainroutes.strategy.MaxDistanceStrategy;
import com.example.trainroutes.strategy.MaxStopsStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    private Graph graph;

    @Before
    public void setUp() {
        String[] routes = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
        graph = new Graph(routes);
    }

    @Test
    public void testCalculateRouteDistance_ABC() {
        assertEquals("9", graph.calculateRouteDistance("A-B-C"));
    }

    @Test
    public void testCalculateRouteDistance_AD() {
        assertEquals("5", graph.calculateRouteDistance("A-D"));
    }

    @Test
    public void testCalculateRouteDistance_ADC() {
        assertEquals("13", graph.calculateRouteDistance("A-D-C"));
    }

    @Test
    public void testCalculateRouteDistance_AEBCD() {
        assertEquals("22", graph.calculateRouteDistance("A-E-B-C-D"));
    }

    @Test
    public void testCalculateRouteDistance_AED() {
        assertEquals("NO SUCH ROUTE", graph.calculateRouteDistance("A-E-D"));
    }

    @Test
    public void testCountTripsMaxStops_C_C_Max3() {
        assertEquals(2, graph.countTrips('C', 'C', new MaxStopsStrategy(3)));
    }

    @Test
    public void testCountTripsExactStops_A_C_Exact4() {
        assertEquals(3, graph.countTrips('A', 'C', new ExactStopsStrategy(4)));
    }

    @Test
    public void testShortestRoute_A_C() {
        assertEquals(9, graph.shortestRoute('A', 'C'));
    }

    @Test
    public void testShortestRoute_B_B() {
        assertEquals(9, graph.shortestRoute('B', 'B'));
    }

    @Test
    public void testCountTripsMaxDistance_C_C_LessThan30() {
        assertEquals(7, graph.countTrips('C', 'C', new MaxDistanceStrategy(30)));
    }
}
