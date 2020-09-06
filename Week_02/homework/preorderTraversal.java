//二叉树的前序遍历
/*
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
* */

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root,List<Integer> res){
        //前序遍历: 根 左 右
        //如果根不为空
        if(root !=null){

            res.add(root.val);
            //左子树不为null,遍历左子树
            if(root.left!=null){
                helper(root.left,res);
            }
            //右子树不为null,遍历右子树
            if(root.right!=null){
                helper(root.right,res);
            }
        }

    }

}