class Solution {
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            int remainder = n & 1;
            reversed = (reversed << 1) | remainder;
            n = n >>> 1;
        }

        return reversed;
    }
}
