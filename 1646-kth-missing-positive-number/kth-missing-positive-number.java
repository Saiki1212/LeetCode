class Solution {
    public int findKthPositive(int[] nums, int k) {
        int n = nums.length;
        int val = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(nums[i] != val) {
                while(nums[i] != val) {
                    list.add(val++);
                }
            }
            val++;
        }
        int s = list.size();
        // for(int i=0; i<s; i++) 
        //     System.out.println(list.get(i));
        if(s >= k) return list.get(k-1);
        return nums[n-1]+(k-list.size());
    }
}