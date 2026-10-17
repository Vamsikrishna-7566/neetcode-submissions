class Solution {
    public boolean validTree(int n, int[][] edges) {

        // A valid tree must have exactly n-1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize list for every node
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges in both directions
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Track visited nodes
        Set<Integer> visited = new HashSet<>();

        // Check if cycle exists
        if (!DFS(0, -1, adj, visited)) {
            return false;
        }

        // Check if all nodes are connected
        return visited.size() == n;
    }

    public boolean DFS(int node, int parent,
                       List<List<Integer>> adj,
                       Set<Integer> visited) {

        // Mark current node as visited
        visited.add(node);

        // Visit all neighbors
        for (int neighbor : adj.get(node)) {

            // Ignore edge going back to parent
            if (neighbor == parent) {
                continue;
            }

            // Already visited means cycle
            if (visited.contains(neighbor)) {
                return false;
            }

            // Explore neighbor
            if (!DFS(neighbor, node, adj, visited)) {
                return false;
            }
        }

        // No cycle found
        return true;
    }
}