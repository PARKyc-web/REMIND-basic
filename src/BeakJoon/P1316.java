package BeakJoon;

import java.util.HashMap;

public class P1316 {

    public void solve() throws Exception {

        int cnt = CommonReader.nextInt();
        HashMap<Character, Integer> checker = new HashMap<>();

        int result = 0;
        for(int i=0; i<cnt; i++){
            boolean flag = true;
            String word = CommonReader.nextString();

            if(word.length() == 1){
                result++;
                continue;
            }

            checker.put(word.charAt(0), 1);
            for(int j=1; j<word.length(); j++){
                char prev = word.charAt(j-1);
                char cur = word.charAt(j);

                if(prev != cur){
                    int isDup = checker.getOrDefault(cur, 0);
                    if(isDup == 0){
                        checker.put(cur, 1);
                    } else {
                        checker.put(cur, 1);
                        flag = false;
                        break;
                    }
                }
                /* 마지막 단어 체크
                if(j == word.length()-1) {
                    int last = checker.getOrDefault(cur, 0);
                    if(last != 0){
                        flag = false;
                    }
                }
                */
            }

            if(flag){
                result++;
            }
            checker = new HashMap<>();
        }

        System.out.print(result);
    }
}
