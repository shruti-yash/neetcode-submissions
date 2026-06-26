class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxLen = 0, maxFreq = 0;
        Map<Character, Integer> count = new HashMap<>();

        while (r < s.length()) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0)+1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(r)));

            if ((r-l+1) - maxFreq > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
        
    }
}
