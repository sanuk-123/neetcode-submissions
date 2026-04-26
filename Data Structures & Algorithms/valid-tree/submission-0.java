class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited=new boolean[n];

        if(hasCycle(0,-1,graph,visited)) return false;

        for(boolean v:visited){
            if(!v) return false;
        }
        return true;
    }
    private boolean hasCycle(int node,int parent,List<List<Integer>> graph,boolean[] visited){
        visited[node]=true;
        for(int v:graph.get(node)){
            if(!visited[v]){
                if(hasCycle(v,node,graph,visited)) return true;
            }else if(v!=parent){
                return true;
                //visited a node and its not the parent node used to get to the current node
            }
        }
        return false;
    }
}
