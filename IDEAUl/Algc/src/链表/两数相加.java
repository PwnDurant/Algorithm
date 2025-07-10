package 链表;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">题目链接</a>
 */
public class 两数相加 {

    public static ListNode addTwoNumbersOld(ListNode cur1, ListNode cur2) {
        ListNode newHead = new ListNode(),next1,next2,next;
        int tmp = 0;
        ListNode cur = newHead;
        while(cur1 != null || cur2 != null || tmp != 0){
            if(cur1 != null) {
                next1 = cur1.next;
                tmp += cur1.val;
                cur1 = next1;
            }
            if(cur2 != null) {
                next2 = cur2.next;
                tmp += cur2.val;
                cur2 = next2;
            }
            // 尾插法
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
            tmp /= 10;
        }
        return newHead.next;
    }

    public static ListNode addTwoNumbersNew(ListNode l1, ListNode l2) {
        ListNode cur1 = l1,cur2 = l2;
        ListNode newHead = new ListNode(0); // 创建一个虚拟头节点，方便记录结果
        ListNode prev = newHead; // 尾插操作的尾指针
        int t = 0; // 记录进位
        while(cur1 != null || cur2 != null || t != 0){
            // 先加上第一个链表
            if(cur1 != null){
                t += cur1.val;
                cur1 = cur1.next;
            }
            // 再加上第二个链表
            if(cur2 != null){
                t += cur2.val;
                cur2 = cur2.next;
            }
            // 尾插节点
            prev.next = new ListNode(t % 10);
            prev = prev.next;
            t /= 10;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode6 = addTwoNumbersOld(listNode, listNode3);
        System.out.println(ListNode.size(listNode6));
        ListNode.Print(listNode6);
    }

}
