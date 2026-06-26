class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr = curr^i^nums[i];
        }

        curr = curr^n;
        return curr;
        
    }
}
