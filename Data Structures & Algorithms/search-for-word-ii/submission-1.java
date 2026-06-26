class Solution {
    int rows = 0, cols = 0;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        rows = board.length;
        cols = board[0].length;

        for (String word : words) {

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    char ch = word.charAt(0);
                    if (board[i][j] == ch) {
                        if (dfs(i, j, 0, word, board)) {
                            set.add(word);
                        }
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }

    private boolean dfs(int i, int j, int index, String word, char[][] board) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word.charAt(index)) return false;

        char ch = board[i][j];
        board[i][j] = '#';
        boolean found = 
            dfs(i+1, j, index+1, word, board) ||
            dfs(i-1, j, index+1, word, board) ||
            dfs(i, j+1, index+1, word, board) ||
            dfs(i, j-1, index+1, word, board);
        board[i][j] = ch;
        return found;
    }
}
