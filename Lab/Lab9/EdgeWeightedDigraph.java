import java.util.LinkedList;

public class EdgeWeightedDigraph {
    static class E {
        int from;
        int to;
        int weight;

        public E(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static class Graph {
        int v;
        LinkedList<E> [] adj;

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i <v ; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEgde(int from, int to, int weight) {
            E e = new E(from, to, weight);
            adj[from].addFirst(e); //for directed graph
        }
       public void viewGraph(){
            for (int i = 0; i <v ; i++) {
                LinkedList<E> list = adj[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println(i + " -- " +list.get(j).to + "     weight : " +  list.get(j).weight);
                }
            }
        }
    }
      public static void main(String[] args) {
            int v = 5;
            Graph graph = new Graph(v);
            graph.addEgde(0, 1, 2);
            graph.addEgde(2, 0, 4);
            graph.addEgde(4, 1, 4);
            graph.addEgde(3, 5, 6);
            graph.addEgde(0, 2, 3);
            graph.addEgde(1, 3, 2);
            graph.viewGraph();
        }
}