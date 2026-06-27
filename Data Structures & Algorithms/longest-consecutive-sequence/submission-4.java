class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            int temp = num;
            int count = 1;
            while (set.contains(temp + 1)) {
                temp++;
                count++;
            }

            res = Math.max(res, count);
        }

        return res;
        
    }
}
