package info.codeden.ht.adt.graphdfs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Vector;
import static info.codeden.ht.adt.graphdfs.GraphConstants.*;
public class SomeGraph {

    public static void main(String[] args) throws IOException {

        final Scanner in = new Scanner(Path.of(System.getProperty("user.dir") + "\\cities.txt")
                , StandardCharsets.UTF_8);
        var size = 7;
        final Vector<Vertex<String>> vertices = new Vector<>();
        var j = 0;
        while(j < size){
            vertices.add(new Vertex<>(in.nextInt(), in.next()));
            j++;
        }
        final Graph graph  = Graph.DIRECTED.instance(vertices, true);

        graph.addEdge(new Edge(VERTICES.get(0), VERTICES.get(1), 4));
        graph.addEdge(new Edge(VERTICES.get(0), VERTICES.get(3), 21));
        graph.addEdge(new Edge(VERTICES.get(1), VERTICES.get(2), 66));
        graph.addEdge(new Edge(VERTICES.get(1), VERTICES.get(4), 25));
        graph.addEdge(new Edge(VERTICES.get(4), VERTICES.get(2), 89));
        graph.addEdge(new Edge(VERTICES.get(4), VERTICES.get(5), 14));
        graph.addEdge(new Edge(VERTICES.get(3), VERTICES.get(4), 66));
        graph.addEdge(new Edge(VERTICES.get(6), VERTICES.get(3), 22));

        var aList = graph.topologicalSort(graph);
        graph.dfs(vertices.get(1));

        for (int s = 0; s < size; s++) {
            System.out.println(aList.get(s).getVertexData());
        }
    }
}


