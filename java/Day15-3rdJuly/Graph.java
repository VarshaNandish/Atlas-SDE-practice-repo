public class Graph {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    int vertex;
    Edge[] edges;
    int edgeCount = 0;


    Graph(int vertex, int totalEdges) {
        this.vertex = vertex;
        edges = new Edge[totalEdges];
    }

    void addEdge(int src, int dest) {

        if (edgeCount < edges.length) {
            edges[edgeCount++] = new Edge(src, dest);
        } else {
            System.out.println("Cannot add more edges. Limit reached.");
        }
    }

    void displayEdges() {

        System.out.println("Graph Edges:");
        for (Edge e : edges) {
            if (e != null)
                System.out.println(e.src + " - " + e.dest);
        }
    }

    public static void main(String[] args) {

        int vertex = 5;
        int totalEdges = 8;

        Graph graph = new Graph(vertex, totalEdges);

        graph.addEdge(1, 2);

        graph.addEdge(1, 3);

        graph.addEdge(1, 4);

        graph.addEdge(2, 4);

        graph.addEdge(2, 5);

        graph.addEdge(3, 4);

        graph.addEdge(3, 5);

        graph.addEdge(4, 5);

        graph.displayEdges();

    }

}