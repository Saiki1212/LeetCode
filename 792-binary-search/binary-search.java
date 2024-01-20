class Solution {
    public int search(int[] Arr, int target) {
        int s = 0, e = Arr.length;
        while(s<e) {
            int m = (s+e)/2;
            if(Arr[m] == target)
                return m;
            else if(Arr[m] < target)
                s++;
            else 
                e--;
        }
        return -1;
    }
}