class Solution {

    public static void GetPatterns(List<String> list, Map<Character, String> nums, String s, String digits, int i) {
        if(i == digits.length()) {
            list.add(s);
            return;
        }

        String curr = nums.get(digits.charAt(i));

        for(int j = 0; j<curr.length(); j++) {
            GetPatterns(list, nums, s+curr.charAt(j), digits, i+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        Map<Character, String> nums = new HashMap<>();
        nums.put('2', "abc");
        nums.put('3', "def");
        nums.put('4', "ghi");
        nums.put('5', "jkl");
        nums.put('6', "mno");
        nums.put('7', "pqrs");
        nums.put('8', "tuv");
        nums.put('9', "wxyz");

        GetPatterns(list, nums, "", digits, 0);
    
        return list;

    }
}