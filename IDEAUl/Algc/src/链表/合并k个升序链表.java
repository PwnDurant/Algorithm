package 链表;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/">题目链接</a>
 */
public class 合并k个升序链表 {

    public static ListNode mergeKListsOld(ListNode[] lists) {
        // 1，创建一个小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        // 2，把所有的头节点放入小根堆中，在遍历的时候注意空指针
        for (ListNode head : lists)
            if(head != null) heap.offer(head); // 只有当头节点不为空的时候才其放入小根堆中进行比较
        // 3，合并
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        while(!heap.isEmpty()){
            cur.next = heap.poll();
            cur = cur.next;
            if(cur.next != null) heap.offer(cur.next);
        }
        return newHead.next;
    }

    /**
     * 使用归并排序的方式实现（递归，分治的思想）
     */
    public static ListNode mergeKListsNew(ListNode[] lists) {
        return merge(lists,0,lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists,int left,int right){
        if(left > right) return null; // 说明此时传入的是一个空链表
        if(left == right) return lists[left];
        // 1，平分数组 [left,mid] [mid + 1,right]
        int mid = (left + right) / 2;
        // 2，递归处理左右两组
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid + 1,right);
        // 3，合并两个有序链表
        return mergeTwoListNew(l1,l2);
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null) cur.next = l1;
        else cur.next = l2;
        return newHead.next;
    }

    private static ListNode mergeTwoListNew(ListNode l1, ListNode l2) {
        // 非空校验
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        // 合并两有序链表
        ListNode head = new ListNode();
        ListNode cur1 = l1,cur2 = l2,prev = head;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                prev.next = cur1;
                prev = cur1;
                cur1 = cur1.next;
            }else{
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null) prev.next = cur1;
        if(cur2 != null) prev.next = cur2;
        return head.next;
    }

    public static void main(String[] args) {
        // 1 4 5 1 3 4 2 6
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(2);
        ListNode listNode7 = new ListNode(6);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode6.next = listNode7;
        ListNode[] list = {listNode,listNode3,listNode6};
        ListNode sortList = mergeKListsNew(list);
        ListNode.Print(sortList);
    }

}
