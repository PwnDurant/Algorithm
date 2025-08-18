package 队列_BFS;

import java.util.ArrayList;
import java.util.List;

class Pair<K, V> {
    public K key;
    public V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class 二叉树的最大宽度 {

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

    public static int widthOfBinaryTree(二叉树锯齿形层序遍历.TreeNode root) {
        List<Pair<二叉树锯齿形层序遍历.TreeNode,Integer>> q = new ArrayList<>(); // 用数组模拟队列
        q.add(new Pair<二叉树锯齿形层序遍历.TreeNode,Integer>(root,1));
        int ret = 0;  // 记录最终结果
        while(!q.isEmpty()){
            // 先更新当前层级宽度
            Pair<二叉树锯齿形层序遍历.TreeNode,Integer> t1 = q.get(0);
            Pair<二叉树锯齿形层序遍历.TreeNode,Integer> t2= q.get(q.size() - 1);
            ret = Math.max(ret,t2.getValue() - t1.getValue() + 1);

            // 让下一层进队
            List<Pair<二叉树锯齿形层序遍历.TreeNode,Integer>> tmp = new ArrayList<>();
            for(Pair<二叉树锯齿形层序遍历.TreeNode,Integer> t : q){
                二叉树锯齿形层序遍历.TreeNode node = t.getKey();
                int index = t.getValue();
                if(node.left != null) tmp.add(new Pair<二叉树锯齿形层序遍历.TreeNode,Integer>(node.left,index * 2));
                if(node.right != null) tmp.add(new Pair<二叉树锯齿形层序遍历.TreeNode,Integer>(node.right,index * 2 + 1));
            }
            q = tmp;
        }
        return ret;
    }

    public static int width(TreeNode root){
       List<Pair<TreeNode,Integer>> q = new ArrayList<>();
       q.add(new Pair<TreeNode,Integer>(root,1));
       int ret = 0; // 记录最终结果
       while(!q.isEmpty()){
           // 计算当前层级宽度
           ret = Math.max(ret,(q.get(q.size() - 1).getValue() - q.get(0).getValue() + 1));
           List<Pair<TreeNode,Integer>> tmp = new ArrayList<>();
           for(Pair<TreeNode,Integer> p : q){
               int index = p.getValue();
               if(p.getKey().left != null) tmp.add(new Pair<TreeNode,Integer>(p.getKey().left,2 * index));
               if(p.getKey().right != null) tmp.add(new Pair<TreeNode,Integer>(p.getKey().right,2 * index + 1));
           }
           q = tmp;
       }
       return ret;
    }

    public static void main(String[] args) {

    }

}
