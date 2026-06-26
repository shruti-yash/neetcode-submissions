class Solution {
    int count = 0;
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return recursion(0, s, dp);
    }

    private int recursion(int index, String s, int[] dp) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (dp[index] != -1) return dp[index];

        int ways = recursion(index+1, s, dp);

        if (index+1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index+2));
            if (twoDigit <= 26) {
                ways += recursion(index+2, s, dp);
            }
        }
        dp[index] = ways;
        return dp[index];
    }
}
