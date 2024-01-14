package org.example;

/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class View1206
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=3;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int result=0;
            int buildingNum=sc.nextInt();
            int [][] arr=new int[buildingNum][2];
            for(int i=0;i<buildingNum;i++) {
                arr[i][0]=sc.nextInt();
                arr[i][1]=arr[i][0];
            }

            for(int target=2;target<buildingNum-2;target++) {
                for(int next=target+1;next<target+3;next++){
                    if(arr[target][0]==arr[next][0]){
                        arr[target][1]=-1;
                        arr[next][1]=-1;
                    }else if(arr[target][0]>arr[next][0]){
                        arr[next][1]=-1;
                        if(arr[target][1]!=-1 && arr[target][0]-arr[next][0]<arr[target][1]){
                        arr[target][1]=arr[target][0]-arr[next][0];
                        }
                    }else{
                        arr[target][1]=-1;
                        if(arr[next][1]!=-1 && arr[next][0]-arr[target][0]<arr[next][1]){
                            arr[next][1]=arr[next][0]-arr[target][0];
                        }
                    }
                }
                if(arr[target][1]!=-1) result+=arr[target][1];
            }

            System.out.println("#" + test_case + " "+result);

        }
    }
}