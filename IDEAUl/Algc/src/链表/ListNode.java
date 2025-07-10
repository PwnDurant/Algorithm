package 链表;

public class ListNode {

    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){this.val = val;this.next = next;}


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

}
