class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        int x = num;
        int divide = 1;
        while(x>0){
            x=x/10;
            divide *=2;
        }
      
        for (int i =1 ; i <= num/divide  ; i++){

            if(i*i== num){
                return true;
            }
        
        }

    return false ;
        
    }
}