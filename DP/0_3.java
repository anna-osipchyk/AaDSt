//package com.company;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(null, new Solution(), "", 64 * 2048 * 2048).start();
    }

    public void run() {
        int mod = 1000000000+7;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        in.close();
        if (K==0 || K==N){
            System.out.println("1");
        }
        else if(N-K==1){
            System.out.println(N);
        }
        else {
            int max_n = max(K, N - K);
            int min_n = min(K, N - K);
            double mul = action(min_n + 1, N, mod);
            double div = action(1, max_n, mod);
            BigInteger d = new BigInteger(Integer.toString((int)div));
            BigInteger m = new BigInteger(Integer.toString((int)mul));
            BigInteger reverse_div = ferm(d, BigInteger.valueOf(mod));
            System.out.println((m.multiply(reverse_div)).mod(BigInteger.valueOf(mod)));
        }

    }

    public BigInteger ferm(BigInteger a, BigInteger mode){
        BigInteger new_mode = new BigInteger(String.valueOf(mode.subtract(BigInteger.valueOf(2))));

        BigInteger c =BigInteger.ONE;
        while(new_mode.compareTo(BigInteger.valueOf(0)) > 0){
            if (new_mode.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)){
                c = c.multiply(a);
                c = c.mod(mode);
            }

                new_mode =new_mode.divide(BigInteger.valueOf(2));
                a = a.multiply(a).mod(mode);

        }
        return c;
    }
    public double action(int a, int b, int mod){
        double c =1;
        for(int i=a; i<=b; i++){
            c=((c%mod)*(i%mod))%mod;
        }
        return c;
    }
}
