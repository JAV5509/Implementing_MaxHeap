import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {
    @Test
    public void testMaxHeap(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.heap.add(12);
        maxHeap.size = 1;
        assertEquals(12, maxHeap.heap.get(0));
    }
    @Test
    public void testHeapifyUp() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.heap.add(11);
        maxHeap.heap.add(5);
        maxHeap.heap.add(8);
        maxHeap.heap.add(3);
        maxHeap.heap.add(4);
        maxHeap.heap.add(15);
        maxHeap.size = 6;

        maxHeap.heapifyUp(5);
        assertEquals(15, maxHeap.heap.get(0));
    }
    @Test
    public void testInsert() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(43);
        assertEquals("[43]", maxHeap.heap.toString());
        maxHeap.insert(44);
        maxHeap.insert(12);
        maxHeap.insert(99);
        maxHeap.insert(33);
        assertEquals("[99, 44, 12, 43, 33]", maxHeap.heap.toString());
    }
    @Test
    public void testHeapifyDown() {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        maxHeap.heap.add(12);
        maxHeap.heap.add(99);
        maxHeap.heap.add(44);
        maxHeap.heap.add(43);
        maxHeap.heap.add(33);
        maxHeap.heap.add(9);

        maxHeap.size = 6;

        maxHeap.heapifyDown(0);
        assertEquals("[99, 43, 44, 12, 33, 9]", maxHeap.heap.toString());

    }
    @Test
    public void testExtract() {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        maxHeap.heap.add(99);
        maxHeap.heap.add(44);
        maxHeap.heap.add(43);
        maxHeap.heap.add(33);
        maxHeap.heap.add(9);
        maxHeap.heap.add(12);

        maxHeap.size = 6;

        assertEquals(99, maxHeap.extract());
        assertEquals("[44, 33, 43, 12, 9]", maxHeap.heap.toString());
        assertEquals(44, maxHeap.extract());
        assertEquals(43, maxHeap.extract());
        assertEquals(33, maxHeap.extract());
        assertEquals(12, maxHeap.extract());
        assertEquals(9, maxHeap.extract());
        assertEquals(null, maxHeap.extract());
    }

    @Test
    public void testMaxHeapSort(){

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        Integer[] arrToSort = {43,12,76,99,1000,2};
        arrToSort = maxHeap.MaxHeapSort((arrToSort));


        assertEquals("[2, 12, 43, 76, 99, 1000]", Arrays.toString(arrToSort));
    }

}