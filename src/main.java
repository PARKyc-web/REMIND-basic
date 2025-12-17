import Heap.GenericHeap;
import Heap.HeapOrder;
import Heap.IntegerHeap;

public class main {
    public static void main(String[] args){

        GenericHeap<Integer> heap = new GenericHeap<>(HeapOrder.ASC);
        heap.add(1);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(0);
        heap.add(-2);

        heap.printHeapByLevel();
    }
}
