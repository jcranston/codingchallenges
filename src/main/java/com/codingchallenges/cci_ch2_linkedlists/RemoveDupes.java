package main.java.com.codingchallenges.cci_ch2_linkedlists;

import main.java.com.codingchallenges.common.LinkedListNode;

public abstract class RemoveDupes {
    public static void removeDupes(LinkedListNode head) {
        LinkedListNode current = head;

        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}