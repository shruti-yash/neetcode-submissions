class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int count = str.charAt(i) - '0';
            i++;
            while(str.charAt(i) != '#') {
                count = (count*10) + (str.charAt(i++) - '0');
            }

            StringBuilder sb = new StringBuilder();
            i++;
            while (count > 0) {
                sb.append(str.charAt(i++));
                count--;
            }
            strs.add(sb.toString());
        }
        return strs;
    }
}
