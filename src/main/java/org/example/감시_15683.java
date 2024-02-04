// D
package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pair{
    int r,c;
    Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}
public class 감시_15683 {
    static List<Pair> cctv;
    static int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    static int N;
    static int M;
    static int min=Integer.MAX_VALUE;
    static int[][] makeArr(int[][] arr){
        int[][] brr=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                brr[i][j]=arr[i][j];
            }
        }
        return brr;
    }

    static void watch(int[][] arr, int d, int r, int c){
        int rr=r+dir[d][0];
        int cc=c+dir[d][1];
        while(rr>=0 && cc>=0 && rr<N && cc<M &&(arr[rr][cc]!=6)) {
            if (arr[rr][cc] == 0) {
                arr[rr][cc]=-1;
            }
            rr+=dir[d][0];
            cc+=dir[d][1];
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        int[][] arr=new int[N][M];
        cctv=new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]!=0 && arr[i][j]!=6){
                    cctv.add(new Pair(i,j));
                }
            }
        }

        DFS(0,arr);
        System.out.println(min);
    }
    static void DFS(int depth, int[][] arr){
        if(depth==cctv.size()){
            int count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j]==0){
                        count++;
                    }
                }
            }
            if(count<min) min=count;
            return;
        }

        int r=cctv.get(depth).r;
        int c= cctv.get(depth).c;

        switch(arr[r][c]){
            case 1:
                for(int i=0;i<4;i++){
                    int[][] brr=makeArr(arr);
                    watch(brr,i,r,c);
                    DFS(depth+1,brr);
                }
                break;
            case 2:
                for(int i=0;i<2;i++) {
                    int[][] brr = makeArr(arr);
                    watch(brr, i, r, c);
                    watch(brr, i+2, r, c);
                    DFS(depth + 1, brr);
                }
                break;
            case 3:
                for(int i=0;i<3;i++){
                    int[][] brr = makeArr(arr);
                    watch(brr, i, r, c);
                    watch(brr, i+1, r, c);
                    DFS(depth + 1, brr);
                }

                int[][] brr= makeArr(arr);
                watch(brr, 3, r, c);
                watch(brr, 0, r, c);
                DFS(depth + 1, brr);
                break;

            case 4:
                for(int i=0;i<4;i++){
                    int[][] crr = makeArr(arr);
                    for(int j=0;j<4;j++){
                        if(j!=i) {
                            watch(crr, j, r, c);
                        }
                    }
                    DFS(depth + 1, crr);
                }
                break;

            case 5:
                int[][] drr=makeArr(arr);
                for(int j=0;j<4;j++){
                   watch(drr, j, r, c);
                }
                DFS(depth+1,drr);
                break;
        }
    }
}
