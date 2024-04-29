class Solution {

    public static void GetPatterns(List<String> list, String[] nums, String s, String digits, int i) {
        if(i == digits.length()) {
            list.add(s);
            return;
        }

        String curr = nums[digits.charAt(i)-'0'];

        for(int j = 0; j<curr.length(); j++) {
            GetPatterns(list, nums, s+curr.charAt(j), digits, i+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        String nums[] = {"", "","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        GetPatterns(list, nums, "", digits, 0);
    
        return list;

    }
}