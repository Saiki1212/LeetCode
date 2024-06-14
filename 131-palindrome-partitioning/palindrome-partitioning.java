class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();

        findAll(list, new ArrayList<>(), s, 0);
        return list;
    }

    public static void findAll(List<List<String>> list, List<String> temp, String s, int idx) {
        if(idx == s.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<s.length(); i++) {
            if(isPal(s,i, idx)) {
                temp.add(s.substring(idx, i+1));
                findAll(list, temp, s, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean isPal(String s, int j, int i) {
        while( i<j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}