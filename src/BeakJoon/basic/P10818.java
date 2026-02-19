package BeakJoon.basic;

import BeakJoon.CommonReader;

import java.util.Arrays;

/** Problem. 10818
 * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 *
 * [입력데이터]
 * 5
 * 20 10 35 30 7
 *
 * [출력데이터]
 * 7 35
 */
public class P10818 {

    public void solve() throws Exception{

        int total = CommonReader.nextInt();
        int[] arr = new int[total];

        for(int i=0; i<total; i++){
            int num = CommonReader.nextInt();
            arr[i] = num;
        }

        Arrays.sort(arr);

        System.out.print(arr[0]+" ");
        System.out.print(arr[total-1]);
    }
}
