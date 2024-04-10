public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        ListNode prev = slow.next = null;
        while (secondHalf != null){
            ListNode temp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }
        secondHalf = prev;
        ListNode first = head;
        while (secondHalf != null){
            ListNode temp1 = first.next;
            ListNode temp2 = secondHalf.next;
            first.next = secondHalf;
            secondHalf.next = temp1;
            first = temp1;
            secondHalf = temp2;
        }
    }
}
