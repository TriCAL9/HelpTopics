package info.codeden.ht.graphdfs;

import java.util.Objects;

public class Edge {
    private final Vertex v;
    private final Vertex w;
    private int weight;

    public Edge(Vertex v, Vertex w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Edge(Vertex v, Vertex w) {
        this.v = v;
        this.w = w;
    }

    public Vertex getV() {
        return v;
    }

    public Vertex getW() {
        return w;
    }

    public int getWeight() {
        return weight;
    }

}
