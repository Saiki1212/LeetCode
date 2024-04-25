class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 == 0 && n2 == 0) return 0;
        if(n1 == 0) {
            if(n2 % 2 != 0) return nums2[n2/2];
            else return (double) (nums2[n2/2]+nums2[(n2-2)/2])/2.0;
        }
        else if(n2 == 0) {
            if(n1 % 2 != 0) return nums1[n1/2];
            else return (double) (nums1[n1/2]+nums1[(n1-2)/2])/2.0;
        }
        int len = n1+n2;
        boolean flag = len % 2 == 0;

        if(flag) {
            int i=0, j=0, k=0, pre = 0;
            int mid = len/2;
            while(i<n1 && j<n2) {
                if(nums1[i] < nums2[j]) pre = nums1[i++];
                else pre = nums2[j++];
                k++;
                if(k == mid) {
                    if( i>=n1 ) return (double) (pre + nums2[j])/2.0;
                    else if(j>=n2) return (double) (pre + nums1[i])/2.0;
                    else if(nums1[i]<nums2[j]) return (double) (pre + nums1[i])/2.0;
                    else return (double) (pre + nums2[j])/2.0;
                }
            }

            while(i<n1) {
                pre = nums1[i++];
                k++;
                if(k == mid) return (double) (pre + nums1[i])/2.0;
            }
            while(j<n2) {
                pre = nums2[j++]; k++;
                if(k == mid) return (double) (pre + nums2[j])/2.0;
            }

        }
        else {
            int i=0, j=0, k=0;
            int mid = len/2;
            while(i<n1 && j<n2) {
                if(nums1[i] < nums2[j]) i++;
                else j++;
                k++;
                if(k == mid) {
                    if( i>=n1 ) return nums2[j];
                    else if(j>=n2) return nums1[i];
                    else if(nums1[i]<nums2[j]) return nums1[i];
                    else return nums2[j];
                }
            }

            while(i<n1) {
                i++;
                k++;
                if(k == mid) return nums1[i];
            }
            while(j<n2) {
                j++; k++;
                if(k == mid) return nums2[j];
            }

        }
        return 0;
    }
}