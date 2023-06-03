class Solution {
    static class Pair{
        int val,i;
        
        Pair(int val, int i){
            this.val = val;
            this.i = i;
        }
    }
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        
        if(n == 1){
            return 1;
        }
        
        int c[] = new int[n];
        Arrays.fill(c,1);
        
        Pair arr[] = new Pair[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Pair(ratings[i],i);
        }
        
        Arrays.sort(arr,(a,b)->{return a.val-b.val;});
        
        for(int i = 0 ; i < n ; i++){
            
            int left =  arr[i].i-1;
            int right = arr[i].i+1;
            
            int cur = arr[i].val;
            
            if( left >= 0 && right <= n-1 && 
                ratings[left] < cur && cur > ratings[right] ){
                
                c[arr[i].i] = Math.max(c[left],c[right])+1;
            }else if(left >= 0  && ratings[left] < cur){
                
                c[arr[i].i] = c[left]+1;
            }else if(right <= n-1 && cur > ratings[right]){
                
                c[arr[i].i] = c[right]+1;
            }
        }
        
        int ans = 0;
        
        for(int i : c){
            ans += i;
        }
        
        return ans;
    }
}