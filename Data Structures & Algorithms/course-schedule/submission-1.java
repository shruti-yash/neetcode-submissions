class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int a = prereq[0];
            int b = prereq[1];
            adjList.get(a).add(b);
        }

        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean isCycle = dfs(i, adjList, state);
            if (isCycle) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> adjList, int[] state) {
        if (state[course] == 1) return true;
        if (state[course] == 2) return false;

        state[course] = 1;
        for (Integer prereq : adjList.get(course)) {
            if (dfs(prereq, adjList, state)) return true;
        }
        state[course] = 2;
        return false;
    }
}
