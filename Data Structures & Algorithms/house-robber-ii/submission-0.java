class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int profit1 = nums[0];
        int profit2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n-1; i++) {
            int temp = Math.max(profit1 + nums[i], profit2);
            profit1 = profit2;
            profit2 = temp;
        }

        int profit_1 = nums[1];
        int profit_2 = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            int temp = Math.max(profit_1 + nums[i], profit_2);
            profit_1 = profit_2;
            profit_2 = temp;
        }

        return Math.max(profit2, profit_2);
    }
}
