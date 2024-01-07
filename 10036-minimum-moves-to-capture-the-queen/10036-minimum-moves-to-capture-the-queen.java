class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        
        String q = e+""+f;
        
        int tVr = c;
        int tVc = d;
        
        while(c >= 1 && d >= 1){
            c--;
            d--;
            
            if((c+""+d).equals(q)){
                return 1;
            }
            if((c+""+d).equals(a+""+b)){
                break;
            }
        }
        
        c = tVr;
        d = tVc;
        while(c >= 1 && d <= 8){
            c--;
            d++;
            
            if((c+""+d).equals(q)){
                return 1;
            }
            if((c+""+d).equals(a+""+b)){
                break;
            }
        }
        
        c = tVr;
        d = tVc;
        while(c <= 8 && d >= 1){
            c++;
            d--;
            if((c+""+d).equals(q)){
                return 1;
            }
            if((c+""+d).equals(a+""+b)){
                break;
            }
        }
        
        c = tVr;
        d = tVc;
        while(c <= 8 && d <= 8){
            c++;
            d++;
            if((c+""+d).equals(q)){
                return 1;
            }
            if((c+""+d).equals(a+""+b)){
                break;
            }
        }
        
        c = tVr;
        d = tVc;
        
        if(a == e){
            if(a == c && ((f < d && d < b)  || (b < d && d < f))){
                return 2;
            }
            
            return 1;
        }
        if(b == f){
            if(b == d && ((a < c && c < e ) || (e < c && c < a))){
                return 2;
            }
            return 1;
        }
        
        return 2;
    }
}