class Solution {
    public int minCostToEqualizeArray(int[] arr, int cost1, int cost2) {
        
        int n = arr.length;
        int mod = (int)1e9+7;
        
        int max = -1;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,arr[i]);
        }
        long ops = 0;
        for(int i = 0 ; i < n ; i++){
            ops += max-arr[i];
        }
        
        if(2*cost1 <= cost2 || n < 2){
            
            return (int)((ops*1l*cost1)%mod);
        }
        
        int cnt[] = new int[max];
        for(int i = 0 ; i < n ; i++){
            cnt[max-arr[i]]++;
        }
        
        
        long ans = (ops*1l*cost1);
        ops = 0l;
        
        int l = max-1;
        int r = max-1;
        
        while(l > 0 && r > 0){
            
            while(r > 0 && cnt[r] == 0){
                r--;
            }
            if(r == 0){
                break;
            }
            while(l > 0 && cnt[l] == 0){
                l--;
            }
            if(r == l){
                if(cnt[l] <= 1){
                    l--;
                    while(l > 0 && cnt[l] == 0){
                        l--;
                    }
                }
            }
            
            if(l == 0){
                
                ans = Math.min(ans,ops+r*1l*cost1);
                
                if(n == 2){
                    break;
                }
                if(r == 1 && (n-2)%2 == 0){
                    break;
                }
                
                cnt[1] += n-2;
                l++;
                ops += cost2*1l;
            }
            
            if(l == r){
                ops += (cnt[r]/2)*1l*cost2;
                
                if(cnt[r] % 2 == 0){
                    cnt[(r-1)] += cnt[r];
                    cnt[r] = 0;
                }
                else{
                    cnt[(r-1)] += cnt[r]-1;
                    cnt[r] = 1;
                }
            }else{
                cnt[r]--;
                cnt[(r-1)]++;
                cnt[l]--;
                cnt[(l-1)]++;
                ops += cost2*1l;
            }

        }
        
        ans = Math.min(ans,(ops+r*1l*cost1));
        
        return (int)(ans%mod);
    }
}