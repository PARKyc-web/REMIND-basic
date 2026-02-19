package BeakJoon.basic;

import BeakJoon.CommonReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P1874 {

    public void solve() throws Exception {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        int cnt = CommonReader.nextInt();
        for(int i=0; i<cnt; i++){
            int num = CommonReader.nextInt();
            queue.add(num);
        }

        StringBuilder sb = new StringBuilder();
        int cur = 1;
        while(!queue.isEmpty()){
            int goal = queue.poll();
            int top = stack.isEmpty() ? -1 : stack.peek();
            if(goal > top){
                for(int i=0; goal >= cur; cur++){
                    stack.push(cur);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else if(goal == top){
                stack.pop();
                sb.append("-\n");
            } else {
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
        }

        System.out.print(sb.toString());
    }

}
