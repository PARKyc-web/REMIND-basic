package BeakJoon;

import java.util.Stack;

public class P10773 {

    public void solve() throws Exception{

        Stack<Integer> numbers = new Stack<>();
        int cnt = CommonReader.nextInt();
        for(int i=0; i<cnt; i++){
            int num = CommonReader.nextInt();
            if(num == 0 && !numbers.empty()){
                numbers.pop();
            } else if(num != 0){
                numbers.push(num);
            }
        }

        int result = 0;
        while(!numbers.empty()){
            result += numbers.pop();
        }

        System.out.print(result);
    }
}
