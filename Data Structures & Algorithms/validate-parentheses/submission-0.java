class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty()) return false;
                char ch = st.peek();
                if (charMap.get(ch) == s.charAt(i)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
        
    }
}
