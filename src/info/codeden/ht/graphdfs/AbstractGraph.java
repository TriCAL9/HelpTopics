package info.codeden.ht.graphdfs;

import java.util.ArrayList;
import java.util.List;

public interface AbstractGraph<T> {
    void addVertexInfo(T value, String name);

    void removeVertex(Vertex<T> v);

    Integer addVertex();

    int getNumVertices();

    int getNumEdges();

    int getEdgeWeight(Vertex<T> v, Vertex<T> w);

    void addEdge(Edge edge);

    void removeEdge(Edge edge);

    Edge findEdge(Vertex<T> v, Vertex<T> w);

    boolean isEdge(Vertex<Integer> v, Vertex<Integer> w);

    boolean isConnected();

    boolean hasCycle();

    List topologicalSort(Graph graph);
}