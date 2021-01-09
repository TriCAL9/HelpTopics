package info.codeden.ht.graphdfs;


import java.util.ArrayList;
import java.util.Comparator;

public class Vertex<T> implements Comparable<Vertex<Integer>>,Cloneable{
    private static final Comparator<Vertex<Integer>> COMPARATOR = Comparator.comparing((Vertex<Integer> v) -> v.vertexName)
            .thenComparingInt((Vertex<Integer> v) -> v.getValue());
    private String vertexName;
    private T value;
    private final ArrayList<Vertex<Integer>> adjEdge = new ArrayList<>();




    public Vertex(String vertexName, T value) {
        this.vertexName = vertexName;
        this.value = value;
    }

     ArrayList<Vertex<Integer>> getAdjEdge() {
        return adjEdge;
    }

     void setValue(T value) {
        this.value = value;
    }

     void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

     T getValue() {
        return value;
    }

     String getVertexName() {
        return vertexName;
    }

     Vertex() {
        System.out.println("SK awesome");
         vertexName = null;
         value = null;
     }

    @Override public Vertex<T> clone () {
        try{
            Vertex <T> vertex = (Vertex<T>)super.clone();
            return vertex;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public int compareTo (Vertex<Integer> v) {
        return COMPARATOR.compare((Vertex<Integer>) this, v);
    }
}
