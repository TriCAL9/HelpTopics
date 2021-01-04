package info.codeden.ht.graphdfs;

public interface AbstractGraph<T> {

    Integer addVertex();

    int getNumVertices();

    int getNumEdges();

    int getEdgeWeight(T v, T w);

    void addEdge(Edge edge);

    void removeEdge(Edge edge);

    Edge findEdge(T v, T w);

    boolean isEdge(T v, T w);

    boolean isConnected();

    boolean hasCycle();
}