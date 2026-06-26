class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return nums; 

        int[] output = new int[nums.length];
        output[0] = 1;

        int prefix = 1;
        for (int i = 0; i < nums.length-1; i++) {
            prefix *= nums[i];
            output[i+1] = prefix;
        }

        int suffix = 1;
        for (int i = nums.length-1; i > 0; i--) {
            suffix *= nums[i];
            output[i-1] *= suffix;
        }

        return output;
        
    }
}  
