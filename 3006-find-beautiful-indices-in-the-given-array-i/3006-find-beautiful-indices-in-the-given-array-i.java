class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        
        int n = s.length();
        int alen = a.length();
        int blen = b.length();
        
        List<Integer> res = new ArrayList<>();
        
        HashSet<Integer> bInds = new HashSet<>();
        
        for(int i = 0 ; i <= n-blen ; i++){
            int bi = 0;
            boolean flag = true;
            for(int j = i ; j < i+blen ; j++){
                if(s.charAt(j) != b.charAt(bi)){
                    flag = false;
                    break;
                }
                bi++;
            }
            if(flag){
                bInds.add(i);
            }
        }
        
        for(int i = 0 ; i <= n-alen ; i++){
            int ai = 0;
            boolean flag = true;
            for(int j = i ; j < i+alen ; j++){
                if(s.charAt(j) != a.charAt(ai)){
                    flag = false;
                    break;
                }
                ai++;
            }
            if(flag){
                for(int index : bInds){
                    if(Math.abs(i-index) <= k){
                        res.add(i);
                        break;
                    }
                }
            }
        }
        
        return res;
    }
}