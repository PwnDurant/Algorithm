package 链表;


/**
 * <a href="https://leetcode.cn/problems/reorder-list/description/">题目链接</a>
 */
public class 重排链表 {

    /**
     * 使用静态内部类，否则每创建一个内部类都会多一个对外部类的引用
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val,ListNode next){this.val = val;this.next = next;}
    }

    public static void reorderListOld(ListNode head1) {
        if(head1 == null || head1.next == null || head1.next.next == null) return;
        // 找出中间节点
        ListNode slow;
        ListNode fast;
        slow = fast = head1;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 分割链表
        ListNode cur = slow.next;
        slow.next = null;
        // 翻转链表
        ListNode next;
        ListNode newHead = new ListNode(0,null);
        ListNode nnext;
        while(cur != null){
            nnext= newHead.next;
            next = cur.next;
            newHead.next = cur;
            cur.next = nnext;
            cur = next;
        }
        // 合并两个链表
        ListNode head2 = newHead.next;
        ListNode next1;
        ListNode next2;
        while(head2 != null){
            next1 = head1.next;
            next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }

    public static void reorderListNew(ListNode head){
        // 处理边界情况
        if(head == null || head.next == null || head.next.next == null) return;
        // 快慢双指针找出链表中间节点
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 使用“头插法”把 slow 后面的部分逆序排列
        ListNode cur = slow.next;
        slow.next = null; // 把两链表分割开
        ListNode head2 = new ListNode();
        while(cur != null){
            ListNode next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = next;
        }
        // 合并两个链表 -- 双指针
        ListNode cur1 = head,cur2 = head2.next;
        ListNode ret = new ListNode(0);
        ListNode prev = ret;
        while(cur1 != null){
            // 先放第一个链表
            prev.next = cur1;
            prev = cur1;
            cur1 = cur1.next;
            // 再放第二个链表
            if(cur2 != null){
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }
    }

    public static void Print(ListNode head){
        ListNode cur = head;
        ListNode next;
        while(cur != null){
            next = cur.next;
            System.out.println(cur.val);
            cur = next;
        }
    }

    public static int size(ListNode head){
        int size = 0;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            size++;
            next = cur.next;
            cur = next;
        }
        return size;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1,null);
        ListNode listNode = new ListNode(2,null);
        ListNode listNode1 = new ListNode(3,null);
        ListNode listNode2 = new ListNode(4,null);
//        ListNode listNode3 = new ListNode(5,null);
        head.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
        reorderListNew(head);
        Print(head);
//        System.out.println(size(head));
    }

}

