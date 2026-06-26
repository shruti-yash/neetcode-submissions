class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, res = nums[0];

        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
            if (count > max) {
                max = count;
                res = n;
            }
        }

        return res;
        
    }
}