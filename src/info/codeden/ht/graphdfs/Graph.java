package info.codeden.ht.graphdfs;

import java.util.*;

public class Graph implements AbstractGraph<Vertex> {
    private int numVertices;                                            // number of vertices in the Graph
    private int numEdges;                                               // number of edges in the Graph

    private boolean isDirected;                                         // determines if graph is directed or undirected
    private boolean isWeighted;                                         // determines if graph is weighted or unweighted

    private final Vector<TreeMap<Vertex, Integer>> adjList = new Vector<>();     // implementation of an adjacent list

    private static final ArrayList<Vertex> visited = new ArrayList<>();
    private static final ArrayList<Vertex> treeNodeVisited = new ArrayList<>();

    /**
     * A static instance of Graph implemented with an enum.
     * The Type enum creates a graph from parameters pass to the (of) factory method of the same class.
     */
    enum Type {
        INSTANCE {
            info.codeden.ht.graphdfs.Graph of(int numVertices, boolean isDirected, boolean isWeighted) {
                return new Graph(numVertices, isDirected, isWeighted);
            }
        };

        abstract Graph of(int numVertices, boolean isDirected, boolean isWeighted);
    }

    private Graph(int n, boolean isDirected, boolean isWeighted) {
        // Constructor for Graph ADT
        // precondition of graph constructor requires n to be greater than zero

        if (n > 0) {
            numVertices = n;
            numEdges = 0;

            this.isDirected = isDirected;
            this.isWeighted = isWeighted;
            for (int i = 0; i < numVertices; i++) {
                adjList.add(new TreeMap<>());
            }
        }
    }    // Graph is initialized

    @Override
    public Integer addVertex() {
        adjList.add(new TreeMap<>());
        numVertices++;
        return adjList.lastIndexOf(null);
    }

    @Override
    public int getNumVertices() {
        return this.numVertices;
    }

    @Override
    public int getNumEdges() {
        return this.numEdges;
    }

    @Override
    public int getEdgeWeight(Vertex v, Vertex w) {
        return Objects.requireNonNull(adjList.get(v.getValue()).get(w)
                , "Not a weighted edge.");
    }

    public void addEdge(Vertex v, Vertex w, int wgt) {
        if (isDirected) {
            adjList.get(v.getValue()).put(w, wgt);
            numEdges++;
        } else {
            adjList.get(v.getValue()).put(w, wgt);
            adjList.get(w.getValue()).put(v, wgt);
            numEdges++;
        }
    }

    @Override
    public void addEdge(Edge edge) {
        Vertex v = edge.getV();
        Vertex w = edge.getW();
        int wgt = edge.getWeight();
        if (edge.getV().compareTo(edge.getW())==0) throw new RuntimeException("Can't add edge to this graph.");
        addEdge(v, w, wgt);
    }

    @Override
    public void removeEdge(Edge edge) {
        Vertex v = edge.getV();
        Vertex w = edge.getW();
        if (isDirected)
            adjList.get(v.getValue()).remove(w);
        else {
            adjList.get(v.getValue()).remove(w);
            adjList.get(w.getValue()).remove(v);
        }
    }

    @Override
    public Edge findEdge(Vertex v, Vertex w) {
        int wgt = adjList.get(v.getValue()).get(w);
        return new Edge(v, w, wgt);
    }

    @Override
    public boolean isEdge(Vertex v, Vertex w) {
        return getAdjList(v).keySet().contains(w);
    }

    @Override
    public boolean isConnected() {
        int vtemp = numVertices-1;
        if (!isDirected)
            return (numEdges >= vtemp );
        else return numVertices == visited.size();
    }

    @Override
    public boolean hasCycle() {
        if (!isDirected && isConnected()) {
            return !(numVertices - 1 == numEdges)
                    || numVertices - 1 < numEdges;

            // A directed graph is connect if the number of vertices is equal to
            // the size of the spanning tree
        } else if (isDirected) {

        }
        return false;
    }

    public void dfs(Vertex startingV) {
        System.out.printf("Vertex: %s%n", startingV.getVertexName());
        visited.add(startingV);
        for (Vertex u : this.getAdjList(startingV).keySet()) {
            if (!visited.contains(u)) {
                System.out.printf("%s %s path has weight %s%n", startingV.getVertexName(), u.getVertexName()
                        , this.getEdgeWeight(startingV, u));
                dfs(u);
            }
        }
    }
    public void dfsTree(Vertex startingV) {
        if(!treeNodeVisited.contains(startingV) && !isDirected)
            System.out.println("Vertex: " + startingV.getVertexName());
        treeNodeVisited.add(startingV);
        if (!isDirected && isConnected()) {
            for (Vertex u : this.getAdjList(startingV).keySet()) {
                if (!treeNodeVisited.contains(u)) {
                    treeNodeVisited.add(u);
                    System.out.printf("%s %s path %s%n", startingV.getVertexName(), u.getVertexName()
                            , treeNodeVisited.indexOf(u));
                    dfsTree(u);
                }
            }
        }
    }
        TreeMap<Vertex, Integer> getAdjList(Vertex v) {
            return adjList.get(v.getValue());
        }

    public Graph() {
        }
    }
