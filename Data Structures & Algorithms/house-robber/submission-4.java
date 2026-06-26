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
