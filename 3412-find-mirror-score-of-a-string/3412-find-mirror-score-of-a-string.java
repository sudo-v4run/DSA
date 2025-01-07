class Solution {
    public long calculateScore(String s) {

        int n = s.length();
        
        long ans = 0;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            
            char cur = s.charAt(i);
            int curInt = cur-'a';

            

            int mirror;

            if(curInt < (26/2)){
                mirror = 25-curInt;
            }else{
                mirror = 25-curInt;
            }

            boolean f = false;
            if(hm.containsKey(mirror)){
                f = true;
                int sz = hm.get(mirror).size();
                ans += i-hm.get(mirror).get(sz-1);
               // System.out.println(i+","+hm.get(mirror).get(sz-1)+","+mirror);
                hm.get(mirror).remove(sz-1);
                if(hm.get(mirror).size() == 0){
                    hm.remove(mirror);
                }
            }

            

            if(!f){
                if(!hm.containsKey(curInt)){
                    hm.put(curInt, new ArrayList<>());
                }
                hm.get(curInt).add(i);
            }
                
        }

        return ans;
    }
}