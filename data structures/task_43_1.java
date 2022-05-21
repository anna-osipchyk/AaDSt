//package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class task_43_1 {

    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("huffman.in");
        BufferedReader br = new BufferedReader(fr);
        String n = br.readLine();
        long testt = 0;
        PriorityQueue<Long> q = new PriorityQueue<>(500000);
        String el[] = br.readLine().split(" ");
        for(int i =0; i<el.length-1; i+=2){
            String num = el[i];
            q.add(Long.valueOf(num));
            String nex_num = el[i+1];
            q.add(Long.valueOf(nex_num));

            long small_one = q.poll();
            long small_two = q.poll();
            long s =small_one+small_two;
            testt = testt+s;
            q.add(s);
        }
        if (el.length%2==1){
            q.add(Long.valueOf(el[el.length-1]));
        }
        while(true){

            if (q.isEmpty()){
                break;
            }
            long small_one = q.poll();
            if (q.isEmpty()){
                break;
            }
            long small_two = q.poll();
            long s =small_one+small_two;
            testt = testt+s;
            q.add(s);
        }
        FileWriter fw = new FileWriter("huffman.out");
        fw.write(String.valueOf(testt));
        fw.close();
    }
}
