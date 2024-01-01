class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int avg = n/4;
        for(int i=0; i<n; i++) {
            if((i + avg < n) && (arr[i] == arr[i + avg])) {
                return arr[i];
            }
        }
        return -1;
    }
}