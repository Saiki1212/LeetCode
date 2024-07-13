class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] hel, String dir) {
        int n = pos.length; 

        Integer[] indices = new Integer[n];
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        Arrays.sort(
            indices,
            (lhs, rhs) -> Integer.compare(pos[lhs], pos[rhs])
        );

        for(int idx : indices) {
            if(dir.charAt(idx) == 'R') {
                stack.push(idx);
                continue;
            }

            while(!stack.isEmpty() && hel[idx] > 0) {
                int topIdx = stack.pop();

                if(hel[topIdx] > hel[idx]) {
                    hel[topIdx]--;
                    hel[idx] = 0;
                    stack.push(topIdx);
                }
                else if(hel[topIdx] < hel[idx]) {
                    hel[idx]--;
                    hel[topIdx] = 0;
                }
                else {
                    hel[idx] = 0;
                    hel[topIdx] = 0;
                }
            }
        }

        for (int index = 0; index < n; ++index) {
            if (hel[index] > 0) {
                res.add(hel[index]);
            }
        }
        return res;

    }
}