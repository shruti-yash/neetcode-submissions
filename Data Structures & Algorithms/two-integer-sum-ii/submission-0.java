class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int l = 0, r = numbers.length - 1;
        int res[] = new int[2];

        while (l < r) {
            int currSumm = numbers[l] + numbers[r];

            if (currSumm < target) {
                l++;
            } else if (currSumm > target) {
                r--;
            } else {
                return new int[]{l+1, r+1};
            }
        }

        return res;
        
    }
}
