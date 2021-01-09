package info.codeden.ht.graphdfs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;


public class SomeGraph {

    public static void main(String[] args) throws IOException {
        final Graph graph = Graph.Type.INSTANCE.of(7, true, false);
        final Graph adtGraph = new Graph();
        int SIZE = graph.getNumVertices();
        final Scanner in = new Scanner(Path.of(System.getProperty("user.dir")+"\\alpha.txt")
                , StandardCharsets.UTF_8);
        var v = new Vertex[SIZE];
        var i = 0;
        while (i<SIZE) {
            graph.addVertexInfo(in.nextInt(), in.next());
            i++;
        }

        graph.addEdge(new Edge(graph.vertices.get(0), graph.vertices.get(1)));
        graph.addEdge(new Edge(graph.vertices.get(0), graph.vertices.get(3)));
        graph.addEdge(new Edge(graph.vertices.get(1), graph.vertices.get(2)));
        graph.addEdge(new Edge(graph.vertices.get(1), graph.vertices.get(4)));
        graph.addEdge(new Edge(graph.vertices.get(4), graph.vertices.get(2)));
        graph.addEdge(new Edge(graph.vertices.get(4), graph.vertices.get(5)));
        graph.addEdge(new Edge(graph.vertices.get(3), graph.vertices.get(4)));
        graph.addEdge(new Edge(graph.vertices.get(6), graph.vertices.get(3)));

Iterator<Vertex<Integer>> iter = graph.topologicalSort(graph).iterator();
        iter.forEachRemaining((m)->System.out.println(m.getVertexName()));
    }
}


