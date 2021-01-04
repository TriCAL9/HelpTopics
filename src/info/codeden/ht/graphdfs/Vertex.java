package info.codeden.ht.graphdfs;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Vertex implements Comparable<Vertex>{
    private static final Comparator<Vertex> COMPARATOR = Comparator.comparing((Vertex v) -> v.vertexName)
            .thenComparingInt((Vertex v) -> v.getValue());
    private String vertexName;
    private int value;
    private ArrayList<Vertex> adjEdge = new ArrayList<>();



    public Vertex(String vertexName, int value) {
        this.vertexName = vertexName;
        this.value = value;
    }

    public ArrayList<Vertex> getAdjEdge() {
        return adjEdge;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

    public int getValue() {
        return value;
    }

    public String getVertexName() {
        return vertexName;
    }

    public Vertex() {
        System.out.println("SK awesome");
    }

    @Override
    public int compareTo (Vertex v) {
        return COMPARATOR.compare(this, v);
    }
}
