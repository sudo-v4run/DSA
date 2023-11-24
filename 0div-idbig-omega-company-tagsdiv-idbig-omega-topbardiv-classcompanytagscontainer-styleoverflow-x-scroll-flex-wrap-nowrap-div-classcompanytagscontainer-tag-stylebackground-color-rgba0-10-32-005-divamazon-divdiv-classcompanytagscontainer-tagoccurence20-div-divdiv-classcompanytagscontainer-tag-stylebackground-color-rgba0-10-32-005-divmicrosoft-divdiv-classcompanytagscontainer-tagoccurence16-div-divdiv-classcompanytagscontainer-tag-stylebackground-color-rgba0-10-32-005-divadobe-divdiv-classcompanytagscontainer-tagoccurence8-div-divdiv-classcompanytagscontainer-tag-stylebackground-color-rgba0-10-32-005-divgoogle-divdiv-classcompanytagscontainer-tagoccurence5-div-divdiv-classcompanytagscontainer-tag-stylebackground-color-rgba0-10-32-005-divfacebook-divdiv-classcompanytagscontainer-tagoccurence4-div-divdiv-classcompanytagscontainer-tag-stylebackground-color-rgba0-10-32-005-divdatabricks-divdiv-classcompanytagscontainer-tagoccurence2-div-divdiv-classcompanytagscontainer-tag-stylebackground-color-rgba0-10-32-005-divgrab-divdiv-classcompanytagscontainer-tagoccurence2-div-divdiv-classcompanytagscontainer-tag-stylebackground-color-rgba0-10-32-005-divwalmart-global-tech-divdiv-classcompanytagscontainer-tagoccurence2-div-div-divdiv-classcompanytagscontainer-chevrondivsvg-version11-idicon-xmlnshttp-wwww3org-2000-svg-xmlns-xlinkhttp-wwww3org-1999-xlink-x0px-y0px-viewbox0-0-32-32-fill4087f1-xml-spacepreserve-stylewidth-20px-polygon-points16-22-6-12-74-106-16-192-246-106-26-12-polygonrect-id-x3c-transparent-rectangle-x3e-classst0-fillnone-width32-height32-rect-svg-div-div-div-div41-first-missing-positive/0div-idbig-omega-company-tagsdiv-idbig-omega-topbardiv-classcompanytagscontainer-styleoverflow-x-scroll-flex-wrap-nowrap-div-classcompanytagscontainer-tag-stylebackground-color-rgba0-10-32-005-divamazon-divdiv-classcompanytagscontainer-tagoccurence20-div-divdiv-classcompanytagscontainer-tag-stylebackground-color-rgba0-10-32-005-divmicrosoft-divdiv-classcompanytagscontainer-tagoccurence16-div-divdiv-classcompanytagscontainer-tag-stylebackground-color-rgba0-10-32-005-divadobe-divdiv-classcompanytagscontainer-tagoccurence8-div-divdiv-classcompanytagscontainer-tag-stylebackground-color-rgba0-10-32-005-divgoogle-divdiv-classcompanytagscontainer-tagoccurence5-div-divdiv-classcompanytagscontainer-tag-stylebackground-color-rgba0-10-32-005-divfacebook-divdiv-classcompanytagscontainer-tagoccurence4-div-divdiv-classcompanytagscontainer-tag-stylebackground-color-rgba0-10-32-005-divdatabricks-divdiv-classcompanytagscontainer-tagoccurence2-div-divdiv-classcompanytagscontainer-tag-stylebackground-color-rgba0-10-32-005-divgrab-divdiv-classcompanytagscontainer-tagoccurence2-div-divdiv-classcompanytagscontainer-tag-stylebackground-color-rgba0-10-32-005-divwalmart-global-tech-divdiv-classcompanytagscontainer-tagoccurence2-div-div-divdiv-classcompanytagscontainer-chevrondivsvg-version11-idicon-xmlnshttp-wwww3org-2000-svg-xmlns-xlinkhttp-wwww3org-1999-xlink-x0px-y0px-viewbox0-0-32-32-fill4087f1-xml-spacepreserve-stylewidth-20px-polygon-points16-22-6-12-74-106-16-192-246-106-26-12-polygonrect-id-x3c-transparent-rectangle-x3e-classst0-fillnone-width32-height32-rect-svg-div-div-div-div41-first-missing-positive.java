class Solution {
    public int firstMissingPositive(int[] arr) {
        
        int n = arr.length;
        
        // Step 1...
        
        // We don't need -ves and we are going to mark the existing elements to negative
        // later in the Algo...so if we keep the -ves as it is, it will indicate that
        // the +ve version of it exits even if it does not...so change the initial -ves
        // to neutral.i.e (neither -ve nor +ve)...
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i]<0){
                arr[i] = 0;
            }
        }
        
        // Step 2...
        
        // Intuition -> After the first step, we have no -ves in the array.
        // Now, for eg., if 2 exists, we change the element at index 2 (val-1) to -ve. 
        // This indicates that 2 exists in the array. We do val-1 because ->
        // Array is 0 based indexing and the possible elements
        // range is [1...n], we do (index-1) .i.e. changing element at index 1 
        // to -ve indicates that 2 is present.
        
        for(int i = 0 ; i < n ; i++){
            
            int val = Math.abs(arr[i]);
            
            if(val-1 < 0 || val-1 >= n){
                continue;
            }
            
            if(arr[val-1] > 0){
                
                arr[val-1] = -arr[val-1];
            }else if(arr[val-1] == 0){
                
                // We can't change 0 to -ve. So, we change it to out of bound value.i.e n+2
                // which can never be the answer coz the worst case answer is n+1 only.
                
                arr[val-1] = -(n+2);
            }
            
        }
        
        // Step 3....
        
        // We check if any value in [1...n] does not exits in the array. 
        // .i.e If element at val-1 index is not -ve, then it means, val does not exists
        // and since we go from 1---n, we return the ans as soon as any val does not exists..
        // Also, in the step 2, we changed the 0 to -(n+2).. so, if we again get 0, that 
        // that means, that index+1 val does not exists...
        
        for(int i = 1 ; i <= n ; i++){
            if(arr[i-1] >= 0){
                return i;
            }
        }
        
        return n+1;
    }
}