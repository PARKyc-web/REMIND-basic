package BeakJoon.basic;

import BeakJoon.CommonReader;

import java.util.HashMap;

public class P10816 {

    public void solve() throws Exception{

        HashMap<Integer, Integer> cardMap = new HashMap<>();

        int cardCnt = CommonReader.nextInt();
        for(int i=0; i<cardCnt; i++){
            int card = CommonReader.nextInt();
            int cardNum = cardMap.getOrDefault(card, 0);

            cardMap.put(card, ++cardNum);
        }

        int checkCnt = CommonReader.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<checkCnt; i++){
            int check = CommonReader.nextInt();

            sb.append(cardMap.getOrDefault(check, 0));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
