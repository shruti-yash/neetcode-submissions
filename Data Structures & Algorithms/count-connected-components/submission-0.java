class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, adjList, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, List<List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        for (Integer adj : adjList.get(node)) {
            dfs(adj, adjList, visited);
        }
    }
}
