package info.codeden.ht.adt.graphdfs;

import java.util.*;
import static info.codeden.ht.adt.graphdfs.GraphConstants.*;

enum Graph implements AbstractGraph<String> {
    DIRECTED(true) {
        /**
         * A static instance of Graph implemented with an enum.
         * The Type enum creates a graph from parameters pass to the (of) factory method of the enum.
         */
        @Override
        Graph instance(Vector<Vertex<String>> vertices, boolean isWeighted) {
            VERTICES.addAll(vertices);
            this.setNumVertices(vertices.size());
            this.setWeighted(isWeighted);
            this.createImplementation();
            return this;
        }
    },
    UNDIRECTED(false) {
        @Override
        Graph instance(Vector<Vertex<String>> vertices, boolean isWeighted) {
            VERTICES.addAll(vertices);
            this.setNumVertices(vertices.size());
            this.setWeighted(isWeighted);
            this.createImplementation();
            return this;
        }
    };



    private int numVertices;                                            // number of vertices in the Graph
    private int numEdges;                                               // number of edges in the Graph
    private final boolean isDirected;                                   // determines if graph is directed or undirected
    private boolean isWeighted;                                         // determines if graph is weighted or unweighted
    private int index;

    Graph(boolean isDirected) {
        // Constructor for Graph ADT
        // precondition of graph constructor requires n to be greater than zero
        numEdges = 0;
        numVertices = 0;
        this.isDirected = isDirected;
    }   // Graph is initialized

    abstract Graph instance(Vector<Vertex<String>> vertices, boolean isWeighted);

    private boolean isWeighted() {
        return isWeighted;
    }

    protected void setWeighted(boolean weighted) {
        isWeighted = weighted;
    }

    @Override
    public void addVertexInfo(int value, String name) {
        addVertex();
        VERTICES.get(index).setVertexData(name);
        VERTICES.get(index).setIndex(value);
        if (index >= numVertices) {
            numVertices++;
        }
        index++;
    }

    @Override
    public void removeVertexInfo(Vertex v) {
        if (VERTICES.contains(v)) {
            VERTICES.get(VERTICES.indexOf(v)).setVertexData(null);
            VERTICES.get(VERTICES.indexOf(v)).setIndex(-1);
        }
    }

    @Override
    public Integer addVertex() {
        VERTICES.add(new Vertex<>());
        if (numVertices > 0)
            return numVertices;
        else
            return numVertices++;
    }

    @Override
    public int getNumVertices() {
        return this.numVertices;
    }

    void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    @Override
    public int getNumEdges() {
        return this.numEdges;
    }

    @Override
    public int getEdgeWeight(Vertex<String> v, Vertex<String> w) {
        if (isWeighted) {
            return Objects.requireNonNull(ADJ_LIST.get(v.getIndex()).get(w)
                    , "Not a weighted edge.");
        } else
            throw new AssertionError();
    }

    private void addEdge(Vertex<String> v, Vertex<String> w, int wgt) {
        if (VERTICES.contains(v) && VERTICES.contains(w)) {
            if (isDirected) {
                ADJ_LIST.get(v.getIndex()).put(w, wgt);
                numEdges++;
            } else {
                ADJ_LIST.get(v.getIndex()).put(w, wgt);
                ADJ_LIST.get(w.getIndex()).put(v, wgt);
                numEdges++;
            }
        }
    }

    @Override
    public void addEdge(Edge edge) {
        Vertex<String> v = edge.getV();
        Vertex<String> w = edge.getW();
        if (VERTICES.contains(v) && VERTICES.contains(w)) {
            int wgt = edge.getWeight();
            if (edge.getV().compareTo(edge.getW()) == 0) throw new RuntimeException("Can't add edge to this graph.");
            addEdge(v, w, wgt);
        }
    }

    @Override
    public void removeEdge(Edge edge) {
        Vertex<String> v = edge.getV();
        Vertex<String> w = edge.getW();
        if (VERTICES.contains(v) && VERTICES.contains(w)) {
            if (isDirected) {
                ADJ_LIST.get(v.getIndex()).remove(w);
                numEdges--;
            } else {
                ADJ_LIST.get(v.getIndex()).remove(w);
                ADJ_LIST.get(w.getIndex()).remove(v);
                numEdges--;
            }
        }
    }

