package BeakJoon.DP;

import BeakJoon.CommonReader;

import java.util.HashMap;

public class P9095 {

    public void solve() throws Exception{

        HashMap<Integer, Integer> table = new HashMap<>();
        table.put(1, 1);
        table.put(2, 2);
        table.put(3, 4);

        int cnt = CommonReader.nextInt();
        for(int i=0; i<cnt; i++){
            int tCase = CommonReader.nextInt();

            int isCalc = table.getOrDefault(tCase, -1);
            if(isCalc != -1){
                System.out.println(isCalc);
                continue;
            }

            for(int j=4; j<=tCase; j++){
                int dp = table.get(j-3) + table.get(j-2) + table.get(j-1);
                table.put(j, dp);
            }
            System.out.println(table.get(tCase));
        }
    }
}
