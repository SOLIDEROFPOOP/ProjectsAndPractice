import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode current = start;
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.add(head);
            head = head.next;
        }
        while (!stack.empty()){
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        return start.next;
    }
    public static void main(String args[]){
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode temp = reverseLinkedList.reverseList(head);
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
