class Solution {
    int[] res = new int[2];
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < s.length(); i++) {
            findPalindrome(i, i, arr);
            findPalindrome(i, i+1, arr);
        }
        return s.substring(res[0], res[1] + 1);
    }

    private void findPalindrome(int left, int right, char[] arr) {
        if (left < 0 || right >= arr.length || arr[left] != arr[right]) return;
        if (res[1]-res[0] + 1  < right - left + 1) {
            res[0] = left;
            res[1] = right;
        }
        left--;
        right++;
        findPalindrome(left, right, arr);
    } 
}
