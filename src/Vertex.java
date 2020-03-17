import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
    public static final int INFINITY = 99999;

    private String name;
    private ArrayList<Edge> edges = new ArrayList<>();
    private int distanceFromStart = INFINITY;
    private boolean isVisited = false;
    Vertex(String name){
        this.name = name;
    }

    public int getDistanceFromStart(){
        return distanceFromStart;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited() {
        /*it can only be set to true once thus no parameter to the function ;)*/
        isVisited = true;
    }

    public void updateDistanceFromStart(int distanceFromStart){
        this.distanceFromStart = distanceFromStart;
    }

    public String getName(){
        return name;
    }

    public void addEdge(Vertex v, int weight){
        this.edges.add(new Edge(v, weight));
    }

    public ArrayList<Edge> getEdges(){
        return edges;
    }

    @Override
    public int compareTo(Vertex vertex){
        return this.getDistanceFromStart() - vertex.getDistanceFromStart();
    }
}
