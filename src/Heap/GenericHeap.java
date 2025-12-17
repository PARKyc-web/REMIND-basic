package Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic을 사용한 Heap.
 *
 * @param <T>
 */
public class GenericHeap <T extends Comparable<? super T>> {

    private List<T> heap;
    private HeapOrder order;

    public GenericHeap(HeapOrder order){
        this.heap = new ArrayList<>();
        this.order = order;
    }

    public void add(T node){
        heap.add(node);
        siftUp(heap.size()-1);
    }
    public T peek(){
        return (!heap.isEmpty()) ? heap.get(0) : null;
    }
    public T poll(){
        if(heap.isEmpty()){
            return null;
        }

        T poll = heap.get(0);
        int last = heap.size()-1;
        if(last < 1) { // heap의 갯수가 1개 이하라면 (시프트 다운을 안해도 됨)
            return poll;
        }

        swapNode(0, last);
        heap.remove(last);
        siftDown(0);

        return poll;
    }

    private void siftUp(int index){
        // compareTo => 양수 : 크다, 0 : 같다, 음수 : 작다
        int i = index;
        while(i > 0){
            int parent = (i - 1)/2;

            boolean needSwap = shouldSwap(parent, i);
            if(!needSwap){
                return ;
            }

            swapNode(parent, i);
            i = parent;
        }
    }
    private void siftDown(int index){
        int i = index;
        while(i < heap.size()-1){
            int left = (i*2)+1;


        }
    }
    private void swapNode(int p, int c){
        T temp = heap.get(p);
        heap.set(p, heap.get(c));
        heap.set(c, temp);
    }
    private boolean shouldSwap(int p, int c){
        return (order == HeapOrder.ASC) ? heap.get(p).compareTo(heap.get(c)) > 0
                                        : heap.get(p).compareTo(heap.get(c)) < 0;
    }

    public void printHeap() {
        System.out.println("Heap (" + order + ") = " + heap);
    }
    public void printHeapByLevel() {
        if (heap == null || heap.isEmpty()) {
            System.out.println("Heap (" + order + ") is empty.");
            return;
        }

        System.out.println("Heap (" + order + ") by level:");
        int levelStart = 0;
        int levelSize = 1;

        while (levelStart < heap.size()) {
            int levelEnd = Math.min(levelStart + levelSize, heap.size());

            StringBuilder sb = new StringBuilder();
            sb.append("L").append((int)(Math.log(levelSize) / Math.log(2))).append(": ");

            for (int i = levelStart; i < levelEnd; i++) {
                sb.append(heap.get(i));
                if (i < levelEnd - 1) sb.append(" ");
            }
            System.out.println(sb);

            levelStart = levelEnd;
            levelSize *= 2;
        }
    }
}
