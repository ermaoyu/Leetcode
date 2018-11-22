package leetcode;

/**
 *      毛毛雨     2018/11/11
 *      给定二叉搜索树（BST）的根节点和一个值。
 *      你需要在BST中找到节点值等于给定值的节点。
 *      返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * */
public class Code_03_700二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;
        TreeNode node = null;
        while(root != null){
            if (root.val == val)return root;
            else if (root.val < val)root = root.right;
            else if (root.val > val)root = root.left;
        }
        return node;
    }

}

