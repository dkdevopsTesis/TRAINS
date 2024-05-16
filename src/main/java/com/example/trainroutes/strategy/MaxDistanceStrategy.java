package com.example.trainroutes.strategy;

import java.util.Map;

public class MaxDistanceStrategy implements RouteCalculationStrategy {
    private final int maxDistance;

    public MaxDistanceStrategy(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public int calculateRoutes(Map<Character, Map<Character, Integer>> adjacencyList, char start, char end) {
        return dfsCountTrips(adjacencyList, start, end, maxDistance, 0);
    }

    private int dfsCountTrips(Map<Character, Map<Character, Integer>> adjacencyList, char current, char end, int maxDistance, int currentDistance) {
        if (currentDistance >= maxDistance) return 0;
        int count = 0;
        if (current == end && currentDistance != 0) count++;
        for (var neighbor : adjacencyList.getOrDefault(current, Map.of()).entrySet()) {
            count += dfsCountTrips(adjacencyList, neighbor.getKey(), end, maxDistance, currentDistance + neighbor.getValue());
        }
        return count;
    }
}
