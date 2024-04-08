class Solution {
    public int f(int []nums, int k){
        int s=0,c=0,i=0,j=0;
        while(j<nums.length){
            if(nums[j]%2!=0)s++;
            while(s>k && i<j){
                if(nums[i]%2!=0){s--;}i++;
            }
            if(s<=k)c+=j-i+1;j++;
        }
        return c;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums, k)-f(nums, k-1);
    }
}