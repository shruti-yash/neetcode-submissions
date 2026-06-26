class Solution {

    //TUT: Strivers - https://www.youtube.com/watch?v=WJaij9ffOIY
    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        int startIndex = -1, minLength = Integer.MAX_VALUE;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0)+1);
        }

        int count = 0;
        while (r < s.length()) {
            if (freqMap.getOrDefault(s.charAt(r), 0) > 0) {
                count++;
            }

            freqMap.put(s.charAt(r), freqMap.getOrDefault(s.charAt(r), 0)-1);

            while (count == t.length()) {
                if (r-l+1 < minLength) {
                    startIndex = l;
                    minLength = r-l+1;
                }

                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l))+1);
                if (freqMap.get(s.charAt(l)) > 0) count--;
                l++;
            }

            r++;
        }

        return (startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength));

    }
}