    @Override
    public Edge findEdge(Vertex<String> v, Vertex<String> w) {
        int wgt = ADJ_LIST.get(v.getIndex()).get(w);
        return new Edge(v, w, wgt);
    }

    @Override
    public boolean isEdge(Vertex<String> v, Vertex<String> w) {
        return getAdjList(v).containsKey(w);
    }

    @Override
    public boolean isConnected() {
        int numVerticesMinusOne = numVertices - 1;
        if (!isDirected)
            return (numEdges >= numVerticesMinusOne);
        else {
            dfs(VERTICES.get(0));
            boolean predicate = numVertices == VISITED.size();
            VISITED.clear();
            return predicate;             // A directed graph is connect if the number of
        }                                                     // vertices is equal to the size of the spanning tree
    }


    @Override
    public boolean hasCycle() {
        if (!isDirected && isConnected()) return !(numVertices - 1 == numEdges)
                || numVertices - 1 < numEdges;
        else
            return false;
    }

    @Override
    public void minimumST() {
        if (isWeighted && isConnected() && !isDirected) {

        }
    }

    public void dfs(Vertex<String> startingV) {
        Objects.requireNonNull(startingV, "The vertex being passed to dfs is null, " +
                "first create the vertex before checking if it is in the graph");
        System.out.printf("Vertex: %s%n", startingV.getVertexData());
        VISITED.add(startingV);
        for (Vertex<String> u : this.getAdjList(startingV).keySet()) {
            if (!VISITED.contains(u)) {
                System.out.printf("%s %s path has weight %s%n", startingV.getVertexData(), u.getVertexData()
                        , this.getEdgeWeight(startingV, u));
                dfs(u);
            }
        }
    }

    public void dfsTree(Vertex<String> startingV) {
        Objects.requireNonNull(startingV, "The vertex being passed to dfsTree is null, " +
                "first create the vertex before checking if it is in the graph");
        if (!TREE_NODE_VISITED.contains(startingV) && !isDirected)
            System.out.println("Vertex: " + startingV.getVertexData());
        TREE_NODE_VISITED.add(startingV);
        if (!isDirected && isConnected()) {
            for (Vertex<String> u : this.getAdjList(startingV).keySet()) {
                if (!TREE_NODE_VISITED.contains(u)) {
                    TREE_NODE_VISITED.add(u);
                    System.out.printf("%s %s path %s%n", startingV.getVertexData(), u.getVertexData()
                            , TREE_NODE_VISITED.indexOf(u));
                    dfsTree(u);
                    System.out.println(startingV.getVertexData());
                }
            }
        }
    }

    @Override
    public List<Vertex<String>> topologicalSort(AbstractGraph<String> graph) {
        List<Vertex<String>> topVisited = new ArrayList<>();
        ArrayList<Vertex<String>> aList = new ArrayList<>();
        Stack<Vertex<String>> s = new Stack<>();

        for (Vertex<String> x : VERTICES) {
            boolean predicate = false;
            for (Vertex<String> y : VERTICES) {
                if (graph.isEdge(y,x)) { // is y a predecessor to x?
                    predicate = true;
                    break;
                }
            }
            if (!predicate) {
                s.push(x);
                topVisited.add(x);
            }
        }

        while (!s.isEmpty()) {

            if (topVisited.containsAll(graph.getAdjList(s.peek()).keySet())) {
                Vertex<String> v = s.pop();
                aList.add(v);
            } else {
                for (Vertex<String> l : graph.getAdjList(s.peek()).keySet()) {
                    if (!topVisited.contains(l)) {
                        s.push(l);
                        topVisited.add(l);
                    }
                }
            }
        }
        return aList;
    }

    protected void  createImplementation() {
        int n = this.numVertices;
        for (int i = 0; i < n; i++) {
            ADJ_LIST.add(new LinkedHashMap<>());
        }
    }

    @Override
    public LinkedHashMap<Vertex<String>, Integer> getAdjList(Vertex<String> v) {
        if (VERTICES.contains(v)) {
            return ADJ_LIST.get(v.getIndex());
        } else throw new RuntimeException("vertex does not exist");
    }
}



