package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxFlowAlgo {
    Graph graph;
    // Choosing the Ford-Fulkerson Algorithm to find the Max flow of the Graph
    /* Choosing BFS to find Augmenting Paths
            BFS function will return True / False boolean signifying Augmented Path Found or Not
            Pass Source, Sink and an Array to store the Augmenting Path
            (We will be storing the previous node (parent) of the current node.
             In the end we'll backtrack it to construct the augmented path. So we call it as parent[])
     */

    public FindMaxFlowAlgo(Graph graph) {
        this.graph = graph;
    }

    public int maxFlow(int source, int sink){
        int flow = 0;
        int[] parent = new int[graph.noOfNodes];

        while (BFS(source, sink, parent)) { // while there is an Augmenting Path

            int bottleNeckValue = Integer.MAX_VALUE;  // initialize to a very large no at first

            // find the Bottleneck Value
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                Edge edge = findEdge(u, v);
                bottleNeckValue = Math.min(bottleNeckValue, edge.residualCapacity());
            }
            // add the Bottleneck value to the current flow
            for (int v = sink; v != source; v=parent[v]){
                int u = parent[v];
                Edge edge = findEdge(u,v);
                edge.addFlow(bottleNeckValue);
            }
            flow +=bottleNeckValue;

        }

        return flow;
    }

    public Edge findEdge(int from, int to){
        for (Edge edge: graph.getEdgesFromTheVisitedNode(from)) {
                if (edge.getTo() == to){
                    return edge;
                }
        }
        throw new RuntimeException("Edge from " + from + " to " + to + " not found");
    }
    public boolean BFS(int source, int sink, int[] parent){
        boolean[] visited = new boolean[graph.getNoOfNodes()];
        // At the beginning every node is un visited
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()){
            int u = queue.poll();
            for (Edge edge: graph.getEdgesFromTheVisitedNode(u)){
                int v = edge.getTo();
                if (!visited[v] && edge.residualCapacity() > 0) { // if that node is not visited before and edge has residual capacity
                    queue.offer(v); // adding the adjacent neighbours to the queue
                    visited[v] = true;
                    parent[v] = u;
                    if (v == sink) {
                        return true; // Augmenting Path found! yay!
                    }
                }
            }

        }
        return false; // path not found :(
    }
}
