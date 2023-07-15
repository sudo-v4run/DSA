class Solution {
    public int minEatingSpeed(int[] piles, int hr) {
        
        int n = piles.length;
        
        int max = -1;
        
        for(int i : piles){
            max = Math.max(max,i);
        }
        
        int l = 1;
        int h = max;
        while(l <= h){
            int m = l+(h-l)/2;
            
            long reqHrs = requiredHrs(m,piles);
            
            if(reqHrs <= hr){
                h = m-1;
            }else{
                l = m+1;
            }
        }
        
        return l;
    }
    public static long requiredHrs(int k,int piles[]){
        
        long ans = 0;
        
        for(int i : piles){
            ans += i/k;
            if(i % k != 0){
                ans++;
            }
        }
        
        return ans;
    }
}