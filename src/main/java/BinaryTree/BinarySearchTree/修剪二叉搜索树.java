package BinaryTree.BinarySearchTree;

/**
 * @author kai
 * @date 2022/2/10 下午4:39
 */
/*
给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。

输入：root = [1,0,2], low = 1, high = 2
输出：[1,null,2]

输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
输出：[3,2,null,1]
 */
public class 修剪二叉搜索树 {
    public Node trimBST(Node root, int low, int high) {
        if (root == null) {
            return null;
        }
        //root.val比最小值low还要小找右子树使得：low<root.val<right
        if (root.val < low) {//最小值大于根节点 去右子树查找
            return trimBST(root.right, low, high);
        }
        //root.val比最大值high还要大找左子树使得：low<root.val<right
        if (root.val > high) {//最大值小于根节点 去左子树查找
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
