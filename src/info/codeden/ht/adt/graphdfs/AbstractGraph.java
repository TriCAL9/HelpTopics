package info.codeden.ht.adt.graphdfs;

import java.util.LinkedHashMap;
import java.util.List;

public interface AbstractGraph<T> {
    //Allows the client to add Vertex information to the graph
    void addVertexInfo(int value, T name);

    //Allows the client to remove Vertex information from the graph
    void removeVertexInfo(Vertex<? extends T > v);

    //Adds a vertex to the graph
    Integer addVertex();

    //Determines the number of vertices in the graph.
    int getNumVertices();

    //Determines the number of edges in the graph.
    int getNumEdges();

    //Determines the weight of the edge between vertices v and w.
    int getEdgeWeight(Vertex<T> v, Vertex<T> w);

    //Adds an edge to the graph.
    void addEdge(Edge edge);

    //Removes an edge from the graph.
    void removeEdge(Edge edge);

    //Finds the edge between v and w.
    Edge findEdge(Vertex<T> v, Vertex<T> w);

    //Determines if an edge exists between vertices v and w.
    boolean isEdge(Vertex<T> v, Vertex<T> w);

    //Determines if a graph is connected.
    boolean isConnected();

    //Determines if a graph has a cycle.
    boolean hasCycle();

    //Determines a minimum spanning tree for a connected undirected graph.
    void minimumST();

    //Determines a topological order of a graph
    abstract List<Vertex<T>> topologicalSort(AbstractGraph<T> graph);

    LinkedHashMap<Vertex<T>, Integer> getAdjList(Vertex<T> v);
}