package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class IntegerStack {

    private final List<Integer> data;

    public IntegerStack(){
        this.data = new ArrayList<>();
    }

    public Integer pop() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return data.remove(data.size() - 1);
    }
    public void push(Integer value) {
        data.add(value);
    }
    public Integer peek() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return data.get(data.size() - 1);
    }
    public int size(){
        return data.size();
    }
    public void clear() {
        data.clear();
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
}