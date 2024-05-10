import java.util.*;
class reduntantconnection {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] ancestor = new int[n + 1];
        Arrays.fill(ancestor, -1);

        int[] candidate1 = null, candidate2 = null;

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];

            if (ancestor[to] == -1) {
                ancestor[to] = from;
            } else {
                candidate1 = new int[]{ancestor[to], to};
                candidate2 = new int[]{from, to};
                edge[1] = -1; 
            }
        }

        Arrays.fill(ancestor, -1);
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (to == -1) continue; 
            int rootFrom = find(ancestor, from);
            int rootTo = find(ancestor, to);
            if (rootFrom == rootTo) {
                if (candidate1 == null) {
                    return edge;
                } else {
                    return candidate1;
                }
            }

            ancestor[rootTo] = rootFrom;
        }

        return candidate2;
    }

    private int find(int[] ancestor, int x) {
        if (ancestor[x] == -1) return x;
        return ancestor[x] = find(ancestor, ancestor[x]);
    }
}
