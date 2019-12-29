package test.java.com.codingchallenges.cci_ch2_linkedlists;

import static org.junit.Assert.*;
import main.java.com.codingchallenges.cci_ch2_linkedlists.RemoveDupes;
import main.java.com.codingchallenges.common.LinkedListNode;
import org.junit.Test;

public class RemoveDupesTest {
    /**
     * 1 -> 3 -> 1 -> 2 -> 3 becomes 1 -> 3 -> 2 -> null
     */
    @Test
    public void testRemovesDupes() {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>().linkedListWithValues(1, 3, 1, 2, 3);

        RemoveDupes.removeDupes(head);

        LinkedListNode current = head;
        assertEquals(current.data, 1);
        current = current.next;
        assertEquals(current.data, 3);
        current = current.next;
        assertEquals(current.data, 2);
        assertNull(current.next);
    }

    @Test
    public void testDoesNotRemoveDupes() {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>().linkedListWithValues(1, 2, 3);

        RemoveDupes.removeDupes(head);

        LinkedListNode current = head;
        assertEquals(current.data, 1);
        current = current.next;
        assertEquals(current.data, 2);
        current = current.next;
        assertEquals(current.data, 3);
        assertNull(current.next);
    }
}
