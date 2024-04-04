public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode(0);
        ListNode current = start;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        while (list1 != null){
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }
        while (list2 != null){
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }
        return start.next;
    }
}
