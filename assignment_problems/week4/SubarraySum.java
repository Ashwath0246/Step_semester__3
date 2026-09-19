package week4;
import java.util.HashMap;
import java.util.Scanner;

public class SubarraySum {

    static int subarraySum(int[] nums, int k) {

        int prefixSum = 0;
        int count = 0;

        // Store prefix sum frequencies
        HashMap<Integer, Integer> map = new HashMap<>();

        // Important: prefix sum 0 occurs once initially
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            // Add current element to prefix sum
            prefixSum = prefixSum + nums[i];

            // Check whether prefixSum - k appeared before
            int requiredSum = prefixSum - k;

            if (map.containsKey(requiredSum)) {
                count = count + map.get(requiredSum);
            }

            // Store/update current prefix sum
            if (map.containsKey(prefixSum)) {
                map.put(prefixSum, map.get(prefixSum) + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }

        return count;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays: " + result);

        sc.close();
    }
}