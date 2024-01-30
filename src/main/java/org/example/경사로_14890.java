// D
package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class 경사로_14890 {
        public static void main(String[] args) throws FileNotFoundException {
            System.setIn(new FileInputStream("res/input.txt"));
            Scanner sc = new Scanner(System.in);

            int N=sc.nextInt();
            int L=sc.nextInt();

            int[][] arr=new int[N][N];
            boolean[][] ladder=new boolean[N][N];
            int result=0;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j]=sc.nextInt();
                }
            }

            for(int i=0;i<N;i++){
                boolean path=true;
                for(int j=1;j<N;j++){
                    if(arr[i][j]>arr[i][j-1]){
                        if(arr[i][j]!=arr[i][j-1]+1){
                            path=false;
                            break;
                        }else{
                            for(int k=j-1;k>j-1-L;k--){
                                if(k<0 || arr[i][k]!=arr[i][j-1] || ladder[i][k]){
                                    path=false;
                                    break;
                                }
                            }
                            if(!path) {
                                break;
                            }else{
                                for(int k=j-1;k>j-1-L;k--){
                                ladder[i][k]=true;
                                }
                            }
                        }
                    }else if(arr[i][j]<arr[i][j-1]){
                        if(arr[i][j]+1!=arr[i][j-1]){
                            path=false;
                            break;
                        }else{
                            for(int k=j;k<j+L;k++){
                                if(k>=N || arr[i][k]!=arr[i][j] || ladder[i][k]){
                                    path=false;
                                    break;
                                }
                            }
                            if(!path) {
                                break;
                            }else{
                                for(int k=j;k<j+L;k++){
                                    ladder[i][k]=true;
                                }
                                j+=L-1;
                            }
                        }
                    }
                }
                if(path) result++;
            }

            for (int i=0;i<ladder.length;i++) {
                Arrays.fill(ladder[i], false);
            }

            for(int i=0;i<N;i++){
                boolean path=true;
                for(int j=1;j<N;j++){
                    if(arr[j][i]>arr[j-1][i]){
                        if(arr[j][i]!=arr[j-1][i]+1){
                            path=false;
                            break;
                        }else{
                            for(int k=j-1;k>j-1-L;k--){
                                if(k<0 || arr[k][i]!=arr[j-1][i] || ladder[k][i]){
                                    path=false;
                                    break;
                                }
                            }
                            if(!path) {
                                break;
                            }else{
                                for(int k=j-1;k>j-1-L;k--){
                                    ladder[k][i]=true;
                                }
                            }
                        }
                    }else if(arr[j][i]<arr[j-1][i]){
                        if(arr[j][i]+1!=arr[j-1][i]){
                            path=false;
                            break;
                        }else{
                            for(int k=j;k<j+L;k++){
                                if(k>=N||arr[k][i]!=arr[j][i] || ladder[k][i]){
                                    path=false;
                                    break;
                                }
                            }
                            if(!path) {
                                break;
                            }else{
                                for(int k=j;k<j+L;k++){
                                    ladder[k][i]=true;
                                }
                                j+=L-1;
                            }
                        }
                    }
                }
                if(path) result++;
            }
            System.out.println(result);
        }

}
