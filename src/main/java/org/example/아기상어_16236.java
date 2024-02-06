// D
package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Map{
    int r,c;
    int move;
    int size;
    int eat;
    int[][] arr;
    Map(int move,int r,int c,int size,int eat,int[][] arr){
        this.move=move;
        this.r=r;
        this.c=c;
        this.eat=eat;
        this.size=size;
        this.arr=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                this.arr[i][j]=arr[i][j];
            }
        }
    }
}
public class 아기상어_16236 {
    static int N;
    static int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        Queue<Map> q= new LinkedList<>();
        N=sc.nextInt();
        int[][] arr=new int[N][N];
        int r=0,c=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==9){
                    r=i;
                    c=j;
                }
            }
        }

        q.offer(new Map(0,r,c,2,0,arr));
        while(!q.isEmpty()){
            Map now=q.poll();
            for(int i=0;i<4;i++){
                int nextR=now.r+dir[i][0];
                int nextC=now.c+dir[i][1];
                if(nextR>=0 && nextR<N && nextC>=0 && nextC<N){
                    if(now.arr[nextR][nextC]==0){

                    }else if(now.arr[nextR][nextC]==)
                }
            }
        }

        dfs(0,0);

    }

    static void dfs(int index,int depth){



    }
}

