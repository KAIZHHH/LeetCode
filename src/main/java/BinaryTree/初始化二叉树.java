package BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kai
 * @date 2022/8/29 下午6:45
 */
class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class 初始化二叉树 {
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Node build = build(br);
        preOrder(build);
        inOrder(build);
        postOrder(build);
        System.out.println(pre.toString());
        System.out.println(in.toString());
        System.out.println(post.toString());
    }

    private static void preOrder(Node build) {
        if (build == null) return;
        pre.append(build.val + " ");
        preOrder(build.left);
        preOrder(build.right);
    }

    private static void inOrder(Node build) {
        if (build == null) return;
        inOrder(build.left);
        pre.append(build.val + " ");
        inOrder(build.right);
    }

    private static void postOrder(Node build) {
        if (build == null) return;
        postOrder(build.left);
        postOrder(build.right);
        pre.append(build.val + " ");

    }

    public static Node build(BufferedReader br) throws IOException {
        String[] str = br.readLine().trim().split(" ");
        int val = Integer.parseInt(str[0]);
        int left = Integer.parseInt(str[1]);
        int right = Integer.parseInt(str[2]);
        Node root = new Node(val);
        root.left = build(br);
        root.right = build(br);
        return root;

    }

}
