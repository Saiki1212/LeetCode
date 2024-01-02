class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] n1 = new boolean[2001];
        boolean[] n2 = new boolean[2001];

        ArrayList<Integer> dif1 = new ArrayList<>();
        ArrayList<Integer> dif2 = new ArrayList<>();

        for (int num : nums1) {
            n1[num + 1000] = true;
        }

        for (int num : nums2) {
            n2[num + 1000] = true;

            if (!n1[num + 1000]) {
                n1[num + 1000] = true;
                dif2.add(num);
            }
        }

        for (int num : nums1) {
            if (!n2[num + 1000]) {
                n2[num + 1000] = true;
                dif1.add(num);
            }
        }

        return List.of(dif1, dif2);
    }
}