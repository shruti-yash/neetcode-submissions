class TrieNode {
    TrieNode[] children;
    String word;

    TrieNode() {
        children = new TrieNode[26];
        word = null;
    }

    public void addWord(String word) {
        TrieNode curr = this;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.word = word;
    }
}

class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (String word : words) {
            root.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, root, board, res);
            }
        }

        return res;
    }

    private void dfs (int i, int j, TrieNode node, char[][] board, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#')
            return;

        int index = board[i][j] - 'a';
        node = node.children[index];
        if (node == null) return;

        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        dfs(i+1, j, node, board, res);
        dfs(i-1, j, node, board, res);
        dfs(i, j+1, node, board, res);
        dfs(i, j-1, node, board, res);

        board[i][j] = temp;
    }
}


    /**
    This solution below is Backtracking but its time complexity is higher compared to Trie
    */
    // int rows = 0, cols = 0;
    // public List<String> findWords(char[][] board, String[] words) {
    //     List<String> res = new ArrayList<>();
    //     rows = board.length;
    //     cols = board[0].length;

    //     for (String word : words) {
    //         boolean found = false;
    //         for (int i = 0; i < rows; i++) {
    //             for (int j = 0; j < cols; j++) {
    //                 if (board[i][j] == word.charAt(0) && dfs(i, j, 0, word, board)) {
    //                     res.add(word);
    //                     found = true;
    //                     break;
    //                 }
    //             }
    //             if (found) break;
    //         }
    //     }
    //     return res;
    // }

    // private boolean dfs(int i, int j, int index, String word, char[][] board) {
    //     if (index == word.length()) return true;
    //     if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word.charAt(index)) return false;

    //     char ch = board[i][j];
    //     board[i][j] = '#';
    //     boolean found = 
    //         dfs(i+1, j, index+1, word, board) ||
    //         dfs(i-1, j, index+1, word, board) ||
    //         dfs(i, j+1, index+1, word, board) ||
    //         dfs(i, j-1, index+1, word, board);
    //     board[i][j] = ch;
    //     return found;
    // }

