package info.codeden.ht.graphdfs;

public class Edge {
    private final Vertex<Integer> v;
    private final Vertex<Integer> w;
    private int weight;

    public Edge(Vertex<Integer> v, Vertex<Integer> w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Edge(Vertex<Integer> v, Vertex<Integer> w) {
        this.v = v;
        this.w = w;
    }

    public Vertex<Integer> getV() {
        return v;
    }

    public Vertex<Integer> getW() {
        return w;
    }

    public int getWeight() {
        return weight;
    }

}
