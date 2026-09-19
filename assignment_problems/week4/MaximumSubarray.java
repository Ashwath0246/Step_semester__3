package week4;
import java.util.Scanner;

public class MaximumSubarray {

    static int maxSubArray(int[] nums) {

        // Start with the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Start from the second element
        for (int i = 1; i < nums.length; i++) {

            // Decide: start new subarray or continue old one
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);

        sc.close();
    }
}