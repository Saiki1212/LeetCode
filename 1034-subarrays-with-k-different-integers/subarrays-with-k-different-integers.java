class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        return FindVal(nums, n, k) - FindVal(nums, n, k-1);
    }

    public static int FindVal(int [] nums, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int i = 0, j = 0;
        while(i < n) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.size() > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }

            len += (i - j + 1);
            i++;
        }
        return len;
    }
}