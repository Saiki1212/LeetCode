class Solution {
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums;
        mergeSort(nums, 0, n-1);
        return nums;
    }

    public void mergeSort(int[] nums, int s, int e) {
        if( s >= e) return;

        int mid = (s+e)>>1;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid+1, e);
        mergeNums(nums, s, e, mid);
    }

    public void mergeNums(int[] nums, int s, int e, int mid) {
        int n1 = mid-s+1, n2 = e-mid;

        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for(int i = 0; i<n1; i++) {
            arr1[i] = nums[s+i];
        }
        for(int i = 0; i<n2; i++) {
            arr2[i] = nums[mid+i+1];
        }

        int i = 0, j = 0, k = s;

        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j]) nums[k] = arr1[i++];
            else nums[k] = arr2[j++];
            k++;
        }

        while(i < n1) {
            nums[k++] = arr1[i++];
        }

        while(j < n2) {
            nums[k++] = arr2[j++];
        }
    }
}