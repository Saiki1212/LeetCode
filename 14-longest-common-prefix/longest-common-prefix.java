class Solution {
    public String longestCommonPrefix(String[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        Arrays.sort(nums);
        String str1 = nums[0];
        String str2 = nums[n-1];
        int idx = 0;
        while(idx < str1.length() && idx < str2.length()) {
            if(str1.charAt(idx) == str2.charAt(idx)) idx++;
            else break;
        }
        return str1.substring(0, idx);
    }
}