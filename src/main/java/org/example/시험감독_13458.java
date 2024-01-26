package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class 시험감독_13458 {
    public static void main(String[] args) throws FileNotFoundException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//
//        //문자열(br.readLine())을 받아 띄어쓰기 기준으로 문자열 분리
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        //구분자를 기준으로 문자열 분리
//        //StringTokenizer st = new StringTokenizer(br.readLine(), ",");
//
//        int num = Integer.parseInt(br.readLine());
//        int cnt = 0;
//
//
//
//        for(int i=0; i < arr.length; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//            if(arr[i] == num){
//                cnt++;
//            }
//        }
//
//        System.out.println(cnt);
//        br.close();
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int[] arr=new int[num];
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }

        int b=sc.nextInt();
        int c=sc.nextInt();

       long result=0;

        // 총감독관은 무조건 한명
        for(int i=0;i<num;i++){
            arr[i]-=b;
            result+=1;
            if(arr[i]<=0) continue;
            result+= (int) Math.ceil ((double)arr[i] / c);
        }

        System.out.println(result);
    }
}