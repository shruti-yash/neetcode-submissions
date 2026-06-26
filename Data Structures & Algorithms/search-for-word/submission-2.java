class Solution {
    public boolean exist(char[][] board, String word) {
        // Set<Pair<Integer, Integer>> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, String word, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        if (i >= rows || j >= cols || i < 0 || j < 0 
            // visited.contains(new Pair<>(i, j)) 
            || index >= word.length()
            || word.charAt(index) != board[i][j]) return false;

        if (index == word.length()-1) return true;
        
        // visited.add(new Pair<>(i, j)); This was taking extra memory and extra object creation per dfs call
        char temp = board[i][j];
        board[i][j] = '#'; //Instead of visited set, we are marking the board directly and saving space

        boolean found =  
            dfs(i+1, j, index+1, word, board) ||
            dfs(i-1, j, index+1, word, board) ||
            dfs(i, j+1, index+1, word, board) ||
            dfs(i, j-1, index+1, word, board);

        // visited.remove(new Pair<>(i, j));
        board[i][j] = temp;
        return found;
    }
}
