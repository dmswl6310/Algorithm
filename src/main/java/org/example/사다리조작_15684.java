// D
package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
class Point{
    int r,c;
    Point(int r,int c){
        this.r=r;
        this.c=c;
    }
}

class Ladder{
    int index;
    int depth;
    int [][]arr;
    Ladder(int index,int depth,int[][] arr){
        this.index=index;
        this.depth=depth;
        this.arr=arr;
    }
}

public class 사다리조작_15684 {

    static int N;
    static int M;
    static int H;
    static int min = 3000000;
    static List<Point> place;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        int[][] arr = new int[H][N];
        place = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a - 1][b - 1] = 1;
            arr[a - 1][b] = -1;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j]==0 && arr[i][j + 1]==0) {
                    place.add(new Point(i, j));
                }
            }
        }

        Comparator<Ladder> comparator = new Comparator<>() {
            @Override
            public int compare(Ladder o1, Ladder o2) {
                if(o1.depth==o2.depth) {
                    return o1.index - o2.index;
                }else{
                    return o1.depth  - o2.depth;
                }
            }
        };

        PriorityQueue<Ladder> pq=new PriorityQueue<>(comparator);
        pq.offer(new Ladder(0,0,arr));
//        dfs(0, 0, arr);
        while(!pq.isEmpty()){
            Ladder ladder=pq.poll();
            if(ladder.index>=place.size()){
                continue;
            }
            if(ladder.depth > 3 ){
                System.out.println(-1);
                return;
            }
            if (isCorrect(arr)) {
                min=ladder.depth;
                System.out.println(ladder.depth);
                return;
            }

            Point p = place.get(ladder.index);
            if (arr[p.r][p.c]==0 && arr[p.r][p.c + 1]==0) {
                int[][] brr=makeArr(arr);
                brr[p.r][p.c] = 1;
                brr[p.r][p.c + 1] = -1;
                pq.offer(new Ladder(ladder.index + 1, ladder.depth + 1, brr));
            }
            pq.offer(new Ladder(ladder.index + 1, ladder.depth, arr));
        }
    }

//    static void dfs(int index, int depth, int[][] arr) {
//        if(depth > 3 || index>=place.size()||depth>=min){
//            return;
//        }
//        if (isCorrect(arr)) {
//            min=depth;
//            return;
//        }
//
//        Point p = place.get(index);
//        if (arr[p.r][p.c]==0 && arr[p.r][p.c + 1]==0) {
//            int[][] brr=makeArr(arr);
//            brr[p.r][p.c] = 1;
//            brr[p.r][p.c + 1] = -1;
//            dfs(index + 1, depth + 1, brr);
//        }
//        dfs(index + 1, depth, arr);
//
//    }

    static boolean isCorrect(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int r = 0;
            int c = i;
            while (true) {
                if (r == H) {
                    if (c != i) {
                        return false;
                    }
                    break;
                }
                if (c < N - 1 && arr[r][c]==1 && arr[r][c + 1]==-1) {
                    c += 1;
                } else if (c > 0 && arr[r][c]==-1 && arr[r][c - 1]==1) {
                    c -= 1;
                }
                r += 1;
            }
        }
        return true;
    }

    static int[][] makeArr(int[][] arr) {
        int[][] brr = new int[H][N];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                brr[i][j]=arr[i][j];
            }
        }
        return brr;
    }
}

