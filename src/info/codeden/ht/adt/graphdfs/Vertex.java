package info.codeden.ht.adt.graphdfs;


import java.util.Comparator;

public class Vertex<T> implements Comparable<Vertex<String>>,Cloneable{
    private final Comparator<Vertex<String>> COMPARATOR = Comparator.comparing((Vertex<String> v) -> v.vertexData)
            .thenComparingInt((Vertex<String> v) -> v.getIndex());
    private T vertexData;
    private int index;




    public Vertex(Integer index, T vertexName) {
        this.vertexData = vertexName;
        this.index = index;
    }

     void setIndex(int index) {
        this.index = index;
    }

     void setVertexData(T vertexData) {
        this.vertexData = vertexData;
    }

     int getIndex() {
        return index;
    }

     T getVertexData() {
        return vertexData;
    }

     Vertex() {
         vertexData = null;
         index = -1;
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
    public int compareTo (Vertex<String> v) {
        return COMPARATOR.compare((Vertex<String>) this, v);
    }
}
