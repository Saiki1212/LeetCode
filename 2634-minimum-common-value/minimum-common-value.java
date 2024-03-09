class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        for(int i : nums1) {
            int check = i;
            for(int j : nums2) {
                if(i == j) return i;
                else if (j > i) break;
            }
        }
        return -1;
    }
}