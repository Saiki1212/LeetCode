class Solution {
    StringBuilder first_stack_Builder, second_stack_Builder;
    public int maximumGain(String s, int x, int y) {
        String remove_first, remove_second;
        int high_score, low_score;

        if(x >= y) {
            remove_first = "ab";
            remove_second = "ba";
            high_score = x;
            low_score = y;
        }
        else {
            remove_first = "ba";
            remove_second = "ab";
            high_score = y;
            low_score = x;
        }

        int maxScore = 0;
        first_stack_Builder = new StringBuilder();
        maxScore = removeAllOccurances(remove_first, high_score, s);

        second_stack_Builder = new StringBuilder();
        maxScore += removeAllOccurances(remove_second, low_score);

        return maxScore;
    }

    public int removeAllOccurances(String removeString, int score, String s) {
        int totalScore = 0;

        for(char ch : s.toCharArray()) {
            if(isRemovable(ch, removeString, first_stack_Builder)) {
                totalScore += score;
                first_stack_Builder.setLength(first_stack_Builder.length() - 1);
            }
            else {
                first_stack_Builder.append(ch);
            }
        }

        return totalScore;
        
    }

    public int removeAllOccurances(String removeString, int score) {
        int totalScore = 0;
        
        for(char ch : first_stack_Builder.toString().toCharArray()) {
            if(isRemovable(ch, removeString, second_stack_Builder)) {
                totalScore += score;
                second_stack_Builder.setLength(second_stack_Builder.length() - 1);
            }
            else {
                second_stack_Builder.append(ch);
            }
        }

        return totalScore;

    }

    public boolean isRemovable(char ch, String removestring, StringBuilder first_stack_Builder) {
        return (
            removestring.charAt(1) == ch && first_stack_Builder.length() > 0 &&
            first_stack_Builder.charAt(first_stack_Builder.length() - 1) == removestring.charAt(0)
        );
    }
}