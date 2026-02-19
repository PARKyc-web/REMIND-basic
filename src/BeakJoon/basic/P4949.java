package BeakJoon.basic;


import BeakJoon.CommonReader;

import java.util.Stack;

public class P4949 {

    public void solve() throws Exception {

        Stack<Character> stack = new Stack<>();
        while(true){
            String sentence = CommonReader.nextLine();

            if(".".equals(sentence)){
                break;
            }
            boolean isValid = true;
            for(int i=0; i<sentence.length(); i++){
                char c = sentence.charAt(i);
                if(c == '(' || c == '['){
                    stack.push(c);
                }

                if(c == ')' || c == ']'){
                    if(stack.empty()){
                        isValid = false;
                        break;
                    }

                   char pop = stack.pop();
                   if(c == ')'){
                       if(pop != '('){
                           isValid = false;
                           break;
                       }
                   } else if(pop != '['){
                        isValid = false;
                        break;
                   }
                }
            }
            if(!stack.empty()){
                isValid = false;
            }

            System.out.println((isValid) ? "yes" : "no");
            stack.clear();
        }


    }
}
