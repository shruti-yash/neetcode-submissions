class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
    
        int startIndex = 0;
        int maxLength = 0;
        int currLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                currLength++;

            } else if (nums[i] == nums[i-1]) {
                continue;

            } else {
                maxLength = Math.max(maxLength, currLength);
                currLength = 1;
            }
        }

        if (currLength > maxLength) {
            maxLength = currLength;
        }
        return maxLength;
        
    }
}
