package com.example.trainroutes.strategy;

import java.util.Map;

public interface RouteCalculationStrategy {
    int calculateRoutes(Map<Character, Map<Character, Integer>> adjacencyList, char start, char end);
}
