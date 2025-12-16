import Heap.HeapOrder;
import Heap.IntegerHeap;

public class main {
    public static void main(String[] args){

        IntegerHeap heap = new IntegerHeap(HeapOrder.ASC);
        heap.initForTest();
        heap.printHeapByLevel();

        IntegerHeap heap2 = new IntegerHeap(HeapOrder.DESC);
        heap2.initForTest();
        heap2.printHeapByLevel();
    }
}
