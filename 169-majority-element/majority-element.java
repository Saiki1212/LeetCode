class Solution {
    public int findMaj(int[] nums,int sI,int maj){
        int c=0;
        for(int i=sI;i<nums.length;i++){
            if(nums[i]==maj)
                c++;
            else
                c--;
            if(c==-1)
                return findMaj(nums,i,nums[i]);
        }
        return maj;
    }
    public int majorityElement(int[] nums) {
       
        return findMaj(nums,0,nums[0]);
    }
}