class Solution {

    public static void GetPatterns(List<String> list, String[] nums, StringBuilder s, String digits, int i) {
        if(i == digits.length()) {
            list.add(s.toString());
            return;
        }

        String curr = nums[digits.charAt(i)-'0'-2];

        for(int j = 0; j<curr.length(); j++) {
            GetPatterns(list, nums, s.append(curr.charAt(j)), digits, i+1);
            s.deleteCharAt(s.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        String nums[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        GetPatterns(list, nums, new StringBuilder(), digits, 0);
    
        return list;

    }
}