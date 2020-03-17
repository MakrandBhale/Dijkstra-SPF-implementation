import java.util.ArrayList;
import java.util.Collections;

class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private Vertex startVertex = null;
    Vertex createVertex(String name){
        Vertex v = new Vertex(name);
        vertices.add(v);
        return v;
    }

    void addEdge(Vertex source, Vertex dest, int weight){
        source.addEdge(dest, weight);
    }

    void addEdge(Vertex source, Vertex dest, int weight, boolean isBidirectional){
        // if biDirectional is true, then both source and destination vertices will get an edge with same weight,
        // to add different weight, call addEdge(source, dest, weight) function (twice).
        source.addEdge(dest, weight);
        dest.addEdge(source, weight);
    }

    void printResult(){
        print("Distance Table");
        for(Vertex v : vertices){
            print(startVertex.getName() + " --> " + v.getName() + " : " + (v.getDistanceFromStart() == Vertex.INFINITY ? "INFINITY" : v.getDistanceFromStart()));
        }
    }

    private Vertex getClosestNeighbour(Vertex vertex){
        ArrayList<Vertex> neighbours = new ArrayList<>();
        Vertex closestNeighbour = null;
        /*If for some vertex getNeighbours() is called, then it is assumed that the vertex is traversed
        * So change its visited status.*/
        vertex.setVisited();
        for(Edge e : vertex.getEdges()){
            // traverse edges of a vertex.
            // get destination node.
            // update the distance from source to (current vertex's distance + edge's weight)
            // add to the neighbour list.
            Vertex neighbour = e.getDest();
            /*if current distance from start is greater than calculated distance then update*/
            int calculatedDistance = vertex.getDistanceFromStart() + e.getWeight();
            if(neighbour.getDistanceFromStart() > calculatedDistance)
                neighbour.updateDistanceFromStart(calculatedDistance);
            neighbours.add(neighbour);
        }
        /*sorting based on the distance from source*/
        Collections.sort(neighbours);
        /*getting all neighbours, the neighbour at first location is smallest,
        * check if it is already visited, if yes then move to next and get it.*/
        for(Vertex neighbour : neighbours){
            if(!neighbour.isVisited()){
                closestNeighbour = neighbour;
                break;
            }
        }
        return closestNeighbour;
    }

    void start(Vertex v){
        //setting up the start node, start by setting its distance
        //value from itself (which is 0)
        //then as it visited already then remove from vertices list.
        v.updateDistanceFromStart(0);
        startVertex = v;
        //vertices.remove(v);
        stream(v);
    }

    private void stream(Vertex v){
        Vertex closestNeighbour = getClosestNeighbour(v);
        if(closestNeighbour == null){
            return;
        }
        stream(closestNeighbour);
    }

    private void print(String msg){
        System.out.println(msg);
    }

}
