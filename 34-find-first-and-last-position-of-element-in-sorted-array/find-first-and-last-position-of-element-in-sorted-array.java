class Solution {
    public int[] searchRange(int[] a, int x) {
        int s = 0, e = a.length-1, val1 = -1;
      // Floor.......
      while(s<=e) {
        int m = (s+e)/2;
        if(a[m] <= x) {
          val1 = m;
          s = m+1;
        }
        else e = m-1;
      }
      if(val1 != -1)
        val1 = a[val1] == x ? val1 : -1;

      // Ceil......

      s = 0; e = a.length-1;
      int val = -1;

      while(s<=e) {
        int m = (s+e)/2;
        if(a[m] >= x) {
          val = m;
          e = m-1;
        }
        else s = m+1;
      }
      if(val != -1)
        val = a[val] == x ? val : -1;

      return new int[]{val, val1};
    }
}