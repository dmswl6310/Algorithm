package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class 퇴사_14501 {
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] time = new int[n];
        int[] profit = new int[n];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int first = dp[i + 1];
            int second = i + time[i] <= n ? dp[i + time[i]] + profit[i] : 0;
            dp[i] = Math.max(first, second);
        }

        System.out.println(dp[0]);
    }
}