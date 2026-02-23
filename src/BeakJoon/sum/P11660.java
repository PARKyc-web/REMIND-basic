package BeakJoon.sum;

import BeakJoon.CommonReader;

public class P11660 {

    public void solve() throws Exception {
        int N = CommonReader.nextInt();
        int cnt = CommonReader.nextInt();

        int[][] numbers = new int[N+1][N+1];
        long[][] sumRow = new long[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                numbers[i][j] = CommonReader.nextInt();
                sumRow[i][j] = sumRow[i][j-1] + numbers[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt; i++){
            int x1 = CommonReader.nextInt();
            int y1 = CommonReader.nextInt();
            int x2 = CommonReader.nextInt();
            int y2 = CommonReader.nextInt();

            long result = 0;
            for(int k=x1; k<=x2; k++){
                result += (sumRow[k][y2] - sumRow[k][y1-1]);
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
