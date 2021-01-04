package info.codeden.ht.graphdfs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;


public class SomeGraph {

    public static void main(String[] args) throws IOException {
        final Graph graph = Graph.Type.INSTANCE.of(9, true, true);

        int SIZE = graph.getNumVertices();
        final Scanner in = new Scanner(Path.of(System.getProperty("user.dir")+"\\alpha.txt")
                , StandardCharsets.UTF_8);
        var v = new Vertex[SIZE];
        var i = 0;
        while (i<SIZE) {
            v[i] = new Vertex();
            v[i].setValue(in.nextInt());
            v[i].setVertexName(in.next());
//            graph.addEdge(new Edge(v[i], v[i%2]);
            i++;
        }
        graph.addEdge(new Edge(v[0], v[1], 6));
        graph.addEdge(new Edge(v[1], v[2], 7));
        graph.addEdge(new Edge(v[2], v[3], 4));
        graph.addEdge(new Edge(v[3], v[7], 1));
        graph.addEdge(new Edge(v[3], v[6], 5));
        graph.addEdge(new Edge(v[6], v[5], 2));
        graph.addEdge(new Edge(v[6], v[4], 8));
        graph.addEdge(new Edge(v[4], v[2], 3));
        graph.addEdge(new Edge(v[4], v[1], 9));
        graph.addEdge(new Edge(v[5], v[0], 4));
        graph.addEdge(new Edge(v[0], v[8], 2));



        graph.dfs(v[0]);
        graph.dfsTree(v[0]);
        System.out.println(graph.hasCycle());
        System.out.println(graph.isConnected());
    }
}


