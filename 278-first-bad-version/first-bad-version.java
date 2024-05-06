/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1, e = n;

        while(s<=e) {
            int m = s + (e-s)/2;
            boolean isBad = isBadVersion(m);
            if(isBad) e = m-1;
            else s = m+1;
        }
        return s;
    }
}