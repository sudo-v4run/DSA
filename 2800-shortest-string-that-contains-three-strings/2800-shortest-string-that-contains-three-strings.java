class Solution {
    public String minimumString(String a, String b, String c) {
        
        String arr[] = {a,b,c};
        int n = arr.length;
        
        String res = "";
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    if(i != j && j != k && i != k){
                        String merged = merge(arr[i],arr[j]);
                        merged = merge(merged,arr[k]);
                        
                        if(res == "" || res.length() > merged.length() 
                          || (res.length() == merged.length()
                          && merged.compareTo(res) < 0)){
                            
                            res = merged;
                        }
                    }
                }
            }
        }
        
        return res;
    }
    public static String merge(String a, String b){
        
        if(a.indexOf(b) != -1){
            return a;
        }
        
        int na = a.length();
        int nb = b.length();
        
        for(int i = Math.min(na,nb) ; i > 0 ; i--){
            if(a.substring(na-i).equals(b.substring(0,i))){
                
                return a+b.substring(i);
            }
        }
        
        return a+b;
    }
}