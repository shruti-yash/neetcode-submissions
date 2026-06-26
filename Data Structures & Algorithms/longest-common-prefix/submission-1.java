class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return prefix;
                }
            }
            prefix += currentChar;
        }

        return prefix;

    }
}