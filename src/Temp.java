import java.util.HashMap;
import java.util.Map;

class FloydWarshall {
    public static void allPairsShortestPath(int[][] graph) {
        int n = graph.length;

        // Using the graph matrix directly as our distance matrix
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE &&
                            graph[k][j] != Integer.MAX_VALUE &&
                            graph[i][k] + graph[k][j] < graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int INF = Integer.MAX_VALUE;
        int[][] graph = {
                {0, 3, 6, INF, INF, INF, INF},
                {3, 0, 2, 1, INF, INF, INF},
                {6, 2, 0, 1, 4, 2, INF},
                {INF, 1, 1, 0, 2, INF, 4},
                {INF, INF, 4, 2, 0, 2, 1},
                {INF, INF, 2, INF, 2, 0, 1},
                {INF, INF, INF, 4, 1, 1, 0}
        };

        allPairsShortestPath(graph);

        // Print the result
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class OptimalBST {
    // A utility function to get sum of array elements freq[i] to freq[j]
    static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freq[k];
        }
        return s;
    }

    // Returns cost of optimal binary search tree
    static int optimalBST(int keys[], int freq[], int n) {
        // Create tables for DP
        int[][] cost = new int[n+1][n+1];

        // For a single key, cost is equal to frequency of the key
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];

        // Consider chains of length 2, 3, ... n
        for (int L = 2; L <= n; L++) {
            // Try different root positions for current chain length
            for (int i = 0; i <= n-L; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
                int sum = sum(freq, i, j);

                // Try making each key as root
                for (int r = i; r <= j; r++) {
                    // Calculate cost when keys[r] becomes root
                    int c = ((r > i) ? cost[i][r-1] : 0) +
                            ((r < j) ? cost[r+1][j] : 0) +
                            sum;
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n-1];
    }

    // Driver code
    public static void main(String args[]) {
        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        int n = keys.length;
        System.out.println("Cost of Optimal BST is " +
                optimalBST(keys, freq, n));
    }
}

class Knapsack {

    // Memoization approach (Top-down)
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        // Create a memoization table
        int[][] memo = new int[n+1][W+1];

        // Initialize with -1 to indicate uncalculated states
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                memo[i][j] = -1;
            }
        }

        return knapsackMemo(W, wt, val, n, memo);
    }

    private static int knapsackMemo(int W, int[] wt, int[] val, int n, int[][] memo) {
        // Base case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If value already calculated, return it
        if (memo[n][W] != -1) {
            return memo[n][W];
        }

        // If weight of nth item is greater than capacity W,
        // this item cannot be included
        if (wt[n-1] > W) {
            memo[n][W] = knapsackMemo(W, wt, val, n-1, memo);
            return memo[n][W];
        }
        // Return the maximum of including or excluding the item
        else {
            memo[n][W] = Math.max(
                    val[n-1] + knapsackMemo(W - wt[n-1], wt, val, n-1, memo),  // Including the item
                    knapsackMemo(W, wt, val, n-1, memo)                        // Excluding the item
            );
            return memo[n][W];
        }
    }

    // Bottom-up dynamic programming approach
    public static int knapsackDP(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n+1][W+1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
                else if (wt[i-1] <= w) {
                    dp[i][w] = Math.max(
                            val[i-1] + dp[i-1][w-wt[i-1]],  // Including the item
                            dp[i-1][w]                      // Excluding the item
                    );
                }
                else {
                    dp[i][w] = dp[i-1][w];  // Can't include this item
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {10, 20, 30};
        int[] wt = {1, 1, 1};
        int W = 2;
        int n = val.length;

        System.out.println("Maximum value using memoization: " + knapsack(W, wt, val, n));
        System.out.println("Maximum value using bottom-up DP: " + knapsackDP(W, wt, val, n));
    }
}

class ReliabilityDesign {

    /**
     * Calculate system reliability with given device configuration
     * @param deviceReliabilities Array of individual device reliabilities
     * @param parallelCounts Array with number of parallel devices at each stage
     * @return System reliability
     */
    public static double calculateSystemReliability(double[] deviceReliabilities, int[] parallelCounts) {
        double systemReliability = 1.0;

        for (int i = 0; i < deviceReliabilities.length; i++) {
            double stageReliability = 1.0 - Math.pow(1.0 - deviceReliabilities[i], parallelCounts[i]);
            systemReliability *= stageReliability;
        }

        return systemReliability;
    }

