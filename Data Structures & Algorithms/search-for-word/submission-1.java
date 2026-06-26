class Solution {
    public boolean exist(char[][] board, String word) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = word.charAt(0);
                if (board[i][j] == ch) {
                    if (dfs(i, j, 0, word, board, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int index, String word, char[][] board, Set<Pair<Integer, Integer>> visited) {
        int rows = board.length;
        int cols = board[0].length;

        if (i >= rows || j >= cols || i < 0 || j < 0 || 
            visited.contains(new Pair<>(i, j)) 
            || index >= word.length()
            || word.charAt(index) != board[i][j]) return false;

        if (index == word.length()-1) return true;
        
        visited.add(new Pair<>(i, j));
        boolean found =  
            dfs(i+1, j, index+1, word, board, visited) ||
            dfs(i-1, j, index+1, word, board, visited) ||
            dfs(i, j+1, index+1, word, board, visited) ||
            dfs(i, j-1, index+1, word, board, visited);
        visited.remove(new Pair<>(i, j));
        return found;
    }
}
