
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        
        // Sort workers based on their wage-to-quality ratio
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0;
        double result = Double.MAX_VALUE;
        
        // Iterate over workers, forming groups
        for (double[] worker : workers) {
            double ratio = worker[0];
            int q = (int) worker[1];
            
            qualitySum += q;
            maxHeap.offer(q);
            
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                result = Math.min(result, ratio * qualitySum);
            }
        }
        
        return result;
    }
}