class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        while (n!=0) {
            int out = n & mask;
            if (out == 1) count++;
            n = n >> 1;
        }
        return count;
    }
}
