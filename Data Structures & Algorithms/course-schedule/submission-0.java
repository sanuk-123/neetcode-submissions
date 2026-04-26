class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        int[] indegree=new int[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] d:prerequisites){
            int dep=d[0];
            int pre=d[1];
            graph.get(pre).add(dep);
            indegree[dep]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int taken=0;
        while(!q.isEmpty()){
            int course=q.poll();
            taken++;
            for(int next:graph.get(course)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        return taken==n;
    }
}
