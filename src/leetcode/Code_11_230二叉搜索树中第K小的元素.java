package leetcode;

/**
 * maomaoyu    2018/12/4_23:41
 **/
public class Code_11_230二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        process(root);
        return val;
    }
    public static int count = 0;
    public static int val = 0;
    private void process(TreeNode root){
       if (root == null)return;
       if (root.left != null)
           process(root.left);
       --count;
       if (count == 0){
            val = root.val;
            return;
       }
       if (root.right != null)
           process(root.right);
    }
}
