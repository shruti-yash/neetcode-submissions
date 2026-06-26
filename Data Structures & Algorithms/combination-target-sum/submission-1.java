class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<>();
        backtrack(0, 0, target, nums, curr);
        return res;
    }

    private void backtrack(int start, int count, int target, int[] nums, List<Integer> curr) {
        if (count > target || start >= nums.length) {
            return;
        }

        if (count == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i, count + nums[i], target, nums, curr);
            curr.remove(curr.size()-1);
        }
    }

    //NOTE :: This solution is easy to understand but it is going through duplicate paths unnecessarily

    // List<List<Integer>> res = new ArrayList<>();

    // public List<List<Integer>> combinationSum(int[] nums, int target) {
    //     List<Integer> curr = new ArrayList<>();
    //     backtrack(0, 0, target, nums, curr);
    //     return res;
    // }

    // private void backtrack(int start, int count, int target, int[] nums, List<Integer> curr) {
    //     if (count > target || start >= nums.length) {
    //         return;
    //     }

    //     if (count == target) {
    //         res.add(new ArrayList<>(curr));
    //         return;
    //     }

    //     curr.add(nums[start]);
    //     backtrack(start, count + nums[start], target, nums, curr);
    //     curr.remove(curr.size()-1);
    //     backtrack(start+1, count, target, nums, curr);
    // }
}
