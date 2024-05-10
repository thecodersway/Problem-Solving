import java.util.*;
//https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCosttoConnectallpoints {
    public int minCostConnectPoints(int[][] points) {
        int numPoints = points.length;
        int totalCost = 0;
        int[] minDistToMST = new int[numPoints]; 
        boolean[] connectedToMST = new boolean[numPoints];
        Arrays.fill(minDistToMST, Integer.MAX_VALUE);
        
        connectedToMST[0] = true;
        for (int count = 1, current = 0; count < numPoints; count++) {
            int minDistance = Integer.MAX_VALUE;
            int nextPoint = 0;
            for (int i = 0; i < numPoints; i++) {
                if (!connectedToMST[i]) {
                    int distance = Math.abs(points[current][0] - points[i][0]) + Math.abs(points[current][1] - points[i][1]);
                    minDistToMST[i] = Math.min(minDistToMST[i], distance);
                    if (minDistance > minDistToMST[i]) {
                        minDistance = minDistToMST[i];
                        nextPoint = i;
                    }
                }
            }
            totalCost += minDistance;
            current = nextPoint;
            connectedToMST[current] = true;
        }
        
        return totalCost;
    }
    }
    