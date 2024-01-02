class Solution {
    public int maxOperations(int[] nums, int k) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                nums[index++] = nums[i];
            }
        }

        Arrays.sort(nums, 0, index);
        int i=0, j = index-1;
        int count = 0;
        while(i < j) {
            int tar = nums[i] + nums[j];
            if(tar == k) {
                count++;
                i++;
                j--;
            }
            else if(tar < k)
                i++;
            else 
                j--;
        }
        return count;
    }
}