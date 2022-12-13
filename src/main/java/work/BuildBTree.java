package work;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai
 * @date 2022/3/28 下午8:33
 */

public class BuildBTree {
    public static void main(String[] args) {
        Integer[] array={1,1,1,null,null,1,1,1};
        TreeNode bt = createBT(array);
        System.out.println(bt);
    }

    public static TreeNode createBT(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        // 创建第一个结点
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        // 遍历子结点的方向
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            // 取出队尾元素
            TreeNode node = deque.getLast();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    deque.addFirst(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    deque.addFirst(node.right);
                }
                // 删除队尾元素
                deque.removeLast();
                isLeft = true;
            }
        }
        return root;
    }

}
