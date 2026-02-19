package BeakJoon.DP;

import BeakJoon.CommonReader;

import java.util.HashMap;

public class P1463 {

    public void solve() throws Exception {
        long x = CommonReader.nextLong();

        HashMap<Long, Long> table = new HashMap<>();
        table.put(1L, 0L);
        table.put(2L, 1L);
        table.put(3L, 1L);

        if(x < 3L){
            System.out.print(table.get(x));
        } else {
            for(long i=4; i<=x; i++){
                long min = Long.MAX_VALUE;
                long d3 = Long.MAX_VALUE, d2 = Long.MAX_VALUE, m1 = Long.MAX_VALUE;

                if(i%3 == 0){
                    d3 = table.get(i/3L)+1;
                }
                if(i%2 == 0){
                    d2 = table.get(i/2L)+1;
                }
                m1 = table.get(i-1L)+1;

                min = Math.min(Math.min(d3, d2), m1);
                table.put(i, min);
            }

            System.out.print(table.get(x));
        }
    }
}
