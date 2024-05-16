package com.example.trainroutes;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private final String id;
    private final Map<Node, Integer> edges;

    public Node(String id) {
        this.id = id;
        this.edges = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void addEdge(Node node, int weight) {
        edges.put(node, weight);
    }

    public Map<Node, Integer> getEdges() {
        return edges;
    }

    public boolean hasEdge(Node node) {
        return edges.containsKey(node);
    }

    public int getWeightTo(Node node) {
        return edges.getOrDefault(node, -1);
    }
}
