//二叉树的后序遍历
/*
*
* 给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

* */

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        //后序 遍历  左右根
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root,List<Integer> res){
        if(root!=null){
            if(root.left!=null){
                helper(root.left,res);
            }
            if(root.right!=null){
                helper(root.right,res);
            }
            res.add(root.val);
        }
    }
}