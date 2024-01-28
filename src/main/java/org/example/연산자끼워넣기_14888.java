package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

class Pair{
    int x,y,z;
    Pair(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
}

public class 연산자끼워넣기_14888 {

    static int operate(int op, int now, int next) {
        switch (op) {
            case 0:
                return now + next;
            case 1:
                return now - next;
            case 2:
                return now * next;
            case 3:
                if (now <= 0) {
                    return -(now / next);
                } else {
                    return now / next;
                }
        }
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        int[] oper = new int[4];
        for (int i = 0; i < 4; i++) {
            oper[i] = sc.nextInt();
        }
        oper[0]++;

        int max = -1000000000;
        int min = 1000000000;
//        boolean[] visited=new boolean[n];

        Stack<Pair> stack = new Stack<Pair>();

        stack.push(new Pair(0, 0, num[0]));
        while (!stack.isEmpty()) {
            Pair now = stack.pop();
            if (oper[now.x] <= 0)
                continue;
            oper[now.x]--;

            if (now.y == n - 1) {
                if (now.z < min)
                    min = now.z;
                if (now.z > max)
                    max = now.z;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if (oper[i] > 0) {
                    stack.push(new Pair(i, now.y + 1, operate(i, now.z, num[now.y + 1])));
                }

            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
