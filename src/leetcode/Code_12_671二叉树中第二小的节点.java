package leetcode;

import java.util.Map;

/**
 * maomaoyu    2018/12/5_0:08
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，
 * 并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。
 * 如果第二小的值不存在的话，输出 -1 。
 **/
public class Code_12_671二叉树中第二小的节点 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null)return -1;
        return process(root,root.val);
    }
    public int process(TreeNode root,int min){
        if (root .left == null)
        return root.val == min ? -1 : root.val;

        int left = process(root.left,min);
        int right = process(root.right,min);

        if (left == -1 || right == -1){
            return Math.max(left,right);
        }
        else return Math.min(right,left);
    }
}
