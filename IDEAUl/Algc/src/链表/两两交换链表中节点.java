package 链表;

/**
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/">题目链接</a>
 */
public class 两两交换链表中节点 {


    public static ListNode swapPairsOld(ListNode head) {
        // 非空判断
        if(head == null || head.next ==null) return head;
        ListNode newHead = new ListNode();
        ListNode pre = newHead,cur = head,next = cur.next,nnext = next.next;
        while(cur != null && next != null){
            pre.next = next;
            next.next = cur;
            cur.next = nnext;
            pre = cur;
            cur = nnext;
            next = (cur == null?null:cur.next);
            nnext = (next == null?null:next.next);
        }
        return newHead.next;
    }

    public static ListNode swapPairsNew(ListNode head) {
        // 非空判断
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead,cur = prev.next,next = cur.next,nnext = next.next;
        while(cur != null && next != null){
            // 交换节点
            prev.next = next;
            next.next = cur;
            cur.next = nnext;
            // 修改指针
            prev = cur;
            cur = nnext;
            if(cur != null) next = cur.next;
            if(next != null) nnext = next.next;
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode.Print(swapPairsOld(listNode));
    }

}
