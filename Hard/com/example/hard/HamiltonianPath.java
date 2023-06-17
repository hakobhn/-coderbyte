package com.example.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Using the Java language, have the function HamiltonianPath(strArr) take strArr which will be an array of length three.
 *  The first part of the array will be a list of vertices in a graph in the form (A,B,C,...),
 *  the second part of the array will be the edges connecting the vertices in the form
 * (A-B,C-D,...) where each edge is bidirectional.
 * The last part of the array will be a set of vertices in the form (X,Y,Z,...) representing the path,
 * Your program will have to determine whether or not the set of vertices given forms a Hamiltonian path on the graph
 * which means that every vertex in the graph is visited only once in the order given.
 * For example:
 *  if strArr is ["(A,B,C,D)","(A-B,A-D,B-D,A-C)","(C,A,D,B)"]
 *  then the vertices (C,A,D,B) in this order do in fact form a Hamiltonian path on the graph
 *  so your program should return the string yes.
 *  If for example the last part of the array was (D,A,B,C) then this doesn't form a Hamiltonian path because
 *  once you get to B you can't get to C in the graph without passing through the visited vertices again.
 *  Here your program should return the vertex where the path had to terminate,
 *  in this case your program should return B.
 *
 * For this challenge you will determine whether a given set of vertices form a Hamiltonian path on the graph.
 *
 */
class HamiltonianPath {

    public static String HamiltonianPathOld(String[] strArr) {
        // code goes here
        String str = strArr[2].toString();
        String strc = strArr[1].toString();
        String hp = "";

        String strnew = str.replaceAll(",", "").replace("(", "").replace(")", "");
        for (int i = 0; i < strnew.length() - 1; i++) {

            if (strc.contains(strnew.charAt(i) + "-" + strnew.charAt(i + 1)) || strc.contains(strnew.charAt(i + 1) + "-" + strnew.charAt(i))) {
                continue;
            } else {
                hp = strnew.charAt(i) + "";
                return hp;
            }
        }

        return "yes";
    }

    public static boolean HamiltonianPath(String[] values) {
        Map<Character, Node> graph = createGraph(values[0]);
        makeConnections(graph, values[1]);

        return checkPath(graph, values[2]);
    }

    public static Map<Character, Node> createGraph(String namesStr) {
        Map<Character, Node> graph = new HashMap<>();
        List<Character> names = Arrays.stream(namesStr
                .split(","))
                .map(String::trim)
                .map(s->s.charAt(0))
                .collect(Collectors.toList());
        for (Character chr : names) {
            graph.put(chr, new Node(chr));
        }
        return graph;
    }

    public static void makeConnections(Map<Character, Node> graph, String connectionsStr) {
        List<String> connections = Arrays.stream(connectionsStr
                        .split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        connections.stream().forEach(
                str -> {
                    graph.get(str.charAt(0)).getConnected().add(graph.get(str.charAt(2)));
                    graph.get(str.charAt(2)).getConnected().add(graph.get(str.charAt(0)));
                }
        );
    }

    private static boolean checkPath(Map<Character, Node> graph, String movesStr) {
        List<Character> itemOrder = Arrays.stream(movesStr
                        .split(","))
                .map(String::trim)
                .map(s->s.charAt(0))
                .collect(Collectors.toList());

        for (int i = 0; i < itemOrder.size() - 1; i++) {
            if (graph.get(itemOrder.get(i)).getConnected().contains(graph.get(itemOrder.get(i+1)))) {
                if (graph.get(itemOrder.get(i+1)).isVisit()) {
                    return false;
                }
                System.out.println(graph.get(itemOrder.get(i))+"->"+graph.get(itemOrder.get(i+1)));
                graph.get(itemOrder.get(i+1)).setVisit(true);
            } else {
                return false;
            }
        }
        return true;
    }

    static class Node {
        private final char name;
        private boolean visit;
        private Set<Node> connected = new HashSet<>();

        public Node(char name) {
            this.name = name;
            this.visit = false;
        }

        public char getName() {
            return name;
        }

        public boolean isVisit() {
            return visit;
        }

        public void setVisit(boolean visit) {
            this.visit = visit;
        }

        public Set<Node> getConnected() {
            return connected;
        }

        @Override
        public String toString() {
            return "{" + name + '}';
        }

        @Override
        public int hashCode() {
            return Character.valueOf(name).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                return Character.valueOf(name).equals(((Node) obj).getName());
            }
            return false;
        }
    }

    /**
     * (A,B,C,D),(A-B,A-D,B-D,A-C),(C,A,D,B) - yes
     * (A,B,C),(B-A,C-B),(C,B,A) - yes
     * (X,Y,Z,Q),(X-Y,Y-Q,Y-Z),(Z,Y,Q,X) - no
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String valuesStr = s.nextLine();
        valuesStr = valuesStr.substring(1, valuesStr.length()-1);
        System.out.println(HamiltonianPath(valuesStr.split("\\),\\(")));
    }

}
