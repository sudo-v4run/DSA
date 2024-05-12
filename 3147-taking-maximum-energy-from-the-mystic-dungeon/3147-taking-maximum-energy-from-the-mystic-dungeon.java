class Solution {
    public int maximumEnergy(int[] energy, int k) {
        
        int ans = Integer.MIN_VALUE;
        
        int n = energy.length;
        
        for(int i = n-1 ; i >= n-k ; i--){
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for(int j = i ; j >= 0 ; j = j-k){
                sum = sum+energy[j];
                max = Math.max(max,sum);
            }
            ans = Math.max(ans,max);
        }
        
        return ans;
    }
}