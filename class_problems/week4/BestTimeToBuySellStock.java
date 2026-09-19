package week4;
import java.util.Scanner;

public class BestTimeToBuySellStock {

    static int maxProfit(int[] prices) {

        int lowestPrice = prices[0];
        int maxProfit = 0;

        // Check each day's price
        for (int i = 1; i < prices.length; i++) {

            // Update the lowest price
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            // Calculate profit if we sell today
            int profit = prices[i] - lowestPrice;

            // Update maximum profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);

        sc.close();
    }
}