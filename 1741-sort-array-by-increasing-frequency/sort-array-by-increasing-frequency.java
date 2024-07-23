class Solution {

    class Freq implements Comparable<Freq> {
        int num, freq;
        Freq(int num, int _freq) {
            this.num = num;
            freq = _freq;
        }

        public int compareTo(Freq obj) {
            if(obj.freq == this.freq) return obj.num - this.num;
            return this.freq - obj.freq;
        }

    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
        }

        List<Freq> list = new ArrayList<>();
        freqMap.forEach((key, value) -> {
            Freq newFreq = new Freq(key, value);
            list.add(newFreq);
        });

        Collections.sort(list);

        int i = 0;

        for(Freq pair : list) {
            int n = pair.freq;
            for(int k = 1; k<=n; k++) nums[i++] = pair.num;
        }
        return nums;
    }
}