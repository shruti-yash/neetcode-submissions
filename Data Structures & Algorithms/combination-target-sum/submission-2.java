class Solution {
    /*
        REVIST THIS TO UNDERSTAND (SOLUTION FROM NEETCODE, BELOW EXPLANATION FROM CLAUDE)

    * Time Complexity: O(N ^ (T / M))
    *   - N = number of candidates
    *   - T = target value
    *   - M = minimum value in candidates
    *
    * Why?
    *   At each node in the recursion tree, we loop over remaining candidates → N branches.
    *   The deepest path is target / min_candidate levels deep (e.g. target=8, min=2 → 4 levels).
    *   So worst case nodes = N ^ (T/M).
    *
    * Space Complexity: O(T / M)
    *   - This is the max recursion depth (height of the call stack).
    *   - Each recursive call adds one frame. Deepest path = T/M frames at once.
    *   - We do NOT count the output list (res) in space complexity by convention.
    *
    * Example: candidates = [2,3,6,7], target = 7
    *   Max depth = 7/2 = 3-4 levels
    *   Branching = up to 4 choices per node
    *   Worst case ≈ 4^4 = 256 nodes explored
    */
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
