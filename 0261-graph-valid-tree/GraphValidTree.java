class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            // If union returns false, cycle detected
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            // Cycle detected
            if (rootA == rootB) return false;

            // Union by rank
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        }
    }
}
