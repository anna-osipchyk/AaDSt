//package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class task_41 {

    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("input.txt");
        BufferedReader file = new BufferedReader(fr);
        String arr[] = file.readLine().split(" ");
        int s,n,m;
        s = Integer.parseInt(arr[0]);
        n = Integer.parseInt(arr[1]);
        m = Integer.parseInt(arr[2]);
        int summa = n*m;
        int[] times = new int[s];
        int[] values = new int[s];
        int i = 0;
        int covered_sum = 0;
        for(i=0; i< s; i++){
            String data[] = file.readLine().split(" ");
            times[i] = Integer.parseInt(data[1]);
            values[i]  =Integer.parseInt(data[0]);
        }
        long matrix[][] = new long[s+1][summa+1];
        long max_el=0;
        int max_idx = 0;
        int new_idx=0;
        ArrayList<String> answ = new ArrayList<>();
        for(int k =1; k< s+1; k++){
            for(int s1=1; s1<summa+1;s1++){
                if(s1-values[k-1]>=0){
                    matrix[k][s1] = max(matrix[k-1][s1], matrix[k-1][s1-values[k-1]]+times[k-1]);
//                    System.out.print(k+ " ");
//                    System.out.print(s1+ " ");
//                    System.out.print(matrix[k-1][s1]+" ");
//                    System.out.println(matrix[k-1][s1-values[k-1]]+times[k-1]+" ");
                }
                else{
                    matrix[k][s1] = matrix[k-1][s1];
                }
                if(matrix[k][s1]>max_el){
                    new_idx = s1;
                }
                if (matrix[k][s1]>=max_el) {


                    max_el = matrix[k][s1];
                    max_idx = s1;
                }
            }
        }

        int mi = max_idx;
        int kk = 1;
        for (int k = s; k>0; k--){
            if (matrix[k][max_idx] != matrix[k-1][max_idx]) {
                answ.add(0, String.valueOf(k));
                max_idx -= values[k - 1];
            }
            else if (matrix[k][max_idx] == matrix[k-1][max_idx] && max_idx-values[k-1]>=0 && matrix[k-1][max_idx-values[k-1]]+times[k-1]==matrix[k-1][max_idx]){
                answ.add(0, String.valueOf(k));
                max_idx -= values[k - 1];
                k--;

            }
            kk++;
            if(max_idx<0){
                break;
            }
        }
        FileWriter fw = new FileWriter("output.txt");
        fw.write(String.valueOf(answ.size())+"\n");
        String str = String.join(" ", answ);
        fw.write(str);
        //fw.write(String.valueOf(matrix[s][mi]));
        fw.close();
    }
}
