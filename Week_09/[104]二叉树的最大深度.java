//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 728 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //左右子树中的最大深度+1
    //求左子树的最大高度会走 步骤2和步骤3--》步骤4
    //求右子树的最大高度会走 步骤2和步骤3--》步骤4
    //注意深度也包含叶子节点
    public int maxDepth(TreeNode root) {
        //步骤1
        if (root==null) return 0;
        //步骤2
        int leftMax = maxDepth(root.left);
        //步骤3
        int rightMax = maxDepth(root.right);
        //步骤4
        return Math.max(leftMax,rightMax)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
