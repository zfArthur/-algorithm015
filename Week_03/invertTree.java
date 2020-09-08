//翻转二叉树
/*示例：

    输入：

    4
    /   \
    2     7
    / \   / \
    1   3 6   9
    输出：

    4
    /   \
    7     2
    / \   / \
    9   6 3   1

 */

//递归解法
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
    public TreeNode invertTree(TreeNode root) {
        //递归终止条件
        if(root!=null){
            //处理本层递归
            TreeNode tempNode = new TreeNode();
            tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            //跳到下一层递归
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}