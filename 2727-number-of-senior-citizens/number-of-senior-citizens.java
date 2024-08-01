class Solution {
    public int countSeniors(String[] details) {
        int n = details.length;
        int noOfPassegengersAgeGreaterThan60 = 0;

        for(int i = 0; i<n; i++) {
            int digit1ofAge = details[i].charAt(11) - '0';
            int digit2ofAge = details[i].charAt(12) - '0';

            int ageOfPassenger = digit1ofAge * 10 + digit2ofAge;
            if(ageOfPassenger > 60) {
                noOfPassegengersAgeGreaterThan60++;
            }
        }
        return noOfPassegengersAgeGreaterThan60;
    }
}