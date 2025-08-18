package 队列_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 在每个数行中找最大值 {

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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int sz = q.size();
            int tmp = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode p = q.poll();
                tmp = Math.max(tmp,p.val);
                if(p.left != null) q.add(p.left);
                if(p.right != null) q.add(p.right);
            }
            ret.add(tmp);
        }

        return ret;
    }

    public static void main(String[] args) {

    }

}
