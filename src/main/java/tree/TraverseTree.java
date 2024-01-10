package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Jaa
 * @Description:
 * @Date 2024/1/9
 */
public class TraverseTree {

    /**
     * 前序遍历
     */
    // 递归
    public static void preOrder(TreeNode tree) {
        if (tree == null) return;
        System.out.printf(tree.val + "");
        preOrder(tree.left);
        preOrder(tree.right);
    }

    // 非递归
    public static void preOrder1(TreeNode tree) {
        if (tree == null) return;
        Stack<TreeNode> q1 = new Stack<>();
        q1.push(tree);//压栈
        while (!q1.empty()) {
            TreeNode t1 = q1.pop();//出栈
            System.out.println(t1.val);
            if (t1.right != null) {
                q1.push(t1.right);
            }
            if (t1.left != null) {
                q1.push(t1.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    // 递归
    public static void inOrder(TreeNode tree) {
        if (tree == null) return;
        preOrder(tree.left);
        System.out.printf(tree.val + "");
        preOrder(tree.right);
    }

    // 非递归
    public static void inOrderTraversal(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                System.out.println(tree.val);
                tree = tree.right;
            }
        }
    }


    /**
     * 后序遍历
     */
    // 递归
    public static void postOrder(TreeNode tree) {
        if (tree == null) return;
        preOrder(tree.left);
        preOrder(tree.right);
        System.out.printf(tree.val + "");
    }

    // 非递归
    public static void postOrder1(TreeNode tree) {
        if (tree == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(tree);
        while (!s1.isEmpty()) {
            tree = s1.pop();
            s2.push(tree);
            if (tree.left != null) {
                s1.push(tree.left);
            }
            if (tree.right != null) {
                s1.push(tree.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
    }

    public static void postOrder2(TreeNode tree) {
        if (tree == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        TreeNode c;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && tree != c.left && tree != c.right) {
                stack.push(c.left);
            } else if (c.right != null && tree != c.right) {
                stack.push(c.right);
            } else {
                System.out.print(stack.pop().val + " ");
                tree = c;
            }
        }
    }

    /**
     * BFS(广度优先搜索)
     */
    // 递归
    public static void levelOrder(TreeNode tree) {
        int depth = depth(tree);
        for (int level = 0; level < depth; level++) {
            printLevel(tree, level);
        }
    }

    private static int depth(TreeNode tree) {
        if (tree == null) return 0;
        int leftDepth = depth(tree.left);
        int rightDepth = depth(tree.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static void printLevel(TreeNode tree, int level) {
        if (tree == null) return;
        if (level == 0) {
            System.out.print(" " + tree.val);
        } else {
            printLevel(tree.left, level - 1);
            printLevel(tree.right, level - 1);
        }
    }

    // 非递归
    public static void levelOrder1(TreeNode tree) {
        if (tree == null) return;
        LinkedList<TreeNode> list = new LinkedList<>(); // 链表，可以把它看做队列
        list.add(tree); // 相当于把数据加入到队列尾部
        while (!list.isEmpty()) {
            TreeNode node = list.poll(); // poll方法相当于移除队列头部的元素
            System.out.println(node.val);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
        }
    }

    // 结果存放到list中
    public static List<List<Integer>> levelOrder2(TreeNode tree) {
        if (tree == null)
            return null;
        List<List<Integer>> list = new ArrayList<>();
        bfs(tree, 0, list);
        return list;
    }

    private static void bfs(TreeNode tree, int level, List<List<Integer>> list) {
        if (tree == null)
            return;
        if (level >= list.size()) {
            List<Integer> subList = new ArrayList<>();
            subList.add(tree.val);
            list.add(subList);
        } else {
            list.get(level).add(tree.val);
        }
        bfs(tree.left, level + 1, list);
        bfs(tree.right, level + 1, list);
    }

    /**
     * DFS(深度优先搜索)
     */
    // 递归
    public static void treeDFS(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        treeDFS(root.left);
        treeDFS(root.right);
    }

    // 非递归
    public static void treeDFS1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


}
