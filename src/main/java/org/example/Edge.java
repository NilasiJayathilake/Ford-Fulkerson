package org.example;

public class Edge {
    // represents an Edge. The starting node, ending node and the capacity it can hold
    private int from;
    private int to;
    private int capacity;
    private int flow;
    private Edge reverse;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0; // initially flow is 0
    }

    public int residualCapacity(){
        return capacity -flow;
    }

    public void addFlow(int amount) {
        this.flow += amount;
    }
    public void setReverse(Edge reverse) {
        this.reverse = reverse;
    }

    public Edge getReverse() {
        return reverse;
    }
    public int getFrom() {
        return from;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
