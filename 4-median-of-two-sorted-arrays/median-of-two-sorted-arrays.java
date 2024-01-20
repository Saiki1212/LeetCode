class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 == 0 && n2 == 0)
            return 0;
        int [] a = new int[n1+n2];
        int i=0, j=0, k=0;
        while(i < n1 && j < n2) {
            if(nums1[i] <= nums2[j])
                a[k++] = nums1[i++];
            else 
                a[k++] = nums2[j++];
        }

        while(i < n1)
            a[k++] = nums1[i++];
        
        while(j < n2)
            a[k++] = nums2[j++];
        
        if(k % 2 == 0) 
            return (a[k/2] + a[k/2 - 1])/2.0;

        return a[k/2];
    }
}