    /**
     * Calculate system cost with given device configuration
     * @param deviceCosts Array of individual device costs
     * @param parallelCounts Array with number of parallel devices at each stage
     * @return Total system cost
     */
    public static double calculateSystemCost(double[] deviceCosts, int[] parallelCounts) {
        double totalCost = 0.0;

        for (int i = 0; i < deviceCosts.length; i++) {
            totalCost += deviceCosts[i] * parallelCounts[i];
        }

        return totalCost;
    }

    /**
     * Find optimal configuration using dynamic programming approach
     * @param deviceReliabilities Array of individual device reliabilities
     * @param deviceCosts Array of individual device costs
     * @param budget Maximum allowed budget
     * @param maxParallel Maximum allowed parallel components per stage
     * @return Optimal configuration of parallel components
     */
    public static int[] findOptimalConfiguration(double[] deviceReliabilities, double[] deviceCosts,
                                                 double budget, int maxParallel) {
        int n = deviceReliabilities.length;

        // Create a table to store reliability for different budget allocations
        // dp[i][j] = maximum reliability for first i stages with budget j
        double[][] dp = new double[n + 1][(int)budget + 1];

        // Configuration that achieved this reliability
        int[][][] config = new int[n + 1][(int)budget + 1][n];

        // Base case - zero reliability with zero budget or zero stages
        for (int j = 0; j <= budget; j++) {
            dp[0][j] = 1.0; // Neutral element for reliability multiplication
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= budget; j++) {
                // Default - no components at this stage (impossible in reality)
                dp[i][j] = 0.0;

                // Try different numbers of parallel components
                for (int k = 1; k <= maxParallel; k++) {
                    if (j >= deviceCosts[i-1] * k) {
                        double stageReliability = 1.0 - Math.pow(1.0 - deviceReliabilities[i-1], k);
                        double newReliability = dp[i-1][(int)(j - deviceCosts[i-1] * k)] * stageReliability;

                        if (newReliability > dp[i][j]) {
                            dp[i][j] = newReliability;

                            // Copy configuration from previous stage
                            for (int m = 0; m < n; m++) {
                                config[i][j][m] = config[i-1][(int)(j - deviceCosts[i-1] * k)][m];
                            }
                            // Update current stage's configuration
                            config[i][j][i-1] = k;
                        }
                    }
                }
            }
        }

        // Extract the optimal configuration
        int[] optimalConfig = new int[n];
        for (int i = 0; i < n; i++) {
            optimalConfig[i] = config[n][(int)budget][i];
        }

        return optimalConfig;
    }

    public static void main(String[] args) {
        // Example: 4 devices with reliability 0.9 each
        double[] deviceReliabilities = {0.9, 0.9, 0.9, 0.9};
        double[] deviceCosts = {10, 10, 10, 10};
        double budget = 100;
        int maxParallelPerStage = 5;

        int[] optimalConfig = findOptimalConfiguration(
                deviceReliabilities, deviceCosts, budget, maxParallelPerStage);

        System.out.println("Optimal configuration:");
        for (int i = 0; i < optimalConfig.length; i++) {
            System.out.println("Stage " + (i+1) + ": " + optimalConfig[i] + " parallel components");
        }

        double reliability = calculateSystemReliability(deviceReliabilities, optimalConfig);
        double cost = calculateSystemCost(deviceCosts, optimalConfig);

        System.out.println("System reliability: " + reliability);
        System.out.println("System cost: " + cost);

        // Compare with a serial system (1 component per stage)
        int[] serialConfig = {1, 1, 1, 1};
        double serialReliability = calculateSystemReliability(deviceReliabilities, serialConfig);
        System.out.println("Serial system reliability: " + serialReliability);
    }
}


// TODO WEEK 8

class SherlockAndCost {

    public static int cost(int[] B) {
        int n = B.length;

        if (n <= 1) return 0;

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + Math.abs(1 - B[i-1]));
            dp[i][1] = Math.max(dp[i-1][0] + Math.abs(B[i] - 1),
                    dp[i-1][1] + Math.abs(B[i] - B[i-1]));
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public static void main(String[] args) {
        int[] B1 = {1, 2, 3};
        System.out.println("Test case 1: " + cost(B1));

        int[] B2 = {10, 1, 10, 1, 10};
        System.out.println("Sample test case: " + cost(B2));
    }
}

