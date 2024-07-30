class Solution {
    public int numberOfSubstrings(String s) {
        
        int n = s.length();
        
        ArrayList<Integer> zeroInds = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '0'){
                zeroInds.add(i);
            }
        }
        
        int i = 0;
        
        int ans = 0;
        
        for(int l = 0 ; l < n ; l++){
            while(i < zeroInds.size() && zeroInds.get(i) < l){
                i++;
            }
            
            ArrayList<Integer> validZeroInds = new ArrayList<>();
            for(int j = i ; j < zeroInds.size() && j < (i+201) ; j++){
                validZeroInds.add(zeroInds.get(j));
            }
            validZeroInds.add(n);
            
            int z = 0;
            int prev = l;
            
            for(int r : validZeroInds){
                int minReqOnes = z*z;
                int minValidInd = Math.max(l+z+minReqOnes-1,prev);  
                                            // -1 coz prev is exclusive
                if(minValidInd < r){
                    ans += r-minValidInd;
                }
                z++;
                prev = r;
            }
        }
        
        return ans;
    }
}