package DAAinternal;

public class GraphColoring {

    public static boolean graphColoring(int[][] graph, int numColors) {
        int n = graph.length;
        int[] colors = new int[n];

        if (backtrack(graph, numColors, colors, 0)) {
            printSolution(colors);
            return true;
        }
        return false;
    }

    private static boolean backtrack(int[][] graph, int numColors, int[] colors, int vertex) {
        int n = graph.length;

        if (vertex == n) {
            return true; // All vertices colored successfully
        }

        for (int color = 1; color <= numColors; color++) {
            if (isSafe(graph, vertex, color, colors)) {
                colors[vertex] = color;

                if (backtrack(graph, numColors, colors, vertex + 1)) {
                    return true;
                }

                colors[vertex] = 0; // Backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] graph, int vertex, int color, int[] colors) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] == 1 && colors[i] == color) {
                return false; // Adjacent vertex has same color
            }
        }
        return true;
    }

    private static void printSolution(int[] colors) {
        System.out.println("Graph coloring solution:");
        for (int i = 0; i < colors.length; i++) {
            System.out.println("Vertex " + i + " -> Color " + colors[i]);
        }
    }

    // Find minimum number of colors needed (chromatic number)
    public static int findChromaticNumber(int[][] graph) {
        int n = graph.length;

        for (int colors = 1; colors <= n; colors++) {
            if (graphColoring(graph, colors)) {
                return colors;
            }
        }
        return n; // Worst case: complete graph needs n colors
    }

    public static void main(String[] args) {
        // Example graph (adjacency matrix)
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };

        System.out.println("Graph adjacency matrix:");
        for (int[] row : graph) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        int numColors = 3;
        System.out.println("\nTrying to color graph with " + numColors + " colors:");

        if (!graphColoring(graph, numColors)) {
            System.out.println("Cannot color the graph with " + numColors + " colors");
        }

        // Find minimum colors needed
        System.out.println("\nFinding chromatic number...");
        int chromaticNumber = findChromaticNumber(graph);
        System.out.println("Minimum colors needed: " + chromaticNumber);
    }
}