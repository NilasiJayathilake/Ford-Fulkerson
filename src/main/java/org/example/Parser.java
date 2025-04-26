package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
   public Parser(){}

    /* Method to parse the file.
        Reads the file using Scanner and Creates a new graph and returns it. */
    public Graph parserToRead(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int noOfNodes = scanner.nextInt();
        Graph graph = new Graph(noOfNodes);

        while(scanner.hasNextInt()){
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int capacity = scanner.nextInt();
            graph.addEdge(from,to,capacity);
        }
        return graph;
    }
}
