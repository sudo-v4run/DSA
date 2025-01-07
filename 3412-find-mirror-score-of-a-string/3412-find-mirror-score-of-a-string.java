class Solution {
    public long calculateScore(String s) {

        int n = s.length();
        
        long ans = 0;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            
            char cur = s.charAt(i);
            int curInt = cur-'a';

            int mirror = 25-curInt;
            
            boolean flag = false;
            if(hm.containsKey(mirror)){
                flag = true;
                int sz = hm.get(mirror).size();
                ans += i-hm.get(mirror).get(sz-1);
                hm.get(mirror).remove(sz-1);
                if(hm.get(mirror).size() == 0){
                    hm.remove(mirror);
                }
            }

            

            if(!flag){
                if(!hm.containsKey(curInt)){
                    hm.put(curInt, new ArrayList<>());
                }
                hm.get(curInt).add(i);
            }
                
        }

        return ans;
    }
}