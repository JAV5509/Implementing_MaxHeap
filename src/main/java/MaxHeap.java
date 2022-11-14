import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
    protected ArrayList<T> heap;
    protected int size;

    public MaxHeap(){
        this.heap = new ArrayList<T>();
        this.size = 0;
    }
    protected void heapifyUp(int index) {
        if (this.size == 0) System.out.println("Empty Heap");
        else {
            int parentIndex = (int) Math.floor((index - 1) / 2);
            T parent = this.heap.get(parentIndex);
            T child = this.heap.get(index);
            if (parent.compareTo(child) < 0) {
                this.heap.set(parentIndex, child);
                this.heap.set(index, parent);
                this.heapifyUp(parentIndex);
            }
        }
    }

    public void insert(T data){
        this.heap.add(data);
        this.size = this.size+1;
        if(size>1) this.heapifyUp(this.size-1);
    }

    public void heapifyDown(int index){
        int leftChildIndex = 2*index + 1;
        int rightChildIndex = 2*index + 2;
        int maxIndex = index;
        if((leftChildIndex < this.size) && (this.heap.get(leftChildIndex).compareTo(this.heap.get(maxIndex)) > 0)){
            maxIndex = leftChildIndex;
            }
        if((rightChildIndex < this.size) && (this.heap.get(rightChildIndex).compareTo(this.heap.get(maxIndex)) > 0)){
            maxIndex = rightChildIndex;
            }
        if(maxIndex != index){
            T temp = this.heap.get(index);
            this.heap.set(index, this.heap.get(maxIndex));
            this.heap.set(maxIndex, temp);
            this.heapifyDown(maxIndex);
            }
        }
    public T extract() {
        if (this.size > 0) {
            T temp = this.heap.get(0);
            this.heap.set(0, this.heap.get(this.size - 1));
            this.heap.remove(this.size - 1);
            this.size = this.size - 1;
            if (this.size > 1) {
                this.heapifyDown(0);
            }
            return temp;
        }
        else {
            System.out.println("Empty Heap");
            return null;
            }

        }

        public T[] MaxHeapSort(T[] arrayToSort){
        int arraySize = arrayToSort.length;
        if(arraySize==0)
            System.out.println("Empty Input Set");
        else {
            for(int i = 0; i< arraySize; i++)
                this.insert(arrayToSort[i]);
            for (int i=arraySize-1; i>=0;i--)
                arrayToSort[i]=this.extract();
        }

        return arrayToSort;
        }



    }
