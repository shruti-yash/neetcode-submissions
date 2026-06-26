class Solution {
    int rows, cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacificSet = new boolean[rows][cols];
        boolean[][] atlanticSet = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacificSet, heights[i][0], heights);
            dfs(i, cols-1, atlanticSet, heights[i][cols-1], heights);
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, pacificSet, heights[0][j], heights);
            dfs(rows-1, j, atlanticSet, heights[rows-1][j], heights);
        }

        for (int i = 0; i < pacificSet.length; i++) {
            for (int j = 0; j < pacificSet[0].length; j++) {
                if (pacificSet[i][j] && atlanticSet[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] visited, int previousHeight, int[][] heights) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || heights[i][j] < previousHeight || visited[i][j])
            return;

        visited[i][j] = true;
        dfs(i+1, j, visited, heights[i][j], heights);
        dfs(i-1, j, visited, heights[i][j], heights);
        dfs(i, j+1, visited, heights[i][j], heights);
        dfs(i, j-1, visited, heights[i][j], heights);
    }
}
