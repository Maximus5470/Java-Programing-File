package DAAinternal;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    static void dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int count=0;count<n-1;count++){
            int u=-1;
            for (int i = 0; i < n; i++) {
                if(!visited[i] && (u ==-1 || dist[i] < dist[u])) u=i;
            }

            visited[u] = true;

            for (int v=0; v < n; v++) {
                if(!visited[v] && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        dijkstra(graph,0);
    }
}
