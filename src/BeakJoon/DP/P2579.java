package BeakJoon.DP;

import BeakJoon.CommonReader;

public class P2579 {

    public void solve() throws Exception {

        int cnt = CommonReader.nextInt();

        int[] stair = new int[cnt+1];
        long[] dp = new long[cnt+1];

        stair[0] = 0;
        for(int i=1; i<=cnt; i++){
            stair[i] = CommonReader.nextInt();
        }

        if(cnt < 2){
            System.out.print(stair[1]);
        } else {

            dp[1] = stair[1];
            dp[2] = stair[1] + stair[2];
            for(int i=3; i<=cnt; i++){
                long value1 = dp[i-3] + stair[i-1] + stair[i];
                long value2 = dp[i-2] + stair[i];

                dp[i] = Math.max(value1, value2);
            }

            System.out.print(dp[cnt]);
        }
    }
}
