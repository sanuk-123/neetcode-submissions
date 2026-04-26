

class Solution {

    static class Pair {
        int node;
        int cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;

        boolean[] inMST = new boolean[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // start from point 0
        pq.offer(new Pair(0, 0));

        int total = 0;
        int count = 0; // how many points connected

        while (count < n) {
            Pair cur = pq.poll();
            int u = cur.node;
            int cost = cur.cost;

            // skip if already in MST (lazy deletion)
            if (inMST[u]) continue;

            // add to MST
            inMST[u] = true;
            total += cost;
            count++;

            // push all edges from u to unvisited points
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = manhattan(points[u], points[v]);
                    pq.offer(new Pair(v, dist));
                }
            }
        }

        return total;
    }

    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}