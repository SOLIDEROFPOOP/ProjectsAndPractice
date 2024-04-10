import java.util.List;

public class RemoveNthNodeFromTheEndOfTheList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++){
            if (fast == null){
                return head;
            }
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow = slow.next.next;
        return dummy.next != null ? dummy.next : null;
    }
}
