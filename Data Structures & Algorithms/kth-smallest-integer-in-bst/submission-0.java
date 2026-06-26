/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int kthSmallest = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root, k);
        return kthSmallest;
    }

    private void dfs(TreeNode curr, int k) {
        if (curr == null) return;

        dfs(curr.left, k);
        if (count == 0) return;

        count--;
        if (count == 0) {
            kthSmallest = curr.val;
            return;
        }

        dfs(curr.right, k);
    }
}
