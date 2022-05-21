//package com.company;

import java.io.*;
import java.util.*;

public class task_43_2 {
    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        Date currentTime = new Date();
        ArrayDeque<Long> q = new ArrayDeque<>();
        FileReader fr = new FileReader("huffman.in");
        BufferedReader bf = new BufferedReader(fr);
        int n = Integer.parseInt(bf.readLine());
        FileWriter fw = new FileWriter("huffman.out");
        long sum = 0;
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        ArrayDeque<Long> q1 = new ArrayDeque<>();

        for(int i = 0; i < n;i++){
            q1.add(Long.parseLong(tk.nextToken()));
        }
        while(true) {
            if(q1.isEmpty()) break;
            long el1;
            if(!q.isEmpty()&&q.peek()<=q1.peek()) el1 = q.poll();
            else el1= q1.poll();

            if(q1.isEmpty()){
                q.addFirst(el1);
                System.out.println("True");
                break;
            }
            long el2;
            if (q.isEmpty()) {
                el2 = q1.poll();
            }
            else {
                if(q.peek()<=q1.peek())el2 = q.poll();
                else el2 = q1.poll();
            }
                q.add(el1+el2);
                sum+=el1+el2;
        }
        q1 = null;
        System.gc();

        while (!q.isEmpty()){
            long el1 = q.poll();
            if (q.isEmpty()) {
                System.out.println("Break");
                break;
            }
            long el2 =q.poll();
            q.add(el1+el2);
            sum+=el1+el2;
        }
        fw.write(sum+"");
        fw.close();
        System.out.println(sum);
         // берем дату до метода.


                Date newTime = new Date();     // берем время после метода.

        System.out.println(currentTime.getTime() - newTime.getTime());
        System.out.println(System.currentTimeMillis() - time);
    }
}
