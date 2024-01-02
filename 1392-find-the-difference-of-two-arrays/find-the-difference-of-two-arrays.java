class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        List<Integer> l1 = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i=0; i<n1; i++)
            if(!l1.contains(nums1[i]))
                l1.add(nums1[i]);
        for(int i=0; i<n2; i++)
            if(!l2.contains(nums2[i]))
                l2.add(nums2[i]);
        list.add(new ArrayList<>());
        for(int i=0; i<l1.size(); i++) {
            int num = l1.get(i);
            if(!l2.contains(num) && !list.contains(num)) {
                list.get(0).add(num);
            }
        }

        list.add(new ArrayList<>());
        for(int i=0; i<l2.size(); i++) {
            int num = l2.get(i);
            if(!l1.contains(num) && !list.contains(num)) {
                list.get(1).add(num);
            }
        }
        return list;
    }
}