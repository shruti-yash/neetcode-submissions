class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i-1)] + 1;
        }
        return res;
    }

    // public int[] countBits(int n) {
    //     int[] res = new int[n+1];
    //     for (int i = 0; i <= n; i++) {
    //         res[i] = countOne(i);
    //     }
    //     return res;
    // }

    // private int countOne(int n) {
    //     int count = 0;
    //     while (n!=0) {
    //         n = n & (n-1);
    //         count++;
    //     }
    //     return count;
    // }
}
