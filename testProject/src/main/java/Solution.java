import java.util.*;

public class Solution {
    private static int nrOfNodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nrOfNodes = sc.nextInt();
        int nrOfVertexes = sc.nextInt();
        int[][] graph = new int[nrOfNodes + 1][nrOfNodes + 1];
        for (int i = 0; i < nrOfVertexes; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[from][to] = cost;
            graph[to][from] = cost;
        }
        Vector<Integer> crossed = new Vector<Integer>();
        System.out.println(totalCost(graph));
    }

    private static int totalCost(int[][] graph) {
        int maxNrOfOcc = Integer.MIN_VALUE, maxNrOfSum = Integer.MAX_VALUE, from = 0, to;
        for (int i = 0; i < graph.length; i++) {
            int[] aGraph = graph[i];
            int nrOfOcc = 0;
            for (int i1 = 0; i1 < aGraph.length; i1++) {
                int anAGraph = aGraph[i1];
                if (anAGraph != 0)
                    nrOfOcc++;
            }
            if (maxNrOfOcc < nrOfOcc) {
                maxNrOfOcc = nrOfOcc;
                from = i;
                maxNrOfSum = makeSum(aGraph);
            } else {
                if (maxNrOfOcc == nrOfOcc && maxNrOfSum > makeSum(aGraph)) {
                    maxNrOfOcc = nrOfOcc;
                    maxNrOfSum = makeSum(aGraph);
                }else if (maxNrOfOcc == nrOfOcc && maxNrOfSum == makeSum(aGraph)){
                    if (from +1+from+makeSum(aGraph) > maxNrOfSum){
                        maxNrOfOcc = nrOfOcc;
                        maxNrOfSum = makeSum(aGraph);
                    }
                }
            }
        }
        return maxNrOfSum;
    }

    private static int makeSum(int[] graph) {
        int sum = 0;
        for (int val : graph)
            sum += val;
        return sum;
    }
}