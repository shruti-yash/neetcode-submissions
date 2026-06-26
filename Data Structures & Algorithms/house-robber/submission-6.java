class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int profit1 = nums[0];
        int profit2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int profit = Math.max(profit2, profit1 + nums[i]);
            profit1 = profit2;
            profit2 = profit;
        }

        return profit2;
        
    }
}

/*
 * HOUSE ROBBER - Medium | Pattern: 1D DP
 *
 * Key Insight: At every house, two choices:
 *   - Rob it   → nums[i] + best profit up to house i-2
 *   - Skip it  → best profit up to house i-1
 *   Take the max of both.
 *
 * Subproblem:  dp[i] = max money robbable from houses 0..i
 * Recurrence:  dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 * Base cases:  dp[0] = nums[0]
 *              dp[1] = max(nums[0], nums[1])
 *
 * Complexity:
 *   Brute force recursion  → O(2^n) time, O(n) space
 *   Bottom-up DP array     → O(n)   time, O(n) space
 *   Two variables (optimal)→ O(n)   time, O(1) space  ✅
 *
 * Optimization: dp[i] only needs dp[i-1] and dp[i-2]
 *   → replace array with two variables (profit1, profit2)
 *
 * Watch out:
 *   - Recurrence is dp[i-2] not dp[i-1] in the rob branch
 *     (easy to accidentally write dp[i-1] + nums[i])
 *   - n=1 edge case: dp[1] access fails if array has only 1 element
 *     → guard with if (n == 1) return nums[0]
 */
