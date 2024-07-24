class Solution {

    class Pair implements Comparable<Pair> {
        int num, mapVal;

        Pair(int num, int mapVal) {
            this.num = num;
            this.mapVal = mapVal;
        }

        public int compareTo(Pair b) {
            return this.mapVal - b.mapVal;
        }

    }

    public int getMapVal(int val, int num, int[] mapping) {

        if(num >= 0 && num <= 9) return mapping[num];

        int n = num % 10;
        val = val * 10 + getMapVal(val, num/10, mapping);
        return val = val * 10 + mapping[n];
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Pair> map = new ArrayList<>();

        int n = nums.length;

        for(int i = 0; i<n; i++) {
            int mapVal = getMapVal(0, nums[i], mapping);
            map.add(new Pair(nums[i], mapVal));
        }

        Collections.sort(map);

        for(int i = 0; i<n; i++) {
            nums[i] = map.get(i).num;
        }

        return nums;

    }
}