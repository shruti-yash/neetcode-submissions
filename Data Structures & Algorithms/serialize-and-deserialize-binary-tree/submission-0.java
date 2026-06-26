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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialiseDfs(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void serialiseDfs(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null").append(",");
                return;
            }
            sb.append(node.val).append(",");
            serialiseDfs(node.left, sb);
            serialiseDfs(node.right, sb);
        }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        int[] itr = new int[]{0};
        return deserialiseDfs(strings, itr);
    }

    private TreeNode deserialiseDfs(String[] strings, int[] itr) {
            if (strings[itr[0]].equals("null")) {
                itr[0]++;
                return null;
            }

            TreeNode node = new TreeNode(Integer.valueOf(strings[itr[0]]));
            itr[0]++;
            node.left = deserialiseDfs(strings, itr);
            node.right = deserialiseDfs(strings, itr);
            return node;
        }
}
