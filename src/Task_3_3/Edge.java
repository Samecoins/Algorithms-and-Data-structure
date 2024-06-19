package Task_3_3;

import java.util.*;

// Класс для представления ребра графа
class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Метод для сравнения ребер по весу
    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

// Класс для представления графа
class Graph {
    int vertices;
    LinkedList<Edge>[] adjacencylist;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge);

        // Добавляем обратное ребро для неориентированного графа
        edge = new Edge(destination, source, weight);
        adjacencylist[destination].addFirst(edge);
    }

    public void primMST() {
        boolean[] inMST = new boolean[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        LinkedList<Edge> mst = new LinkedList<>();

        inMST[0] = true;
        for (Edge edge : adjacencylist[0]) {
            pq.add(edge);
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (inMST[edge.destination]) {
                continue;
            }

            inMST[edge.destination] = true;
            mst.add(edge);

            for (Edge e : adjacencylist[edge.destination]) {
                if (!inMST[e.destination]) {
                    pq.add(e);
                }
            }
        }

        printMST(mst);
    }

    public void printMST(LinkedList<Edge> mst) {
        System.out.println("Минимальное остовое дерево: ");
        for (Edge edge : mst) {
            System.out.println("Ребро: (" + edge.source + " - " + edge.destination + ")" );
        }
    }
}

class PrimMST {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        graph.primMST();
    }
}
