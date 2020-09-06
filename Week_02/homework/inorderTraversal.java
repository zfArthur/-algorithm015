//二叉树的中序遍历
/*
给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

//解法一: 递归
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode root,List<Integer> res){
        //中序遍历顺序: 左 根 右
        //树不为空
        if(root != null){
            //左子树不为空,遍历左子树
            if(root.left != null){
                helper(root.left,res);
            }
            //遍历根
            res.add(root.val);
            //右子树不为空,遍历右子树
            if(root.right!=null){
                helper(root.right,res);
            }
        }
    }
}

