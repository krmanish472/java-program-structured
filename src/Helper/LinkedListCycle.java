package Helper;

// Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // run the loop until pointer(s) encounter null
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next; // move one step at a time
            fastPtr = fastPtr.next.next; // move 2 step at a time

            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }
}

/**
 * fastPtr.next != null check is added - as we move fastPtr 2 step
 * i.e. if fastPtr moves 2 step that means we have to check if there is step-1 available
 * Also, fastPtr.next.next will throw error if we don't check fastPtr.next!=null
 * <p>
 * Refactored  while (slowPtr != null && fastPtr != null && fastPtr.next != null)
 * to while (fastPtr != null && fastPtr.next != null) as
 * fastPtr.next already accommodates for slowPtr != null on next cycle
 */
