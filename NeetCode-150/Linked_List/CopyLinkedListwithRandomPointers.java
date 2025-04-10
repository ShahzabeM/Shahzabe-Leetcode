/**
 * Problem: Copy List with Random Pointer
 * Difficulty: Medium
 * Topic: Linked List, HashMap
 * Description:
 *   Make a deep copy of a linked list where each node has a 'next' and 'random' pointer.
 *
 * Approach:
 *   - We use a two-pass method and a HashMap to track mapping from original → copy.
 *
 * Step 1: Create all new nodes with correct values.
 *         Store them in a map: original node → new node.
 *
 * Step 2: Assign .next and .random for each copied node using the map.
 *         copy.next = oldToNew.get(original.next)
 *         copy.random = oldToNew.get(original.random)
 *
 * 💡 Key Realization:
 *   `.random` is just like `.next` — it's a hardcoded pointer to another node in memory.
 *   It's not a value or index we calculate — it's a direct reference to a node.
 *   Our job is to translate `.random` from pointing to an original node
 *   → to pointing to the corresponding **copied node** using the HashMap.
 *
 *   We don't store `.random` separately — we rebuild the structure
 *   by following `.random` pointers in the original list and using the map to find their matches.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N) – due to the map
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // HashMap to map original nodes → copied nodes
        Map<Node, Node> oldToNew = new HashMap<>();

        // Step 1: Create all the new nodes and store them in the map
        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers using the map
        curr = head;
        while (curr != null) {
            Node copy = oldToNew.get(curr);
            copy.next = oldToNew.get(curr.next);       // could be null
            copy.random = oldToNew.get(curr.random);   // could be null
            curr = curr.next;
        }

        // Return the copied head
        return oldToNew.get(head);
    }
}

/**
 * 📘 How This Code Works (Full Explanation):
 *
 * This solution performs a deep copy of a linked list where each node has both `.next` and `.random` pointers.
 * It works in two main passes using a HashMap. In the first pass, we iterate through the original list and create
 * a copy of each node, storing a mapping from the original node to its new counterpart in the `oldToNew` map.
 * At this point, the copied nodes exist but are not connected.
 *
 * In the second pass, we use the map to connect each copied node’s `.next` and `.random` pointers
 * by translating the original connections into new ones. The key realization is that `.random`,
 * like `.next`, is a direct memory pointer — not a value or index — so our job is to redirect those pointers
 * using our map to point to the corresponding nodes in the new list.
 *
 * The end result is a fully independent deep copy of the original list with the exact same structure.
 */
