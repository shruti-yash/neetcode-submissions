class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return prefix;
                }
            }
            prefix = strs[0].substring(0, i+1);
        }

        return prefix;

    }
}