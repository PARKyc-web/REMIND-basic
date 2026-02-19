package BeakJoon.basic;

import BeakJoon.CommonReader;

import java.util.Stack;

/** Problem. 9012
 *
 * [입력데이터]
 *  6
 * (())())
 * (((()())()
 * (()())((()))
 * ((()()(()))(((())))()
 * ()()()()(()()())()
 * (()((())()(
 *
 * [출력데이터]
 * NO
 * NO
 * YES
 * NO
 * YES
 * NO
 */
public class P9012 {

    public void solve() throws Exception{

        int psCnt = CommonReader.nextInt();
        Stack<Character> stack = new Stack<>();

        boolean isVps = true;
        for(int i=0; i<psCnt; i++){
            String ps = CommonReader.nextString();

            for(int j=0; j<ps.length(); j++){
                char c = ps.charAt(j);
                if(c == '('){
                    stack.push(c);
                } else {
                    if(stack.empty()) {
                        isVps = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.empty()){
                isVps = false;
            }

            System.out.println((isVps) ? "YES" : "NO");
            stack.clear();
            isVps = true;
        }
    }

}
