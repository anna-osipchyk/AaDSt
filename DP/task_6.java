//package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class task_6 {

    public static void main(String[] args) throws Exception {
        // write your code here
        FileReader fr  =new FileReader("input.txt");
        BufferedReader sc = new BufferedReader(fr);
        int n = Integer.parseInt(sc.readLine());
//        LinkedHashSet<Integer> tmp_set = new LinkedHashSet<>();
        int tmp_set[] = new int[n];
        int i =0;
        String[] t = sc.readLine().split(" ");
        for(i=0;i<n;i++){
            tmp_set[i]=Integer.parseInt(t[i]);

        }
        int size = n;
        int[] the_last_el_for_idx_length = new int[size+1];
        the_last_el_for_idx_length[0] = Integer.MIN_VALUE;
        i=0;
        int cur_len = 0;
        for (Integer el: tmp_set){
            if(el < the_last_el_for_idx_length[cur_len]){
                int idx = upper_bound(the_last_el_for_idx_length,cur_len,el);
                if (el<the_last_el_for_idx_length[idx]){
                    the_last_el_for_idx_length[idx] = el;
                }
            }
            else if(el==the_last_el_for_idx_length[cur_len])
            {
                System.out.println("1");
            }
            else{
                cur_len+=1;
                the_last_el_for_idx_length[cur_len] = el;
            }
            i++;
        }
        FileWriter fw = new FileWriter("output.txt");
        fw.write(String.valueOf(cur_len));
        fw.close();

    }
    public static int upper_bound(int []a,int r, int x){
        int l=0;
        int k;
        while(l<r){
            k=(l+r)/2;
            if(x<=a[k]){
                r=k;
            }
            else{
                l=k+1;
            }
        }
        return l;
    }
}
