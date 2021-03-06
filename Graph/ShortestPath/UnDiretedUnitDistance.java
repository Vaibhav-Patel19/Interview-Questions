package ImportantQ.Graph.ShortestPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// Shortest Distance from a Given Source Node to target Node in an UnDirected graph with unit weights
// https://www.youtube.com/watch?v=hwCWi7-bRfI&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=16

// DFS is not used to find the shortest distance in graph, but is used in Trees instead coz we have unique paths
// between nodes in Trees, but we can have exponential number of unique paths between 2 nodes in a graph.

public class UnDiretedUnitDistance {
    // shortest distance form src node to every other node in graph
    static int[] shortestPath(ArrayList<ArrayList<Integer>> graph, int V, int src) {
        int[] distance  = new int[V];
        Queue<Integer> q = new LinkedList<>();
        // Initialising distance of every vertex from source node to that vertex to Infinity
        for(int i = 0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0;
        q.add(src);
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(Integer node : graph.get(cur)) {
                if(1 + distance[cur] < distance[node]){
                    distance[node] = distance[cur] + 1;
                    q.add(node);
                }
            }
        }
        // If you want to calculate distance from source to a particular target,
        // you can return distance[target]
        return distance;
    }
}
