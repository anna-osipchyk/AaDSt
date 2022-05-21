//package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import static java.lang.Math.abs;


public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int i =0;
        int my_el =1;
        int size = n;
        int[] posl =new int[size];
        int [] l = new int[size+1];
        int j=0;
        l[0]=1;
        while(j<n)
        {
            int a = sc.nextInt();
            posl[i] = abs(a);
            l[i+1] = 1;
            i++;
            j++;
        }
        int max_idx = 1;
        for(i=2; i< size+1; i++){
            int max1 = 0;
            for(j=1; j< i; j++){
                if(l[j]> max1)
                {
                    if(posl[j-1]==0){
                    }
                    else if(posl[i-1]%posl[j-1]==0 ) {
                        max1 = l[j];
                    }
                }
            }l[i]  = max1+1;

        }
        int maxx = 1;
        for(i=1;i< size+1;i++){
            if (l[i]>maxx){
                maxx = l[i];
            }
        }
        System.out.print(size-maxx);
    }
}
