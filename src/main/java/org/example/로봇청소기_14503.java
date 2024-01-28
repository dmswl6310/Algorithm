// 50
package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class 로봇청소기_14503 {

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        int r=sc.nextInt();
        int c= sc.nextInt();
        int d=sc.nextInt();

        int[][] move={{-1,0},{0,1},{1,0},{0,-1}};

        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int result=0;

        while(arr[r][c]!=1){
            // 1. 현재칸 청소
            if(arr[r][c]==0){
                arr[r][c]=2;
                result++;
            }
            // 2. 4칸중 청소되지 않은 빈칸 X
            if(arr[r+move[0][0]][c+move[0][1]]!=0 && arr[r+move[1][0]][c+move[1][1]]!=0 && arr[r+move[2][0]][c+move[2][1]]!=0 && arr[r+move[3][0]][c+move[3][1]]!=0){
                r-=move[d][0];
                c-=move[d][1];
            }
            // 3. 4칸중 청소되지 않은 빈칸 O
            else{
                do {
                    d = (d + 3) % 4;
                }while(arr[r+move[d][0]][c+move[d][1]]!=0);
                r+=move[d][0];
                c+=move[d][1];
            }
        }
        System.out.println(result);
    }
}