class StockMaximize {

    public static long stockmax(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        long profit = 0;
        int maxPrice = prices[n-1];

        for (int i = n-2; i >= 0; i--) {
            if (prices[i] < maxPrice) {
                profit += maxPrice - prices[i];
            } else {
                maxPrice = prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices1 = {5, 3, 2};
        System.out.println(stockmax(prices1)); // Expected: 0

        int[] prices2 = {1, 2, 100};
        System.out.println(stockmax(prices2)); // Expected: 197

        int[] prices3 = {1, 3, 1, 2};
        System.out.println(stockmax(prices3)); // Expected: 3
    }
}

class MatrixChainMultiplication {

    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length - 1; // Number of matrices

        // m[i][j] = Minimum number of scalar multiplications needed
        // to compute the matrix A[i]A[i+1]...A[j] = A[i..j]
        int[][] m = new int[n][n];

        // s[i][j] = Index of the matrix after which the product is split in optimal solution
        int[][] s = new int[n][n];

        // Chain length starts from 2 to n
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                m[i][j] = Integer.MAX_VALUE;

                // Try each possible split position k
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k+1][j] + dimensions[i] * dimensions[k+1] * dimensions[j+1];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }

        // Print optimal parenthesization
        System.out.println("Optimal Parenthesization: ");
        printOptimalParenthesis(s, 0, n-1);
        System.out.println();

        return m[0][n-1];
    }

    private static void printOptimalParenthesis(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i+1));
        } else {
            System.out.print("(");
            printOptimalParenthesis(s, i, s[i][j]);
            printOptimalParenthesis(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        // Example from the problem
        int[] dimensions1 = {5, 4, 6, 2}; // A1: 5x4, A2: 4x6, A3: 6x2

        System.out.println("Minimum multiplications required: " + matrixChainOrder(dimensions1));

        // Another example
        int[] dimensions2 = {30, 35, 15, 5, 10, 20, 25};
        System.out.println("\nMinimum multiplications required: " + matrixChainOrder(dimensions2));
    }
}

class BridgeAndTorch {
    // DP memo map to store states we've already computed
    private static Map<Integer, Integer> memo;
    private static int[] crossingTimes;

    public static int minCrossingTime(int[] times) {
        crossingTimes = times;
        int n = times.length;
        memo = new HashMap<>();
        int initialMask = (1 << n) - 1;

        // Start with torch on left side (true)
        return solve(initialMask, true);
    }

    private static int solve(int leftMask, boolean torchOnLeft) {
        int n = crossingTimes.length;

        // If everyone is on right side, we're done
        if (leftMask == 0) {
            return 0;
        }

        // Create a unique key for memoization
        int key = leftMask;
        if (!torchOnLeft) {
            key |= (1 << n);
        }

        // Check if we've already solved this state
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result;

        if (torchOnLeft) {
            // Move two people from left to right
            result = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if ((leftMask & (1 << i)) != 0) {
                    for (int j = i + 1; j < n; j++) {
                        if ((leftMask & (1 << j)) != 0) {
                            int newMask = leftMask & ~(1 << i) & ~(1 << j);
                            int crossTime = Math.max(crossingTimes[i], crossingTimes[j]);
                            int remainingTime = solve(newMask, false);

                            result = Math.min(result, crossTime + remainingTime);
                        }
                    }
                }
            }
        } else {
            result = Integer.MAX_VALUE;
            int rightMask = ((1 << n) - 1) ^ leftMask; // Compute the right mask

            for (int i = 0; i < n; i++) {
                if ((rightMask & (1 << i)) != 0) {
                    int newMask = leftMask | (1 << i);
                    int crossTime = crossingTimes[i];
                    int remainingTime = solve(newMask, true);

                    result = Math.min(result, crossTime + remainingTime);
                }
            }
        }

        // Save result to avoid recomputation
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[] times1 = {10, 20, 30};
        System.out.println("Minimum crossing time: " + minCrossingTime(times1)); // Expected: 60
    }
}