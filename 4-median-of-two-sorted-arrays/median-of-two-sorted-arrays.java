class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int len = n1+n2;
        int idx2 = len/2, idx1 = (len/2)-1, ele1 = 0, ele2 = 0;

        int i = 0, j = 0, k = 0, pre = 0;
        while( i<n1 && j<n2 ) {
            if(nums1[i] < nums2[j]) pre = nums1[i++];
            else pre = nums2[j++];

            if(k == idx1) ele1 = pre;
            if(k == idx2) ele2 = pre;
            k++;
        }
        while(i<n1) {
            pre = nums1[i++];
            if(k == idx1) ele1 = pre;
            if(k == idx2) ele2 = pre;
            k++;
        }
        while(j<n2) {
            pre = nums2[j++];
            if(k == idx1) ele1 = pre;
            if(k == idx2) ele2 = pre;
            k++;
        }

        if(len % 2 == 0) {
            return (double) (ele1+ele2)/2.0;
        }
        return ele2;
    }
}