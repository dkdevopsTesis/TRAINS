package com.example.trainroutes;

import com.example.trainroutes.strategy.ExactStopsStrategy;
import com.example.trainroutes.strategy.MaxDistanceStrategy;
import com.example.trainroutes.strategy.MaxStopsStrategy;

public class TrainRoutes {
    public static void main(String[] args) {
        String[] routes = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
        Graph graph = new Graph(routes);

        System.out.println("Output #1: " + graph.calculateRouteDistance("A-B-C"));
        System.out.println("Output #2: " + graph.calculateRouteDistance("A-D"));
        System.out.println("Output #3: " + graph.calculateRouteDistance("A-D-C"));
        System.out.println("Output #4: " + graph.calculateRouteDistance("A-E-B-C-D"));
        System.out.println("Output #5: " + graph.calculateRouteDistance("A-E-D"));

        System.out.println("Output #6: " + graph.countTrips('C', 'C', new MaxStopsStrategy(3)));
        System.out.println("Output #7: " + graph.countTrips('A', 'C', new ExactStopsStrategy(4)));
        System.out.println("Output #8: " + graph.shortestRoute('A', 'C'));
        System.out.println("Output #9: " + graph.shortestRoute('B', 'B'));
        System.out.println("Output #10: " + graph.countTrips('C', 'C', new MaxDistanceStrategy(30)));
    }
}
