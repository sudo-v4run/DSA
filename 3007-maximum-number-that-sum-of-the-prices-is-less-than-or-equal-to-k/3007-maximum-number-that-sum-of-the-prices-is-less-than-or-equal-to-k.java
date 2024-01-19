class Solution {
    public long findMaximumNumber(long k, int x) {
        
        long lo = 1;
        long hi = (long)1e15;
        
        long ans = -1;
        
        while(lo <= hi){
            
            long mid = (lo+hi)/2;
            
            if(isPossible(mid,x,k)){
                ans = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        
        return ans;
    }
    public long cnt[];
    public boolean isPossible(long num, int x, long k){
        
        cnt = new long[65];
        
        
        getOneCnt(num);
        
        
        long price = 0;
        
        for(int i = 1 ; i < cnt.length ; i++){
            if((i) % x == 0){
                price += cnt[i];
            }
        }
        
//         if(price <= k){
//             System.out.println(num);
        
//             for(long ele : cnt){
//                 System.out.print(ele+"  ");
//             }
//             System.out.println();
//         }
        
        return price <= k;
    }
    public void getOneCnt(long num){
        
        if(num == 0){
            return;
        }
        
        int x = 0;
        while((1L<<x) <= num){
            x++;
        }
        x--;
        
        long nearest2Power = 1L<<x;
        
        for(int i = 1 ; i <= x ; i++){
            cnt[i] += nearest2Power/2;
        }
        cnt[x+1] += num-nearest2Power+1;
        
        getOneCnt(num-nearest2Power);
    }
}