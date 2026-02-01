package DAAinternal;

import java.util.*;

public class TravellingSalesperson {
    private static final int INF = Integer.MAX_VALUE;
    private static int minCost = INF;
    private static List<Integer> bestPath;

    static class Node {
        int level;
        int cost;
        int bound;
        List<Integer> path;
        boolean[] visited;

        Node(int level, int cost, List<Integer> path, boolean[] visited) {
            this.level = level;
            this.cost = cost;
            this.path = new ArrayList<>(path);
            this.visited = visited.clone();
        }
    }

    public static int solveTSP(int[][] graph) {
        int n = graph.length;
        minCost = INF;
        bestPath = new ArrayList<>();

        // Priority queue to store nodes (min-heap based on bound)
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.bound, b.bound));

        // Initialize root node
        boolean[] visited = new boolean[n];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        visited[0] = true;

        Node root = new Node(0, 0, path, visited);
        root.bound = calculateBound(graph, root);
        pq.offer(root);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.bound >= minCost) continue;

            if (current.level == n - 1) {
                int returnCost = graph[current.path.get(current.level)][0];
                if (returnCost != INF) {
                    int totalCost = current.cost + returnCost;
                    if (totalCost < minCost) {
                        minCost = totalCost;
                        bestPath = new ArrayList<>(current.path);
                        bestPath.add(0); // Return to start
                    }
                }
                continue;
            }

            int currentCity = current.path.get(current.level);
            for (int nextCity = 0; nextCity < n; nextCity++) {
                if (!current.visited[nextCity] && graph[currentCity][nextCity] != INF) {

                    // Create child node
                    List<Integer> newPath = new ArrayList<>(current.path);
                    newPath.add(nextCity);
                    boolean[] newVisited = current.visited.clone();
                    newVisited[nextCity] = true;

                    Node child = new Node(current.level + 1,
                            current.cost + graph[currentCity][nextCity],
                            newPath, newVisited);

                    child.bound = calculateBound(graph, child);

                    if (child.bound < minCost) {
                        pq.offer(child);
                    }
                }
            }
        }

        return minCost;
    }

    private static int calculateBound(int[][] graph, Node node) {
        int n = graph.length;
        int bound = node.cost;

        for (int i = 0; i < n; i++) {
            if (!node.visited[i] || i == node.path.get(node.level)) {
                int min1 = INF, min2 = INF;

                for (int j = 0; j < n; j++) {
                    if (i != j && graph[i][j] != INF) {
                        if (graph[i][j] < min1) {
                            min2 = min1;
                            min1 = graph[i][j];
                        } else if (graph[i][j] < min2) {
                            min2 = graph[i][j];
                        }
                    }
                }

                if (min2 != INF) {
                    bound += (min1 + min2) / 2;
                } else if (min1 != INF) {
                    bound += min1;
                }
            }
        }

        return bound;
    }

    public static void printSolution() {
        if (bestPath.isEmpty()) {
            System.out.println("No solution found");
            return;
        }

        System.out.println("Best path: " + bestPath);
        System.out.println("Minimum cost: " + minCost);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        System.out.println("Solving TSP using Branch and Bound:");
        System.out.println("Distance matrix:");
        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }

        long startTime = System.currentTimeMillis();
        int result = solveTSP(graph);
        long endTime = System.currentTimeMillis();

        System.out.println("\nResult:");
        printSolution();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}