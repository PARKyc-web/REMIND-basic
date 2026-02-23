package BeakJoon.DP;

import BeakJoon.CommonReader;

import java.util.Arrays;

public class P11053 {

    public void solve() throws Exception {
        int cnt = CommonReader.nextInt();

        int[] arr = new int[cnt+1];
        for(int i=1; i<=cnt; i++){
            int num = CommonReader.nextInt();
            arr[i] = num;
        }

        int[] dp = new int[cnt+1];

        arr[0] = 0;
        dp[0] = 0;
        for(int i=1; i<=cnt; i++){
            int maxIdx = 0;

            // 나보다 작지만 제일 큰 값을 구한다.
            for(int j=0; j<i; j++){
                if(arr[i] <= arr[j]){
                    continue;
                }
                if(dp[j] > dp[maxIdx]){
                    maxIdx = j;
                }
            }
            dp[i] = dp[maxIdx]+1;
        }
        Arrays.sort(dp);
        System.out.print(dp[cnt]);
    }
}
