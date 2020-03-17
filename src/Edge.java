class Edge {
    private Vertex dest;
    private int weight;
    Edge(Vertex dest, int weight){
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex getDest(){
        return dest;
    }

    public int getWeight(){
        return weight;
    }
}
