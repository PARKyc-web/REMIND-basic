package BeakJoon.basic;

import BeakJoon.CommonReader;

public class P23971 {

    public void solve() throws Exception {
        int H = CommonReader.nextInt();
        int W = CommonReader.nextInt();
        int N = CommonReader.nextInt();
        int M = CommonReader.nextInt();

        int result = 0;
        for(int i=0; i<W; i=i+M+1){
            for(int j=0; j<H; j=j+N+1){
                result++;
            }
        }

        System.out.print(result);
    }
}
