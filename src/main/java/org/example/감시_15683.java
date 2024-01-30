// D
package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Data{
    int[][] brr;
    Data(int[][] brr){
        this.brr=brr;
    }
}
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

    static Data watch(int[][] arr, int d, int r, int c){
        int[][] brr = makeArr(arr);

        int rr=r+dir[d][0];
        int cc=c+dir[d][1];
        while(rr>=0 && cc>=0 && rr<N && cc<M &&(brr[rr][cc]==0||brr[rr][cc]==-1)){
                brr[rr][cc] = -1;
            }
        return new Data(brr);
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
        if(depth==cctv.size()-1){
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
                    Data data=watch(arr,i,r,c);
                    DFS(depth+1,data.brr);
                }
                break;
            case 2:
                Data data=watch(arr,0,r,c);
                Data data2=watch(data.brr,2,r,c);
                DFS(depth+1,data2.brr);

                Data data3=watch(arr,1,r,c);
                Data data4=watch(data3.brr,3,r,c);
                DFS(depth+1,data4.brr);
                break;
            case 3:
                Data data10=watch(arr,0,r,c);
                Data data11=watch(data10.brr,1,r,c);
                DFS(depth+1,data11.brr);

                Data data12=watch(arr,1,r,c);
                Data data13=watch(data12.brr,2,r,c);
                DFS(depth+1,data13.brr);

                Data data14=watch(arr,2,r,c);
                Data data15=watch(data14.brr,3,r,c);
                DFS(depth+1,data15.brr);

                Data data16=watch(arr,3,r,c);
                Data data17=watch(data16.brr,0,r,c);
                DFS(depth+1,data17.brr);
                break;

            case 4:
                Data data100=watch(arr,0,r,c);
                Data data101=watch(data100.brr,1,r,c);
                Data data102=watch(data101.brr,2,r,c);
                DFS(depth+1,data102.brr);

                Data data200=watch(arr,1,r,c);
                Data data201=watch(data200.brr,2,r,c);
                Data data202=watch(data201.brr,3,r,c);
                DFS(depth+1,data202.brr);

                Data data300=watch(arr,2,r,c);
                Data data301=watch(data300.brr,3,r,c);
                Data data302=watch(data301.brr,0,r,c);
                DFS(depth+1,data302.brr);

                Data data400=watch(arr,1,r,c);
                Data data401=watch(data400.brr,3,r,c);
                Data data402=watch(data401.brr,0,r,c);
                DFS(depth+1,data402.brr);
                break;

            case 5:
                Data data69=watch(arr,0,r,c);
                Data data79=watch(data69.brr,1,r,c);
                Data data89=watch(data79.brr,2,r,c);
                Data data99=watch(data89.brr,3,r,c);
                DFS(depth+1,data99.brr);
                break;

        }
    }
}
