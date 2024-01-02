class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n=0;
        for(int i=0; i<s.length(); i++)
            s = s.replace("  ", " ");
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ')
                n++;
        }

        String []Arr = new String[n+1];
        int k=0;
        String str = "";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                Arr[k++] = str;
                str = "";
            }  
            else 
                str += s.charAt(i);
        }
        Arr[k] = str;
        str = "";
        for(int i=Arr.length-1; i>=0; i--) {
            str += Arr[i];
            if(i!=0)
                str += " ";
        }
        return str;
    }
}