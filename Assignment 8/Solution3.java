package main;

import java.util.Arrays;

class Solution3 
{
    public int coinChange(int[] denominations, int totalAmount) 
    {
        final int MAX_VALUE = Integer.MAX_VALUE / 2; 
        int numCoins = denominations.length;
        int[][] dp = new int[numCoins + 1][totalAmount + 1];

        for (int[] row : dp) 
        {
            Arrays.fill(row, MAX_VALUE);
        }

        dp[0][0] = 0; 

        for (int i = 1; i <= numCoins; ++i) {
            for (int amount = 0; amount <= totalAmount; ++amount) 
            {
                dp[i][amount] = dp[i - 1][amount];
                if (amount >= denominations[i - 1]) {
                    dp[i][amount] = Math.min(dp[i][amount], dp[i][amount - denominations[i - 1]] + 1);
                }
            }
        }

        return dp[numCoins][totalAmount] >= MAX_VALUE ? -1 : dp[numCoins][totalAmount];
    }
}
