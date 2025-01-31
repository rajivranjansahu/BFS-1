// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         // TC = O(N)
//         // SC = O(N / 2) ~ O(N) (as max items in q is leaves ie n/2)
//         List<List<Integer>> result = new ArrayList<>();
//         // null
//         if(root == null) return result;
//         // Queue to store the nodes
//         Queue<TreeNode> q = new LinkedList<>(); //Queue in Java is LL
//         q.add(root);
//         while(!q.isEmpty()) {
//             int size = q.size(); // preserving the size of q to iterate on that level
//             List<Integer> l = new ArrayList<>();
//             for(int i = 0; i < size; i++) {
//                 TreeNode curr = q.poll();
//                 l.add(curr.val); // adding the curr values in the list but children in the q for future iterations
//                 if(curr.left != null) q.add(curr.left);
//                 if(curr.right != null) q.add(curr.right);
//             }
//             result.add(l);
//         }
//         return result;
//     }
// }

// or DFS
class Solution {
    // TC = O(N), SC = O(H) rec stack space
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level) {
        // base
        if(root == null) return;
        // logic
        if(result.size() == level) result.add(new ArrayList<>()); // if res size is = to level ie height of BT, then we need to add a List to res, if not add value to the already present list
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}