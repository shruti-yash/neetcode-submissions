class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            int[] count = new int[26];
            for (char ch : charArray) {
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);

        }

        res.addAll(map.values());
        return res;
    }
}
