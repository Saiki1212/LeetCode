class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegrees[] = new int[numCourses];
        int n = prerequisites.length;

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++) list.add(new ArrayList<>());

        for(int i=0; i<n; i++) {
            indegrees[prerequisites[i][0]]++;
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i] == 0) dq.add(i);
        }

        int count = 0;
        int[] topo = new int[numCourses];

        while( !dq.isEmpty() ) {
            int idx = dq.pollFirst();
            topo[count++] = idx;
            for(int i = 0; i<list.get(idx).size(); i++) {
                int val = list.get(idx).get(i);
                indegrees[val]--;
                if(indegrees[val] == 0) dq.add(val);
            }
        }
        return count == numCourses ? topo : new int[]{};
    }
}