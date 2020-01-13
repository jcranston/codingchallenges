package main.java.com.codingchallenges.data_structures;

public class MinBinaryHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;

    public MinBinaryHeap(T[] elems) {
        throw new UnsupportedOperationException();
    }

    public MinBinaryHeap(int capaity) {
        this.size = 0;
        this.heap = (T[]) new Comparable[capaity];
    }

    public int getSize() {
        return size;
    }

    public void insert(T elem) {
        // dynamically reallocate underlying array if there is not enough room
        if (size == heap.length) {
            T[] newHeap = (T[]) new Comparable[size == 0 ? 1 : size * 2]; // double the size
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
        // insert element at end of the array
        heap[size] = elem;
        size++;
        heapifyUp(size - 1);
    }

    public T delete(int idx) {
        if (idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException("idx = " + idx + ", size = " + size);
        }
        T retVal = heap[idx];

        // replace heap[idx] with the last element in the heap
        heap[idx] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        // if we're at the root or greater than our parent, then heapify down
        if (idx == 0 || heap[idx].compareTo(heap[parentIdx(idx)]) > 0) {
            heapifyDown(idx);
        } else {
            heapifyUp(idx);
        }
        return retVal;
    }

    public void decreaseKey(int idx, T elem) {
        if (elem.compareTo(heap[idx]) > 0) {
            throw new RuntimeException(elem + " > " + heap[idx]);
        }
        heap[idx] = elem;
        heapifyUp(idx);
    }

    public T peekMin() {
        if (size <= 0) {
            throw new RuntimeException("size = " + size);
        }
        return heap[0];
    }

    public T extractMin() {
        if (size <= 0) {
            throw new RuntimeException("size = " + size);
        }
        T min = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null; // not necessary to be functional
        size--;
        if (size > 0) {
            heapifyDown(0);
        }
        return min;
    }

    public void clear() {
        size = 0;
    }

    public T[] getUnderlyingHeap() {
        return heap; // useful for assertions in testing
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) { // useful for assertions in testing
            throw new ArrayIndexOutOfBoundsException("idx = " + idx + ", size = " + size);
        }
        return heap[idx];
    }

    private void heapifyUp(int idx) {
        // while the parent is greater than the child, swap the parent and the child
        while (idx > 0 && heap[parentIdx(idx)].compareTo(heap[idx]) > 0) {
            int parentIdx = parentIdx(idx);
            swap(idx, parentIdx);
            idx = parentIdx;
        }
    }

    private void heapifyDown(int idx) {
        while (hasAtLeastOneChild(idx)) {
            int leftChildIdx = leftChildIdx(idx);
            int rightChildIdx = rightChildIdx(idx);

            if (hasTwoChildren(idx)) {
                // if parent is <= both children, it is in the right spot
                if (heap[idx].compareTo(heap[leftChildIdx]) <= 0 && heap[idx].compareTo(heap[rightChildIdx]) <= 0) {
                    break;
                }
                // replace parent with smaller child node
                if (heap[leftChildIdx].compareTo(heap[rightChildIdx]) < 0) {
                    swap(idx, leftChildIdx);
                    idx = leftChildIdx;
                } else {
                    swap(idx, rightChildIdx);
                    idx = rightChildIdx;
                }

            // has only 1 child, and it will be the left child
            } else {
                // if parent is smaller than or equal to its child, it is in the right spot
                if (heap[idx].compareTo(heap[leftChildIdx]) <= 0) {
                    break;
                } else {
                    swap(idx, leftChildIdx);
                    idx = leftChildIdx;
                }
            }
        }
    }

    private void swap(int idx1, int idx2) {
        if (idx1 < 0 || idx2 < 0 || idx1 >= size || idx2 >= size) {
            throw new ArrayIndexOutOfBoundsException("idx1 = " + idx1 + ", idx2 = " + idx2 + ", size = " + size);
        }
        T tmp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = tmp;
    }

    private int parentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private int leftChildIdx(int parentIdx) {
        return parentIdx * 2 + 1;
    }

    private int rightChildIdx(int parentIdx) {
        return parentIdx * 2 + 2;
    }

    private boolean hasAtLeastOneChild(int parentIdx) {
        return leftChildIdx(parentIdx) < size; // no need to check right child for looking for at least one child
    }

    private boolean hasTwoChildren(int parentIdx) {
        return rightChildIdx(parentIdx) < size;
    }
}
