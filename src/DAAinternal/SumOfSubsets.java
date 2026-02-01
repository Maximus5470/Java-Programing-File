package DAAinternal;

import java.util.*;

public class SumOfSubsets {
    public static void findSubsets(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, target, 0, 0, new ArrayList<>());
    }

    private static void backtrack(int[] nums, int target, int index, int currentSum, List<Integer> subset) {
        if (currentSum == target) {
            System.out.println(subset);
            return;
        }
        if (index == nums.length || currentSum > target) return;
        subset.add(nums[index]);
        backtrack(nums, target, index + 1, currentSum + nums[index], subset);
        subset.removeLast();
        backtrack(nums, target, index + 1, currentSum, subset);
    }

    public static void main(String[] args) {
        int[] nums = {10, 7, 5, 18, 12, 20, 15};
        int target = 35;
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target sum: " + target);
        System.out.println("\nAll subsets with sum " + target + ":");
        findSubsets(nums, target);
    }
}

