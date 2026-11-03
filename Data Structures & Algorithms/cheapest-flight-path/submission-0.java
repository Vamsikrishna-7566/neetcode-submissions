class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        // Step 1: Create adjacency list
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 2: Add flights
        for (int[] flight : flights) {

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adjList.get(from).add(new int[]{to, price});
        }

        // Step 3: Track minimum cost for each node
        // with a specific number of flights taken
        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        // Step 4: Min Heap
        // {node, cost, flightsTaken}
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        queue.offer(new int[]{src, 0, 0});

        // Step 5: Process flights
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int node = current[0];
            int cost = current[1];
            int flightsTaken = current[2];

            // Skip outdated entries
            if (cost > dist[node][flightsTaken]) {
                continue;
            }

            // Destination reached
            if (node == dst) {
                return cost;
            }

            // At most k stops means at most k+1 flights
            if (flightsTaken == k + 1) {
                continue;
            }

            // Explore neighboring airports
            for (int[] neighbor : adjList.get(node)) {

                int nextNode = neighbor[0];
                int price = neighbor[1];

                int newCost = cost + price;
                int newFlights = flightsTaken + 1;

                if (newCost < dist[nextNode][newFlights]) {

                    dist[nextNode][newFlights] = newCost;

                    queue.offer(new int[]{
                        nextNode, newCost, newFlights
                    });
                }
            }
        }

        return -1;
    }
}