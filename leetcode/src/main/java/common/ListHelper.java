package common;

public class ListHelper {

    public static ListNode createLinkedList(int[] nums) {
        ListNode head = null;
        for (int i = nums.length - 1; i >= 0; i++) {
            ListNode node = new ListNode(nums[i]);
            node.next = head;
            head = node;
        }
        
        return head;
    }
    
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
