class Solution {
    public boolean[] isArraySpecial(int[] arr, int[][] queries) {
        
        int n = arr.length;
        
        int prefix[] = new int[n];
        
        for(int i = 1 ; i < n ; i++){
            
            if(arr[i]%2 == 0 && arr[i-1]%2 == 0){
                
                prefix[i] = prefix[i-1]+1;
            }else if(arr[i]%2 != 0 && arr[i-1]%2 != 0){
                
                prefix[i] = prefix[i-1]+1;
            }else{
                prefix[i] = prefix[i-1];
            }
        }
        
        boolean res[] = new boolean[queries.length];
        int index = 0;
        
        for(int q[] : queries){
            
            int l = q[0];
            int r = q[1];
            
            int cnt = prefix[r]-prefix[l];
            // if(l > 0){
            //     cnt = prefix[r]-prefix[l-1];
            // }
            
            if(cnt == 0){
                res[index] = true;
            }else{
                res[index] = false;
            }
            index++;
        }
        
        return res;
    }
}