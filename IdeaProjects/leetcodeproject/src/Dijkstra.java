import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static int[] dijkstra(List<List<Node>> adJList, int v,int s){

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b)->
            a.dist - b.dist
        );
        int distance[] = new int[v];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[s] = 0;
        queue.add(new Pair(s,0));
        while(!queue.isEmpty()){

            Pair pair = queue.remove();
            int edge = pair.node;
            int dist = pair.dist;

            for(int i =0;i<adJList.get(edge).size();i++){

                   int node = adJList.get(edge).get(i).node;
                   double weight = adJList.get(edge).get(i).weight;

                   if(distance[node] > dist + (int)weight){

                       distance[node]  = dist + (int)weight;
                       queue.add(new Pair(node,distance[node]));
                   }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int v = 5;
        int s= 0;

        List<List<Node>> graph = new ArrayList<>();

        for(int i =0;i<3;i++){
            graph.add(new ArrayList<Node>());
        }


        Node node = new Node(1,1);
        Node node1 = new Node(2,6);

        graph.get(0).add(node);
        graph.get(0).add(node1);

        Node node3 = new Node(2,3);
        Node node4 = new Node(0,1);

        graph.get(1).add(node3);
        graph.get(1).add(node4);

        Node node5 = new Node(1,3);
        Node node6 = new Node(0,6);

        graph.get(2).add(node5);
        graph.get(2).add(node6);

        int distance[] = dijkstra(graph,3,2);

        for(int i =0;i<distance.length;i++){
            System.out.print(distance[i] + " ");
        }

    }
}
