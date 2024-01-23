class Solution {
    private int res = 0;
    public int maxLength(List<String> arr) {
        int n = arr.size();
        // if(n == 1) return arr.get(0).length();
        DFS(arr, "", 0);
        return res;
    }

    private void DFS(List<String> dp, String path, int idx) {
        boolean isUnique = checkUnique(path);
        if(isUnique) res = Math.max(path.length(), res);
        if(idx == dp.size() || !isUnique) return;
        for(int i = idx; i<dp.size(); i++)
            DFS(dp, path+dp.get(i), i+1);
    }

    private boolean checkUnique(String path) {
        Set<Character> set = new HashSet<>();
        for(char c : path.toCharArray()) {
            if(set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}