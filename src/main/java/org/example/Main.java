package org.example;

import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {
        String fileName = "graph.txt";
        Parser parser = new Parser();
        try {
            Graph graph = parser.parserToRead(fileName);
            graph.printGraph();
            FindMaxFlowAlgo fordFulkerson = new FindMaxFlowAlgo(graph);
            int source = 0;
            int sink = graph.getNoOfNodes() -1;
            int maxFlowOf = fordFulkerson.maxFlow(source,sink);
            System.out.println("Max Flow of the graph: "+maxFlowOf);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}