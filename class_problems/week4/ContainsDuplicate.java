package week4;
import java.util.Scanner;

public class ContainsDuplicate {

    static boolean containsDuplicate(int[] nums) {

        // First loop
        for (int i = 0; i < nums.length; i++) {

            // Second loop
            for (int j = i + 1; j < nums.length; j++) {

                // Check if two different positions have same value
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
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

        boolean result = containsDuplicate(nums);

        System.out.println(result);

        sc.close();
    }
}