class Solution {
    public String replaceWords(List<String> dic, String sen) {
        int d = dic.size();
        String [] sent = sen.split(" ");
        int s = sent.length;

        for(int i=0; i<d; i++) {
            for(int j = 0; j<d; j++) {
                if(j != i && dic.get(j).startsWith(dic.get(i))) {
                    dic.set(j, dic.get(i));
                }
            }
        }

        for(int i = 0; i<s; i++) {
            String str = sent[i];
            for(int j = 0; j<d; j++) {
                if (str.startsWith(dic.get(j))) {
                    sent[i] = dic.get(j);
                    break;
                }
            }
        }
        String st = String.join(" ", sent);
        return st;
    }
}