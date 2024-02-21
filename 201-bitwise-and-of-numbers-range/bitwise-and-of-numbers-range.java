class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int val = 0;
        while(left != right) {
            left = left >> 1;
            right = right >> 1;
            val++;
        }
        return left << val;
    }
}