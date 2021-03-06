package ImportantQ.Graph.ShortestPath;
import java.util.ArrayList;
// https://www.youtube.com/watch?v=75yC1vbS8S8&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=28
// It helps us find the shortest path from any given source node to all other nodes in the graph
// Dijkstra's Algorithm does not work for -ve edges of a graph.

// DFS is not used to find the shortest distance in graph, but is used in Trees instead coz we have unique paths
// between nodes in Trees, but we can have exponential number of unique paths between 2 nodes in a graph.
public class BellmanFord {
    static class Node{
        int u, v;
        int weight;
        Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            weight = w;
        }
        int getU(){
            return u;
        }
        int getV(){
            return v;
        }
        int getWeight(){
            return weight;
        }
    }
    // Node -> u,v and distance between u&v
    // T = O((N-1) * E)
    int[] bellmenFord(int V, ArrayList<Node> Edges, int source){
        int[] distance = new int[V];
        for(int i = 0; i < V; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[source] = 0;

        // Relaxation
        for(int i = 0; i < V-1; i++) {
            for(Node n : Edges){
                // d(u)+d(u,v) < d(v)
                if(distance[n.getU()] != Integer.MAX_VALUE && distance[n.getU()] + n.getWeight() < distance[n.getV()]){
                    distance[n.getV()] = distance[n.getU()] + n.getWeight();
                }
            }
        }
        // -VE cycle detection
        for(Node n : Edges){
            if(distance[n.getU()] != Integer.MAX_VALUE && distance[n.getU()] + n.getWeight() < distance[n.getV()]){
                System.out.println("Negative cycle in Graph");
                break;
            }
        }
        return distance;
    }
}
