package main;

class solution2 {
    private static final int INF = 0x3f3f3f3f;

    public int networkDelayTime(int[][] travelTimes, int totalNodes, int startNode) {
        int[][] graph = new int[totalNodes][totalNodes];
        int[] signalTime = new int[totalNodes];
        boolean[] visitedNodes = new boolean[totalNodes];
        
        for (int i = 0; i < totalNodes; ++i) {
            signalTime[i] = INF;
            Arrays.fill(graph[i], INF);
        }
        
        for (int[] time : travelTimes) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        
        signalTime[startNode - 1] = 0;

        // Dijkstra's algorithm 
        for (int i = 0; i < totalNodes; ++i) {
            int node = -1;
            
            for (int j = 0; j < totalNodes; ++j) {
                if (!visitedNodes[j] && (node == -1 || signalTime[node] > signalTime[j])) {
                    node = j;
                }
            }
            
            visitedNodes[node] = true;

            for (int j = 0; j < totalNodes; ++j) {
                signalTime[j] = Math.min(signalTime[j], signalTime[node] + graph[node][j]);
            }
        }

        int maxSignalTime = 0;
        for (int time : signalTime) {
            maxSignalTime = Math.max(maxSignalTime, time);
        }

        return maxSignalTime == INF ? -1 : maxSignalTime;
    }
}
