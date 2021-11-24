package info.codeden.ht.adt.graphdfs;

public class Edge {
    private final Vertex<String> v;
    private final Vertex<String> w;
    private int weight;

    public Edge(Vertex<String> v, Vertex<String> w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Edge(Vertex<String> v, Vertex<String> w) {
        this.v = v;
        this.w = w;
    }

    public Vertex<String> getV() {
        return v;
    }

    public Vertex<String> getW() {
        return w;
    }

    public int getWeight() {
        return weight;
    }

}
