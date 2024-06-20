class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int right = 0;
        int oddCount = 0;
        
        int[] prefixCounts = new int[nums.length + 1];
        prefixCounts[0] = 1; 
        
        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                oddCount++;
            }
            
            if (oddCount >= k) {
                count += prefixCounts[oddCount - k];
            }
            
            prefixCounts[oddCount]++;
            
            right++;
        }
        
        return count;
    }
}
