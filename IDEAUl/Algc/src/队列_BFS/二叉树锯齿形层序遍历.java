package 队列_BFS;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">题目链接</a>
 */
public class 二叉树锯齿形层序遍历 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 初始化结果
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        // 把头节点先入队
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode t = q.poll();  // 把队列中的节点按顺序一个个取出来，并统计子节点
                tmp.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            // 判断是否逆序
            if(level % 2 == 0) Collections.reverse(tmp);
            ret.add(tmp);
            level ++;
        }
        return ret;
    }


    public static List<List<Integer>> test(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                tmp.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }

            if(level % 2 == 0) Collections.reverse(tmp);
            ret.add(tmp);
            level ++;
        }
        return  ret;
    }

    public static void main(String[] args) {
//        输入：root = [3,9,20,null,null,15,7]
//        输出：[[3],[20,9],[15,7]]
        TreeNode node1 = new TreeNode(15, null, null);
        TreeNode node2 = new TreeNode(7, null, null);
        TreeNode node3 = new TreeNode(20, node1, node2);
        TreeNode node4 = new TreeNode(9, null, null);
        TreeNode node5 = new TreeNode(3, node4, node3);
        System.out.println(test(node5).toString());
        System.out.println(zigzagLevelOrder(node5).toString());

    }

}

