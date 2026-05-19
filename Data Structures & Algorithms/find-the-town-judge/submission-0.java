class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] outdegree=new int[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:trust){
            int u=e[0];
            int v=e[1];
            graph.get(v).add(u);
            outdegree[u]++;
        }
        for(int i=1;i<=n;i++){
            if(graph.get(i).size()==n-1 && outdegree[i]==0){
                return i;
            }
        }
        return -1;
    }
}