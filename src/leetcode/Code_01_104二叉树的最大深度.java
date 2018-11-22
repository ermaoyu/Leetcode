package leetcode;

/**
 * 毛毛雨     2018/11/11
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Code_01_104二叉树的最大深度 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        return process(root);
    }

    public int process(TreeNode root){
        if (root == null)return 0;
        int left = 0;
        int right = 0;
        if (root.left != null){
           left =   process(root.left);
        }
        if (root.right != root){
             right = process(root.right);
        }
        int max = 0;
        max = Math.max(left,right);
        return max + 1;
    }
}
