//package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Scanner;

public class task_20 {

    public static void main(String[] args) throws Exception {
	// write your code here
        FileReader fr  =new FileReader("input.txt");
        Scanner sc = new Scanner(fr);
        String string = sc.nextLine();
        int matrix [][]= new int[string.length()+1][string.length()+1];
        StringBuilder r_string = new StringBuilder(string);
        r_string.reverse();
        int j=1;
        int i=1;
        for(Character a: string.toCharArray()){
            j =1;
            for(Character b: r_string.toString().toCharArray()){
                if (b.equals(a)){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }
                else{
                    matrix[i][j]=Math.max( matrix[i-1][j], matrix[i][j-1]);
                }
                j+=1;
            }
            i+=1;
        }
        FileWriter fw = new FileWriter("output.txt");
        i = string.length();
        j = string.length();
        StringBuilder pal = new StringBuilder();
        while(matrix[i][j]>0){
            while(matrix[i][j]==matrix[i][j-1]){
                j-=1;
            }
            if (string.charAt(i-1)==r_string.charAt(j-1)){
                pal.append(string.charAt(i - 1));
                i -= 1;
                j -= 1;
            }
            else if (matrix[i-1][j] == matrix[i][j]) {
                i -= 1;
            }
        }
        fw.write(String.valueOf(pal.length())+"\n");
        fw.write(String.valueOf(pal));
        fw.close();

    }
}
