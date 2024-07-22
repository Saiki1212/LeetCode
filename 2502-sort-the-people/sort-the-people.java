class Solution {
    class NameWithHeight implements Comparable<NameWithHeight> {
        String name;
        int height;

        NameWithHeight(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public int compareTo(NameWithHeight obj1) {
            return obj1.height - this.height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {

        List<NameWithHeight> nameHeightList = new ArrayList<>();

        int n = names.length;

        for(int i = 0; i<n; i++) {
            NameWithHeight nameHeight = new NameWithHeight(names[i], heights[i]);
            nameHeightList.add(nameHeight);
        }

        Collections.sort(nameHeightList);

        for(int i = 0; i<n; i++) {
            names[i] = nameHeightList.get(i).name;
        }

        return names;
        
    }
}