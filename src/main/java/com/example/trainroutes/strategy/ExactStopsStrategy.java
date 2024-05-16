package com.example.trainroutes.strategy;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ExactStopsStrategy implements RouteCalculationStrategy {
    private final int exactStops;

    public ExactStopsStrategy(int exactStops) {
        this.exactStops = exactStops;
    }

    @Override
    public int calculateRoutes(Map<Character, Map<Character, Integer>> adjacencyList, char start, char end) {
        Queue<RouteNode> queue = new LinkedList<>();
        queue.add(new RouteNode(start, 0));
        int tripCount = 0;

        while (!queue.isEmpty()) {
            RouteNode current = queue.poll();
            if (current.stops == exactStops && current.town == end) {
                tripCount++;
            }
            if (current.stops < exactStops) {
                adjacencyList.getOrDefault(current.town, Map.of()).forEach((neighbor, distance) -> {
                    queue.add(new RouteNode(neighbor, current.stops + 1));
                });
            }
        }
        return tripCount;
    }

    private static class RouteNode {
        char town;
        int stops;

        RouteNode(char town, int stops) {
            this.town = town;
            this.stops = stops;
        }
    }
}
