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
            
            int reqHrs = requiredHrs(m,piles);
            
            if(reqHrs <= hr){
                h = m-1;
            }else{
                l = m+1;
            }
        }
        
        return l;
    }
    public static int requiredHrs(int k,int piles[]){
        
        int ans = 0;
        
        for(int i : piles){
            ans += Math.ceil((double)i/k);
        }
        
        return ans;
    }
}