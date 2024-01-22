import java.util.*;

public class Main {
    public static <List> void main(String[] args) {

        Vertex vertex0 = new Vertex(0);
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);

        // Add edges
        vertex0.addEdge(vertex1);
        vertex0.addEdge(vertex2);
        vertex1.addEdge(vertex2);
        vertex2.addEdge(vertex3);
        vertex0.addEdge(vertex4);
        vertex4.addEdge(vertex5);
        vertex5.addEdge(vertex6);
        vertex6.addEdge(vertex7);

        // Create a list of vertices
        java.util.List<Vertex> vertices = new ArrayList<>();
        vertices.add(vertex0);
        vertices.add(vertex1);
        vertices.add(vertex2);
        vertices.add(vertex3);
        vertices.add(vertex4);
        vertices.add(vertex5);
        vertices.add(vertex6);
        vertices.add(vertex7);

        // Find the longest path from vertex 0
        int longestPathLength = findLongestPath(vertices, 0);
        System.out.println("The longest path from vertex 0 has length: " + longestPathLength);
    }

    static class Vertex {
        long id;
        List<Edge> edges = new ArrayList<>();

        public Vertex(long id) {
            this.id = id;
        }

        // Method to add an edge to the vertex
        public void addEdge(Vertex to) {
            edges.add(new Edge(this, to));
        }
    }

    static class Edge {
        Vertex from;
        Vertex to;

        public Edge(Vertex from, Vertex to) {
            this.from = from;
            this.to = to;
        }
    }

    // topological sort method, using Deep First Search
    private static void topologicalSortUtil(Vertex vertex, Set<Long> visited, Stack<Vertex> stack) {
        visited.add(vertex.id);
        for (Edge edge : vertex.edges) {
            if (!visited.contains(edge.to.id)) {
                topologicalSortUtil(edge.to, visited, stack);
            }
        }
        stack.push(vertex);
    }

    // The function to find the longest path from a given starting vertex
    public static int findLongestPath(List<Vertex> vertices, long startVertexId) {
        Stack<Vertex> stack = new Stack<>();
        Set<Long> visited = new HashSet<>();

        // Perform topological Sort
        for (Vertex vertex : vertices) {
            if (!visited.contains(vertex.id)) {
                topologicalSortUtil(vertex, visited, stack);
            }
        }

        // Initialize distances to all vertices as negative infinity and
        // distance to the start vertex as 0
        Map<Long, Integer> distance = new HashMap<>();
        for (Vertex vertex : vertices) {
            distance.put(vertex.id, Integer.MIN_VALUE);
        }
        distance.put(startVertexId, 0);

        // calculate how long does it take to each vertex from the start vertex
        while (!stack.isEmpty()) {
            Vertex u = stack.pop();

            if (distance.get(u.id) != Integer.MIN_VALUE) {
                for (Edge edge : u.edges) {
                    long vId = edge.to.id;
                    if (distance.get(vId) < distance.get(u.id) + 1) {
                        distance.put(vId, distance.get(u.id) + 1);
                    }
                }
            }
        }

        // Find the maximum distance from the source vertex
        return Collections.max(distance.values());
    }
}