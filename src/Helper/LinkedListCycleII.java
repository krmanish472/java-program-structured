package Helper;

public class LinkedListCycleII {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // run the loop until pointer(s) encounter null
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next; // move one step at a time
            fastPtr = fastPtr.next.next; // move 2 step at a time

            // as soon as they meet - move head/fastPtr to start
            // and move both at same speed
            if (slowPtr == fastPtr) {
                while (head != slowPtr) {
                    head = head.next;
                    slowPtr = slowPtr.next;
                }
                return slowPtr;
            }
        }
        return null;
    }
}

/**
 * fastPtr.next != null check is added - as we move fastPtr 2 step
 * i.e. if fastPtr moves 2 step that means we have to check if there is step-1 available
 * Also, fastPtr.next.next will throw error if we don't check fastPtr.next!=null
 * <p>
 * Refactored  while (slowPtr != null && fastPtr != null && fastPtr.next != null)
 * to  while (fastPtr != null && fastPtr.next != null)
 */
