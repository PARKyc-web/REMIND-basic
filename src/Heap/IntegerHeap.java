package Heap;

import java.util.ArrayList;
import java.util.List;

public class IntegerHeap {

    private List<Integer> heap;
    private HeapOrder order;

    /* Construct */
    public IntegerHeap(HeapOrder order) {
        this.heap = new ArrayList<>();
        this.order = order;
    }

    /* Test Method */
    public void initForTest(){
        this.addNode(1);
        this.addNode(3);
        this.addNode(7);
        this.addNode(9);
        this.addNode(11);
        this.addNode(9);
        this.addNode(4);
        this.addNode(3);
        this.addNode(-1);
        this.addNode(-9);
        this.addNode(0);
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


    /* Heap Method */
    public void addNode(Integer node){
        this.heap.add(node);
        this.sortNode(this.heap.size()-1);
    }
    public Integer peek(){
        return (!this.heap.isEmpty()) ? this.heap.get(0) : null;
    }
    public Integer poll(){
        if(this.heap.isEmpty()){
            return null;
        }
        int poll = this.heap.get(0);
        int last = this.heap.size() - 1;
        this.heap.set(0, this.heap.get(last));
        this.heap.remove(last);

        siftDown(0);

        return poll;
    }
    private void siftDown(int index){
        int size = this.heap.size();
        if (size <= 1) return;

        int i = index;
        while (true) {
            int left = i * 2 + 1;
            if (left >= size) return; // no children

            int right = left + 1;

            // pick the child to compare with (min child for ASC, max child for DESC)
            int child = left;
            if (right < size) {
                int leftVal = this.heap.get(left);
                int rightVal = this.heap.get(right);
                if (order == HeapOrder.ASC) {
                    if (rightVal < leftVal) child = right;
                } else { // DESC
                    if (rightVal > leftVal) child = right;
                }
            }

            int parentVal = this.heap.get(i);
            int childVal = this.heap.get(child);

            boolean needSwap = (order == HeapOrder.ASC)
                    ? parentVal > childVal
                    : parentVal < childVal;

            if (!needSwap) return;

            // swap parent and chosen child
            this.heap.set(i, childVal);
            this.heap.set(child, parentVal);

            i = child;
        }
    }

    /* SortNode 이런식으로 만드는게 아니라 sift-up, sift-down 이런식으로 메소드를 만들어야겠다. */
    private void sortNode(int index){
        if(index <= 0){
            return;
        }

        int parent = (index - 1) / 2;
        swapNode(index, parent);
    }
    private void swapNode(int index, int parent){
        if(order == HeapOrder.ASC){
            if(heap.get(index) < heap.get(parent)){
                int temp = heap.get(index);
                this.heap.set(index, heap.get(parent));
                this.heap.set(parent, temp);
                sortNode(parent);
            }
        }
        if(order == HeapOrder.DESC){
            if(heap.get(index) > heap.get(parent)){
                int temp = heap.get(index);
                this.heap.set(index, heap.get(parent));
                this.heap.set(parent, temp);
                sortNode(parent);
            }
        }
    }

}
