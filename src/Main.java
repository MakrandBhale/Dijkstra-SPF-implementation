public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph g = new Graph();
        Vertex a = g.createVertex("A");
        Vertex b = g.createVertex("B");
        Vertex c = g.createVertex("C");
        Vertex d = g.createVertex("D");

        g.addEdge(a, b, 1, true);
        g.addEdge(a, d, 3, true);
        g.addEdge(b, d, 2, true);
        g.addEdge(a, c, 4, true);
        g.start(a);
        //ArrayList<Vertex> neighbours = g.getClosestNeighbour(b);
        g.printResult();
    }
}
