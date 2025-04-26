package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Integer, List<Edge>> graph;
    int noOfNodes;
    // Graph is Represented in the adjacent List format to match the parser file input
    public Graph(int noOfNodes) {
        this.noOfNodes = noOfNodes;
        this.graph = new HashMap<>(noOfNodes);
    }

    public void addEdge(int from, int to, int capacity){
        Edge edge = new Edge(from, to, capacity);
        graph.putIfAbsent(from, new ArrayList<>()); // putIfAbsent adds a new node, or if the node already exists it modifies
        graph.get(from).add(edge);
    }


    public void printGraph(){
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i+" --> ");
            List<Edge> nodeList= graph.get(i);
            for (int j = 0; j < nodeList.size(); j++) {
                System.out.print(nodeList.get(j).getTo()+" -->");
            }

            System.out.println();
        }
    }

    public List<Edge> getEdgesFromTheVisitedNode(int u){
        return graph.getOrDefault(u,new ArrayList<>());
        // returns a list of edges of the passed node (u).
        // If it doesn't have edges creates and empty list To avoid NullPointerException
    }
    public int getNoOfNodes() {
        return noOfNodes;
    }

    public void setNoOfNodes(int noOfNodes) {
        this.noOfNodes = noOfNodes;
    }
}
