package com.practice.sample;

import java.util.Scanner;

public class MaxPalidram {
    static int R = 26;
    static int n;
    static int[][] csum;
    static long[] fac;
    static long[] ifac;
    static long MOD = 1000000007;
    static void initialize(String s) {
        // This function is called once before all queries.
        n = s.length();
        csum = new int[R][n+1];
        for (int i = 1; i <= n; i++) {
            int id = s.charAt(i-1) - 'a';
            for (int j = 0; j < R; j++)
                csum[j][i] = csum[j][i-1];
            csum[id][i] = csum[id][i-1] + 1;
        }

        fac = new long[n+1];
        ifac = new long[n+1];
        fac[0] = 1;
        ifac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i-1] * i % MOD;
            ifac[i] = ifac[i-1] * inv(i, MOD) % MOD;
        }
    }

    static private long inv(long v, long m) {
        return (extendedGCD(v, m)[0] % m + m) % m;
    }

    static private long[] extendedGCD(long x, long y) {
        long[] ans = new long[3];
        if (y == 0) {
            ans[0] = 1;
            ans[2] = x;
            return ans;
        }

        long q = x / y;
        long r = x % y;
        long[] t = extendedGCD(y, r);
        ans[0] = t[1];
        ans[2] = t[2];
        ans[1] = t[0] - ans[0] * q;
        return ans;
    }

    static int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        int nmid = 0;
        int nside = 0;
        long ans = 1;
        for (int i = 0; i < R; i++) {
            int cnt = csum[i][r] - csum[i][l-1];
            int left = cnt / 2;
            nside += left;
            ans = ans * ifac[left] % MOD;
            if (cnt % 2 == 1)
                nmid++;
        }
        ans = ans * fac[nside] % MOD;
        if (nmid > 1)
            ans = ans * nmid % MOD;
        return (int)ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        initialize(s);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            int result = answerQuery(l, r);
            System.out.println(result);
        }
        in.close();
    }
}
