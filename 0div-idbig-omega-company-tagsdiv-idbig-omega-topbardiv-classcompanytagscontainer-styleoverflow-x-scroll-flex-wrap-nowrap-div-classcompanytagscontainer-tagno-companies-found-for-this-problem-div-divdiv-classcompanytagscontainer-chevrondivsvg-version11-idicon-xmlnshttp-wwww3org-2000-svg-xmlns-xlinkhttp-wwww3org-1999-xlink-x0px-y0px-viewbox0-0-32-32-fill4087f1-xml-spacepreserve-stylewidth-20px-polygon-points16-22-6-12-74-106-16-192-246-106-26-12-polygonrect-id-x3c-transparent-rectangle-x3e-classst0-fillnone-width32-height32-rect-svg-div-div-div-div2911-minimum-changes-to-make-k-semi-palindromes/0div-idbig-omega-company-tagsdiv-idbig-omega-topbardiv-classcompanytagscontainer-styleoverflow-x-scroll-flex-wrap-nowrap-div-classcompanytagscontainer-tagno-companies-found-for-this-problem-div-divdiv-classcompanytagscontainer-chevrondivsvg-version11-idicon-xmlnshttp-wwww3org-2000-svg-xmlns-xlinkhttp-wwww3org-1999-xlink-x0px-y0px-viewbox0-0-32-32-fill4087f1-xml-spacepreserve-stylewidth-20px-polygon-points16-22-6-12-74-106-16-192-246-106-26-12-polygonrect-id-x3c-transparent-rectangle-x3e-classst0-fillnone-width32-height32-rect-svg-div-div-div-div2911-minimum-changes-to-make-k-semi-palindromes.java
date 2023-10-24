class Solution {
    HashMap<String,Integer> map;
    public int minimumChanges(String s, int k) {
        
        int n = s.length();
        map = new HashMap<>();
        
        int dp[][] = new int[n][k+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        // for all the substrings, pre-compute minimum count of changes required to
        // make them semi-palindrome so that we can directly use it in f() without 
        // computing again...
        getChangesSum(s);
        
        int ans = f(0,k,s,dp);
        
        return ans;
    }
    public int f(int index, int k, String s, int dp[][]){
        
        int n = s.length();
        
        if(k < 0){
            return (int)1e7;
        }
        
        if(index >= n){
            if(k == 0){
                return 0;
            }
            return (int)1e7;
        }
        
        if(dp[index][k] != -1){
            return dp[index][k];
        }
        
        int ans = (int)1e7;
        for(int i = index ; i < n ; i++){
            int cur = map.get(index+" "+i) + f(i+1,k-1,s,dp);
            ans = Math.min(ans,cur);
        }
        
        return dp[index][k] = ans;
    }
    public void getChangesSum(String str){
        
        int n = str.length();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int ans = (int)1e7;
                
                int len = j-i+1;
        
                for(int d = 1 ; d < len ; d++){
                    if(len % d != 0){
                        continue;
                    }
                    
                    HashMap<Integer,ArrayList<Character>> hm = new HashMap<>();
                    for(int index = i ; index <= j ; index++){
                        int modulus = index%d;

                        if(!hm.containsKey(modulus)){
                            hm.put(modulus,new ArrayList<Character>());
                        }
                        hm.get(modulus).add(str.charAt(index));
                    }

                    int cnt = 0;
                    for(ArrayList<Character> arr : hm.values()){
                        int s = 0;
                        int e = arr.size()-1;
                        while(s < e){
                            if(arr.get(s) != arr.get(e)){
                                cnt++;
                            }
                            s++;
                            e--;
                        }
                    }
                    ans = Math.min(ans,cnt);
                }
                
                map.put(i+" "+j,ans);
            }
        }
    }
}