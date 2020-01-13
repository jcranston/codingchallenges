package test.java.com.codingchallenges.data_structures;

import main.java.com.codingchallenges.data_structures.MinBinaryHeap;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MinBinaryHeapTest {
    @Test
    public void testSingleInsert() {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(0);
        assertArrayEquals(heap.getUnderlyingHeap(), new Integer[]{});
        assertEquals(0, heap.getSize());
        heap.insert(3);
        assertEquals(1, heap.getSize());
        assertArrayEquals(new Integer[]{3}, heap.getUnderlyingHeap());
        assertEquals(new Integer(3), heap.extractMin());
        assertEquals(0, heap.getSize());
    }

    @Test
    public void testHeapifyUpOneChild() {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(2);
        heap.insert(10);
        heap.insert(7);
        assertEquals(2, heap.getSize());
        assertEquals(new Integer(7), heap.peekMin());
        assertArrayEquals(new Integer[]{7, 10}, heap.getUnderlyingHeap());
    }

    @Test
    public void testHeapifyUpTwoChildren() {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(2);
        heap.insert(10);
        heap.insert(7);
        heap.insert(5);
        assertEquals(3, heap.getSize());
        assertEquals(new Integer(5), heap.peekMin());
        assertArrayEquals(new Integer[]{5, 10, 7, null}, heap.getUnderlyingHeap());
    }

    @Test
    public void testHeapifyDownOneChild() {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(2);
        heap.insert(10);
        heap.insert(7);
        heap.delete(0);
        assertArrayEquals(new Integer[]{10, null}, heap.getUnderlyingHeap());
        assertEquals(new Integer(10), heap.peekMin());
        assertEquals(1, heap.getSize());
    }

    @Test
    public void testHeapifyDownTwoChildren() {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(2);
        heap.insert(10);
        heap.insert(7);
        heap.insert(5);
        heap.delete(0);
        assertEquals(new Integer(7), heap.peekMin());
        assertEquals(2, heap.getSize());
        assertEquals(new Integer(10), heap.get(1));
        assertArrayEquals(new Integer[]{7, 10, null, null}, heap.getUnderlyingHeap());
    }

    @Test
    public void testConstructSmallBinaryHeap() {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(0);
        heap.insert(5);
        heap.insert(7);
        heap.insert(6);
        heap.insert(12);
        assertEquals(new Integer(5), heap.peekMin());
        assertEquals(4, heap.getSize());
        assertArrayEquals(new Integer[]{5, 7, 6, 12}, heap.getUnderlyingHeap());
        heap.insert(10);
        heap.insert(1);
        assertEquals(new Integer(1), heap.peekMin());
        assertEquals(6, heap.getSize());
        assertArrayEquals(new Integer[]{1, 7, 5, 12, 10, 6, null, null}, heap.getUnderlyingHeap());
    }

    @Test
    public void testExtractMinSmallBinaryTree() {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(0);
        insertSixElements(heap);
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(5, heap.getSize());
        assertArrayEquals(new Integer[]{5, 7, 6, 12, 10, null, null, null}, heap.getUnderlyingHeap());
        assertEquals(new Integer(5), heap.extractMin());
        assertEquals(4, heap.getSize());
        assertArrayEquals(new Integer[]{6, 7, 10, 12, null, null, null, null}, heap.getUnderlyingHeap());
        assertEquals(new Integer(6), heap.extractMin());
        assertEquals(3, heap.getSize());
        assertArrayEquals(new Integer[]{7, 12, 10, null, null, null, null, null}, heap.getUnderlyingHeap());
        assertEquals(new Integer(7), heap.extractMin());
        assertEquals(2, heap.getSize());
        assertArrayEquals(new Integer[]{10, 12, null, null, null, null, null, null}, heap.getUnderlyingHeap());
        assertEquals(new Integer(10), heap.extractMin());
        assertEquals(1, heap.getSize());
        assertArrayEquals(new Integer[]{12, null, null, null, null, null, null, null}, heap.getUnderlyingHeap());
        assertEquals(new Integer(12), heap.extractMin());
        assertEquals(0, heap.getSize());
        assertArrayEquals(new Integer[]{null, null, null, null, null, null, null, null}, heap.getUnderlyingHeap());
    }

    private static void insertSixElements(MinBinaryHeap<Integer> heap) {
        Arrays.asList(5, 7, 6, 12, 10, 1).stream().forEach(elem -> heap.insert(elem));
    }
}