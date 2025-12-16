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

        Integer poll = this.heap.get(0);
        this.heap.remove(0);

        if(this.heap.isEmpty()){
            return poll;
        }
        if(this.heap.size() < 2){
            this.heap.set(0, this.heap.get(1));
            this.heap.remove(1);

            return poll;
        }

        int left = this.heap.get(1);
        int right = this.heap.get(2);

        if(this.order == HeapOrder.ASC){

        }

        if(this.order == HeapOrder.DESC){

        }

        return poll;
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
