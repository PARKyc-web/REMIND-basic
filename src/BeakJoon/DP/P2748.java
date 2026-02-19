package BeakJoon.DP;

import BeakJoon.CommonReader;

public class P2748 {

    public void solve() throws Exception{
        int n = CommonReader.nextInt();

        long[] arr = new long[n+1];
        arr[0] = 0; // 0번째
        arr[1] = 1; // 첫번째

        for(int i=2; i<=n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }

        System.out.print(arr[n]);
    }

}
