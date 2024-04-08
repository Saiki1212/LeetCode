class Solution {
    public int f(int []nums, int k){
        if(k<0)return 0;
        int i=0,j=0,c=0,s=0;
        while(j<nums.length){
            s+=nums[j];
            
            while(s>k && i<j){
                s-=nums[i];
                i++;
                
            }
            if(s<=k)c+=j-i+1;
            j++;
        }
        return c;
    }
    public int numSubarraysWithSum(int[] nums, int k) {
        return f(nums, k)-f(nums, k-1);
       
    }
}