class Solution {
    public List<List<Integer>> fourSum(int[] nums, int tar) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        
        if(n < 4) return list;
        Arrays.sort(nums);
        
        
        int i=0;
        while(i < n-3) {
            if(i > 0 && nums[i] == nums[i-1]) {i++; continue;}
            int j = i+1;
            while(j < n-2) {
                if(j != i+1 && nums[j] == nums[j-1]) {j++; continue;}
                int i1 = j+1, j1 = n-1;

                while(i1 < j1) {
                    long val = nums[i];
                    val += nums[i1];
                    val += nums[j1];
                    val += nums[j];
                    if(val > tar) j1--;
                    else if(val < tar) i1++;
                    else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[i1], nums[j1], nums[j]);
                        list.add(new ArrayList<>(temp));
                        i1++; j1--;
                        while(i1 < j1 && nums[i1] == nums[i1-1]) i1++;
                        while(i1 < j1 && nums[j1] == nums[j1+1]) j1--;
                    }
                }
                j++;
            }
            i++;
        }
        
        return list;
    }
}