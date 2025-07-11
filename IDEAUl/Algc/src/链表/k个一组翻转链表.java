package 链表;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">题目链接</a>
 */
public class k个一组翻转链表 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
        ListNode pre = newHead,cur = head;
        int size = ListNode.size(head);
        for (int i = 0; i < size/k; i++) {
            ListNode tmp = cur;
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = next;
            }
            pre = tmp;
        }
        pre.next = cur;
        return newHead.next;
    }

    public static ListNode reverseKGroupNew(ListNode head, int k) {
        // 1，先求出需要逆序多少组
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        n /= k;
        // 2，重复 n 次长度为 k 链表逆序
        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        cur = head;
        for (int i = 0; i < n; i++) {
            ListNode tmp = cur;
            for (int j = 0; j < k; j++) {
                // 1, 头插逻辑
                ListNode next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                cur = next;
            }
            prev = tmp;
        }
        // 3，把后面不需要的部分连接上
        prev.next = cur;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode resultList = reverseKGroup(listNode,2);
        ListNode.Print(resultList);
    }
}
