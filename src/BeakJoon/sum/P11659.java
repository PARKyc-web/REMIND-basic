package BeakJoon.sum;

import BeakJoon.CommonReader;

public class P11659 {

    public void solve() throws Exception{
        int N = CommonReader.nextInt();
        int M = CommonReader.nextInt();

        int[] numbers = new int[N+1];
        long[] sum = new long[N+1];

        numbers[0] = 0;
        sum[0] = 0;
        for(int i=1; i<=N; i++){
            numbers[i] = CommonReader.nextInt();
            sum[i] = sum[i-1] + numbers[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            long result = 0;
            int start = CommonReader.nextInt();
            int end = CommonReader.nextInt();

            result = sum[end] - sum[start-1];
            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
