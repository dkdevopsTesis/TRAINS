package com.example.trainroutes;

import com.example.trainroutes.strategy.RouteCalculationStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private final Map<Character, Map<Character, Integer>> adjacencyList;

    public Graph(String[] routes) {
        adjacencyList = Arrays.stream(routes)
                .map(route -> new Route(route.charAt(0), route.charAt(1), Character.getNumericValue(route.charAt(2))))
                .collect(Collectors.groupingBy(route -> route.from,
                        Collectors.toMap(route -> route.to, route -> route.distance)));
    }

    public String calculateRouteDistance(String route) {
        String[] towns = route.split("-");
        int distance = 0;
        for (int i = 0; i < towns.length - 1; i++) {
            char from = towns[i].charAt(0);
            char to = towns[i + 1].charAt(0);
            if (adjacencyList.containsKey(from) && adjacencyList.get(from).containsKey(to)) {
                distance += adjacencyList.get(from).get(to);
            } else {
                return "NO SUCH ROUTE";
            }
        }
        return String.valueOf(distance);
    }

    public int countTrips(char start, char end, RouteCalculationStrategy strategy) {
        return strategy.calculateRoutes(adjacencyList, start, end);
    }

    public int shortestRoute(char start, char end) {
        Map<Character, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (distances.containsKey(current.town)) continue;
            distances.put(current.town, current.distance);
            if (current.town == end) break;

            adjacencyList.getOrDefault(current.town, Collections.emptyMap()).forEach((neighbor, distance) -> {
                if (!distances.containsKey(neighbor)) {
                    pq.add(new Node(neighbor, current.distance + distance));
                }
            });
        }
        return distances.getOrDefault(end, -1);
    }

    private static class Route {
        char from;
        char to;
        int distance;

        Route(char from, char to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }
    }

    private static class Node {
        char town;
        int distance;

        Node(char town, int distance) {
            this.town = town;
            this.distance = distance;
        }
    }
}
