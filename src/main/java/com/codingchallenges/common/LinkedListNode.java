package main.java.com.codingchallenges.common;

import org.jetbrains.annotations.NotNull;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode() {}

    // not a fan of this, would like to create a wrapper LinkedList class
    // but this will do for now
    public LinkedListNode<T> linkedListWithValues(@NotNull T... values) {
        LinkedListNode<T> head = null;
        for (T value : values) {
            if (head == null) {
                head = new LinkedListNode<>(value);
            } else {
                head.appendToTail(value);
            }
        }
        return head;
    }

    public void appendToTail(T data) {
        LinkedListNode end = new LinkedListNode(data);
        LinkedListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
