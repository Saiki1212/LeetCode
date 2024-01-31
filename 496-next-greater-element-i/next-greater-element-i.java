class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        int []ans = new int [n1];
        int k =0;
        for(int i = 0; i < n1; i++) {
            int j=0;
            while(nums2[j] != nums1[i])
                j++;
            int val = nums2[j];
            j++;
            if(j == n2) {
                ans[k++] = -1;
                continue;
            }
            for(j = j; j<n2; j++) {
                if(nums2[j] > val) {
                    ans[k++] = nums2[j];
                    break;
                }
                if(j == n2-1 && nums2[j] < val)
                    ans[k++] = -1;
            }
        }
        return ans;
    }
}