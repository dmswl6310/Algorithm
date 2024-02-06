// D
package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 치킨배달_15686 {

    static class Point{
        int r,c;
        Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    static int N;
    static int M;
    static int min=Integer.MAX_VALUE;
    static List<Point> chicken;

    int countLeng(int r,int c,int cr,int cc){
        return Math.abs(r-cr)+Math.abs(c-cc);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int[][] arr=new int[N][N];
        chicken=new ArrayList<>();


        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==2){
                    chicken.add(new Point(i,j));
                }
            }
        }

        dfs(0,0);

    }

    static void dfs(int index,int depth){
        Point point=chicken.get(index);


    }
}

