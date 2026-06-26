class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int profit1 = helper(0, n-1, nums);
        int profit2 = helper(1, n, nums);
        return Math.max(profit1, profit2);
    }

    private int helper(int start, int end, int[] nums) {
        int p1 = nums[start];
        int p2 = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i < end; i++) {
            int temp = Math.max(p1 + nums[i], p2);
            p1 = p2;
            p2 = temp;
        }
        return p2;
    }
}
