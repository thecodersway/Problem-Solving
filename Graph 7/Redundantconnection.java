public class Redundantconnection {
    //https://leetcode.com/problems/redundant-connection/description/
        public int[] findRedundantConnection(int[][] edges) {
            UnionFind unionFind = new UnionFind(edges.length + 1);
            for (int[] edge : edges) {
                if (!unionFind.union(edge[0], edge[1])) {
                    return edge;
                }
            }
            return null;
        }
    
        class UnionFind {
            int[] parent;
    
            public UnionFind(int size) {
                parent = new int[size];
                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                }
            }
    
            public int find(int node) {
                if (parent[node] != node) {
                    parent[node] = find(parent[node]);
                }
                return parent[node];
            }
    
            public boolean union(int nodeA, int nodeB) {
                int rootA = find(nodeA);
                int rootB = find(nodeB);
                
                if (rootA == rootB) {
                    return false; // Nodes are already in the same connected component
                }
                parent[rootB] = rootA;
                return true; 
            }
        }
    }
    

