class Solution {
    class Pair{
        int min, max;
        Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public int[] findIndices(int[] arr, int indexDifference, int valueDifference) {
        
        int n = arr.length;
        Pair suff[] = new Pair[n];
        
        suff[n-1] = new Pair(arr[n-1],arr[n-1]);
        
        for(int i = n-2 ; i >=0 ; i--){
            int newMin = Math.min(arr[i],suff[i+1].min);
            int newMax = Math.max(arr[i],suff[i+1].max);
            
            suff[i] = new Pair(newMin,newMax);
        }
        
        for(int i = 0 ; i < n ; i++){
            int j = i + indexDifference;
            
            if(j >= n){
                continue;
            }
            
            if(Math.abs(arr[i]-suff[j].min) >= valueDifference || 
               Math.abs(arr[i]-suff[j].max) >= valueDifference){
                
                // We found an ans...find that index..
                
                for(int k = j ; k < n ; k++){
                    if(Math.abs(arr[i]-arr[k]) >= valueDifference){
                        return new int[]{i,k};
                    }
                }
            }
        }
        
        return new int[]{-1,-1};
    }
}