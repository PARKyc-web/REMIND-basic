package BeakJoon.basic;

import BeakJoon.CommonReader;

import java.util.Arrays;

public class P5073 {

    public void solve() throws Exception{

        while(true){
            int x = CommonReader.nextInt();
            int y = CommonReader.nextInt();
            int z = CommonReader.nextInt();

            if(x == 0 && y == 0 && z == 0){
                break;
            }

            if(x == y && y == z){
                System.out.println("Equilateral");
                continue;
            }

            int[] arr = {x, y, z};
            Arrays.sort(arr);

            if(arr[0] + arr[1] <= arr[2]){
                System.out.println("Invalid");
            } else if(arr[0] == arr[1] || arr[1] == arr [2]){
                System.out.println("Isosceles");
            } else if(x != y && x != z && y != z){
                System.out.println("Scalene");
            }
        }
    }
}
