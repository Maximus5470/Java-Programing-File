package DAAinternal;

public class Hamiltonian {

    // Hamiltonian Path
    public static boolean hamiltonianPath(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        for (int start = 0; start < n; start++) {
            if (pathDFS(graph, start, visited, 1)) {
                System.out.println("Hamiltonian Path found starting from " + start);
                return true;
            }
        }
        return false;
    }

    private static boolean pathDFS(int[][] graph, int curr, boolean[] visited, int count) {
        visited[curr] = true;

        if (count == graph.length) return true;

        for (int next = 0; next < graph.length; next++) {
            if (graph[curr][next] == 1 && !visited[next]) {
                if (pathDFS(graph, next, visited, count + 1)) return true;
            }
        }

        visited[curr] = false; // Backtrack
        return false;
    }

    // Hamiltonian Cycle
    public static boolean hamiltonianCycle(int[][] graph) {
        int n = graph.length;
        int[] path = new int[n];
        boolean[] used = new boolean[n];

        return cycleDFS(graph, 0, path, used, 0);
    }

    private static boolean cycleDFS(int[][] graph, int curr, int[] path, boolean[] used, int pos) {
        path[pos] = curr;
        used[curr] = true;

        if (pos == graph.length - 1) {
            return graph[curr][path[0]] == 1; // Check cycle completion
        }

        for (int next = 0; next < graph.length; next++) {
            if (graph[curr][next] == 1 && !used[next]) {
                if (cycleDFS(graph, next, path, used, pos + 1)) return true;
            }
        }

        used[curr] = false; // Backtrack
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };

        System.out.println("Hamiltonian Path: " + hamiltonianPath(graph));
        System.out.println("Hamiltonian Cycle: " + hamiltonianCycle(graph));
    }
}