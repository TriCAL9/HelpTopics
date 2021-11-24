package info.codeden.ht.adt.graphdfs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;

public class GraphConstants {
    public static final ArrayList<Vertex<String>> VISITED = new ArrayList<>();
    public static final ArrayList<Vertex<String>> TREE_NODE_VISITED = new ArrayList<>();
    public static final Vector<Vertex<String>> VERTICES = new Vector<>();
    public static final Vector<LinkedHashMap<Vertex<String>, Integer>> ADJ_LIST = new Vector<>(); // implementation of an adjacent list
}
