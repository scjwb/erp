package List;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode ahead = null;
        ListNode current = head;
        ListNode tmp;
        while (current.next !=null){
            tmp = current.next;
            current.next = ahead;
            ahead = current;
            current = tmp;
        }
        current.next = ahead;
        return current;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }

        ListNode begin = new ListNode(0);
        ListNode cur = begin;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            cur.next = l2;
        }else {
            cur.next = l1;
        }
        return begin.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode cur2 = new ListNode(0);
        ListNode res = cur2;
        cur2.next = head;
        int count = 0;
        while (cur!=null){
            count++;
            cur = cur.next;
        }
        int index = count - n;
        for (int i = 0;i<index;i++){
            cur2 = cur2.next;
        }
        cur2.next = cur2.next.next;
        return res.next;
    }
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode first = dummy;
       ListNode second = dummy;
       for (int i=0;i<=n;i++){
           first = first.next;
        }
        while (first!=null){
           first = first.next;
           second = second.next;
        }
        second.next = second.next.next;
       return dummy.next;
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        slow.next = head;
        fast.next = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null){
            return slow;
        }
        return slow.next;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        middleNode(listNode1);
    }
}
