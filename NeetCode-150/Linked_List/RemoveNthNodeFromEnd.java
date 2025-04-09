/**
 * Problem: Remove Nth Node From End of List
 * Difficulty: Medium
 * Topic: Linked List, Two Pointers
 * Description:
 *   Given the head of a linked list and an integer n, remove the nth node from the end of the list.
 *
 * Approach:
 * - Use a dummy node to handle edge cases like removing the head node.
 * - Set two pointers (`first` and `second`) starting at dummy.
 * - Move `first` n + 1 steps ahead (to maintain a gap of n between them).
 * - Move both pointers until `first` reaches the end of the list.
 * - `second` will now be right before the node to delete. Skip it.
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers at the dummy node
        ListNode first = dummy;
        ListNode second = dummy;

        // Move 'first' pointer n+1 steps ahead to create a gap of n between first and second
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until 'first' reaches the end
        // 'second' will be right before the node to be removed
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the target node by skipping it
        second.next = second.next.next;

        // Return the updated list (head might have changed)
        return dummy.next;
    }
}
