package 队列_BFS;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/">题目链接</a>
 * /*
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public List<Node> children;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, List<Node> _children) {
 *         val = _val;
 *         children = _children;
 *     }
 * };
 * */

import java.util.*;


public class N叉树的层序遍历 {

     static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> nodes = new LinkedList<>();

        if(root == null) return result;
        if(root.children == null) return result;

        nodes.add(root);

        ArrayList<Integer> tmp1 = new ArrayList<>();
        tmp1.add(root.val);
        result.add(tmp1);
        int times = 1;

        while(!nodes.isEmpty()){

            ArrayList<Integer> tmp = new ArrayList<>();
            int num = 0;

            for (int i = 0; i < times; i++) {
                List<Node> children = Objects.requireNonNull(nodes.poll()).children;
                if(children == null) continue;
                num += children.size();
                for (Node child : children) {
                    nodes.offer(child);
                    tmp.add(child.val);
                }
            }
            times = num;
            if(!tmp.isEmpty()) result.add(tmp);
        }
        return result;
    }

    public static List<List<Integer>> levelOrderNew(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                Node t = q.poll();
                tmp.add(t.val);
                for (Node child : t.children) {
                    if(child != null) q.add(child);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }

    public static void main(String[] args) {
//        输入：root = [1,null,3,2,4,null,5,6]
//        输出：[[1],[3,2,4],[5,6]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.children = Arrays.asList(node3,node2,node4);
        node3.children = Arrays.asList(node5, node6);
        node2.children = Arrays.asList(node7,node8);
        System.out.println(levelOrder(node1));
    }

}
