// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    // TC = O(V + E), SC = O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // null
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] indegrees = new int[numCourses]; // to count the no of dependencies for each course
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // 1 course prereq for how many courses
        for(int[] edge: prerequisites) { // O(E), 
            indegrees[edge[0]]++; // calculating the dependencies for each course 
            if(!map.containsKey(edge[1])) { // creating list in map for adjacency list
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]); // adding the dependencies
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                q.add(i); // adding vertices in q who has no dependencies & are ready to process
                count++;
            }
        }
        while(!q.isEmpty()) { // O(V + E)
            int curr = q.poll();
            // indegrees of dependent nodes
            List<Integer> li = map.get(curr); // getting the list of dependent courses on curr
            if(li != null) { // check only for null & not size() == 0, NPE(null ptr excptn)
                for(int edge: li) {
                    indegrees[edge]--; // as its processed, reducing dependencies of dependent crs by 1
                    if(indegrees[edge] == 0) {
                        q.add(edge);
                        count++; // no dependency, add in q & increase the count
                    }
                }
            }
        }
        return (count == numCourses);
    }
}