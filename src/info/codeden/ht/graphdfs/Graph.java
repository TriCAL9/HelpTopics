package info.codeden.ht.graphdfs;

import java.util.*;

public class Graph implements AbstractGraph<Integer> {
    private static final ArrayList<Vertex<Integer>> visited = new ArrayList<>();
    private static final ArrayList<Vertex<Integer>> treeNodeVisited = new ArrayList<>();
    final Vector<Vertex<Integer>> vertices = new Vector<>();
    private final Vector<LinkedHashMap<Vertex<Integer>, Integer>> adjList = new Vector<>();     // implementation of an adjacent list
    private int numVertices;                                            // number of vertices in the Graph
    private int numEdges;                                               // number of edges in the Graph
    private boolean isDirected;                                         // determines if graph is directed or undirected
    private boolean isWeighted;                                         // determines if graph is weighted or unweighted
    private int index;
    private ArrayList<Vertex<Integer>> noIncomingEdge = new ArrayList<>();

    public Graph(int n, boolean isDirected, boolean isWeighted) {
        // Constructor for Graph ADT
        // precondition of graph constructor requires n to be greater than zero

        if (n > 0) {
            numEdges = 0;
            numVertices = n;

            this.isDirected = isDirected;
            this.isWeighted = isWeighted;
            for (int i = 0; i < n; i++) {
                adjList.add(new LinkedHashMap<>());
            }
        }
    }    // Graph is initialized

    public Graph() {
        isDirected = false;
        isWeighted = false;
        numVertices = 0;
        numEdges = 0;
        adjList.add(new LinkedHashMap<>());
    }

    @Override
    public void addVertexInfo(Integer value, String name) {
        addVertex();
        vertices.get(index).setVertexName(name);
        vertices.get(index).setValue(value);
        if (index >= numVertices) {
            numVertices++;
        }
        index++;
    }


    @Override
    public void removeVertex(Vertex<Integer> v) {
        if (vertices.contains(v)) {
            int index = vertices.indexOf(v);
            vertices.remove(index);
            numVertices--;
        }
    }

    @Override
    public Integer addVertex() {
        vertices.add(new Vertex<>());
        return numVertices;
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
    public int getEdgeWeight(Vertex<Integer> v, Vertex<Integer> w) {
        return Objects.requireNonNull(adjList.get(v.getValue()).get(w)
                , "Not a weighted edge.");
    }

    private void addEdge(Vertex<Integer> v, Vertex<Integer> w, int wgt) {
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
        Vertex<Integer> v = edge.getV();
        Vertex<Integer> w = edge.getW();
        int wgt = edge.getWeight();
        if (edge.getV().compareTo(edge.getW()) == 0) throw new RuntimeException("Can't add edge to this graph.");
        addEdge(v, w, wgt);
    }

    @Override
    public void removeEdge(Edge edge) {
        Vertex<Integer> v = edge.getV();
        Vertex<Integer> w = edge.getW();
        if (isDirected) {
            adjList.get(v.getValue()).remove(w);
            numEdges--;
        } else {
            adjList.get(v.getValue()).remove(w);
            adjList.get(w.getValue()).remove(v);
            numEdges--;
        }
    }

    @Override
    public Edge findEdge(Vertex<Integer> v, Vertex<Integer> w) {
        int wgt = adjList.get(v.getValue()).get(w);
        return new Edge(v, w, wgt);
    }

    @Override
    public boolean isEdge(Vertex<Integer> v, Vertex<Integer> w) {
        return getAdjList(v).containsKey(w);
    }

    @Override
    public boolean isConnected() {
        int vtemp = numVertices - 1;
        if (!isDirected)
            return (numEdges >= vtemp);
        else return numVertices == visited.size();             // A directed graph is connect if the number of
    }                                                          // vertices is equal to the size of the spanning tree


    @Override
    public boolean hasCycle() {
        if (!isDirected && isConnected()) {
            return !(numVertices - 1 == numEdges)
                    || numVertices - 1 < numEdges;


        } else if (isDirected) {

        }
        return false;
    }

    public void dfs(Vertex<Integer> startingV) {
        System.out.printf("Vertex: %s%n", startingV.getVertexName());
        visited.add(startingV);
        for (Vertex<Integer> u : this.getAdjList(startingV).keySet()) {
            if (!visited.contains(u)) {
                System.out.printf("%s %s path has weight %s%n", startingV.getVertexName(), u.getVertexName()
                        , this.getEdgeWeight(startingV, u));
                dfs(u);
            }
            if (!this.noIncomingEdge.contains(u)) {
                this.noIncomingEdge.add(u);
                System.out.println(u.getVertexName() + " backtracked");
            }
        }
    }

    public void dfsTree(Vertex<Integer> startingV) {
        if (!treeNodeVisited.contains(startingV) && !isDirected)
            System.out.println("Vertex: " + startingV.getVertexName());
        treeNodeVisited.add(startingV);
        if (!isDirected && isConnected()) {
            for (Vertex<Integer> u : this.getAdjList(startingV).keySet()) {
                if (!treeNodeVisited.contains(u)) {
                    treeNodeVisited.add(u);
                    System.out.printf("%s %s path %s%n", startingV.getVertexName(), u.getVertexName()
                            , treeNodeVisited.indexOf(u));
                    dfsTree(u);
                    System.out.println(startingV.getVertexName());
                }
            }
        }
    }


    @Override
    public List<Vertex<Integer>> topologicalSort(Graph graph) {
        List<Vertex<Integer>> visited = new ArrayList<>();
        List<Vertex<Integer>> aList = new ArrayList<>();
        Stack<Vertex<Integer>> s = new Stack<>();

        for (Vertex<Integer> x : graph.vertices) {
            boolean pred = false;
            for (Vertex<Integer> y : graph.vertices) {
                if (graph.isEdge(y, x)) { // is y a predecessor to x?
                    pred = true;
                    break;
                }
            }
            if(!pred) s.push(x);
        }

        while (!s.isEmpty()) {

                if (visited.containsAll(graph.getAdjList(s.peek()).keySet())) {
                    Vertex<Integer> v = s.pop();
                    aList.add(v);
                } else {
                    for (Vertex<Integer> l : graph.getAdjList(s.peek()).keySet()) {
                        if (!visited.contains(l)) {
                            s.push(l);
                            visited.add(l);
                        }
                    }
                }
        }
        return aList;
    }

    LinkedHashMap<Vertex<Integer>, Integer> getAdjList(Vertex<Integer> v) {

        if (this.vertices.contains(v)) {
            return adjList.get(v.getValue());
        } else throw new RuntimeException("vertex does not exist");
    }

    /**
     * A static instance of Graph implemented with an enum.
     * The Type enum creates a graph from parameters pass to the (of) factory method of the enum.
     */
    enum Type {
        INSTANCE {
            info.codeden.ht.graphdfs.Graph of(int numVertices, boolean isDirected, boolean isWeighted) {
                return new Graph(numVertices, isDirected, isWeighted);
            }
        };

        abstract Graph of(int numVertices, boolean isDirected, boolean isWeighted);

    }
}

