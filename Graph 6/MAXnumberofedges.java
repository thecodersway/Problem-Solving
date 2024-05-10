import java.util.Arrays;
class MAXnumberofedges
{//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
      int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        int root = find(parent[x], parent);
        parent[x] = root;
        return root;
    }
    boolean union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }
        return false;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));

        int[] parentAlice = new int[n + 1];
        int[] parentBob = new int[n + 1];
        int[] rankAlice = new int[n + 1];
        int[] rankBob = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parentAlice[i] = i;
            parentBob[i] = i;
            rankAlice[i] = 1;
            rankBob[i] = 1;
        }

        int mergedAlice = 1;
        int mergedBob = 1;
        int removeEdge = 0;

        for (int[] e : edges) {
            int type = e[0];
            int u = e[1];
            int v = e[2];

            if (type == 3) {
                boolean mergedAliceFlag = union(u, v, parentAlice, rankAlice);
                boolean mergedBobFlag = union(u, v, parentBob, rankBob);

                if (mergedAliceFlag) {
                    mergedAlice++;
                }
                if (mergedBobFlag) {
                    mergedBob++;
                }
                if (!mergedAliceFlag && !mergedBobFlag) {
                    removeEdge++;
                }
            } else if (type == 1) {
                boolean mergedAliceFlag = union(u, v, parentAlice, rankAlice);
                if (mergedAliceFlag) {
                    mergedAlice++;
                } else {
                    removeEdge++;
                }
            } else if (type == 2) {
                boolean mergedBobFlag = union(u, v, parentBob, rankBob);
                if (mergedBobFlag) {
                    mergedBob++;
                } else {
                    removeEdge++;
                }
            }
        }

        if (mergedAlice != n || mergedBob != n) {
            return -1;
        }
        return removeEdge;
    }
}
