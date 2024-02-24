class Solution {
    public int search(int[] Arr, int target) {
        int i =  Arrays.binarySearch(Arr, target);
        return i < 0 ? -1 : i;
    }
}