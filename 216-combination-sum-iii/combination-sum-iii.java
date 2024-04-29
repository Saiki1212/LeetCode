class Solution {

    public static void GetAllSumK(List<List<Integer>> list, List<Integer> temp, int i, int sum, int k) {
        if(sum <= 0 && temp.size() != k) return;
        if(sum == 0 && temp.size() == k) {
            if(!list.contains(temp))
                list.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j<10; j++) {
            temp.add(j);
            GetAllSumK(list, temp, j+1, sum-j, k);
            temp.remove(temp.size()-1);
            // GetAllSumK(list, temp, j+1, sum, k);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        GetAllSumK(list, new ArrayList<>(), 1, sum, k);
        return list;
    }
}