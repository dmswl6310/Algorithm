// C
package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 연산자끼워넣기_14888 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] oper = new int[4];
    static int[] num ;
    static int operate(int op, int now, int next) {
        switch (op) {
            case 0:
                return now + next;
            case 1:
                return now - next;
            case 2:
                return now * next;
            case 3:
                if (now < 0) {
                    return -(-now / next);
                } else {
                    return now / next;
                }
        }
        return 0;
    }

    static void dfs(int result, int depth){
     if(depth==n){
        max=Math.max(max,result);
        min=Math.min(min,result);
        return;
     }

     for(int i=0;i<4;i++){
         if(oper[i]>0) {
             oper[i]--;
         dfs(operate(i,result,num[depth]),depth+1);
            oper[i]++;
         }
     }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        num= new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            oper[i] = sc.nextInt();
        }

        dfs(num[0],1);
        System.out.println(max);
        System.out.println(min);
    }
}
