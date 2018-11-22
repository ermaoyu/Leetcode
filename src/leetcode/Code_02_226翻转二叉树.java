package leetcode;


/**
 *      毛毛雨     2018/11/11
 *       4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * */
public class Code_02_226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)return root;
        TreeNode node = root;
        process(node);
        return root;
    }
    public void process(TreeNode root){
        if (root == null)return ;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        if (root.left != null){
            process(root.left);
        }
        if (root.right != null){
            process(root.right);
        }

    }
}
