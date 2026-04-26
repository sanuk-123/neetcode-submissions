class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            count++;
            dfs(i,graph,visited);
        }
        return count;
    }
    private void dfs(int node,List<List<Integer>> graph,boolean[] visited){
        visited[node]=true;
        for(int v:graph.get(node)){
            if(!visited[v]){
                dfs(v,graph,visited);
            }
        }
    }
}
