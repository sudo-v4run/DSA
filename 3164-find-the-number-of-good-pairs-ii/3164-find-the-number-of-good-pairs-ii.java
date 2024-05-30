class Solution {
    public long numberOfPairs(int[] arr1, int[] arr2, int k) {
        
        // Using Factors....
        
        int n = arr1.length;
        int m = arr2.length;
        
        for(int i = 0 ; i < m ; i++){
            arr2[i] = arr2[i]*k;
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int x : arr2){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        
        long ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            int cur = arr1[i];
            // iterate through all the factors for current ele...
            for(int j = 1 ; j <= Math.sqrt(cur) ; j++){
                if(cur%j == 0){     // factor
                    ans += hm.getOrDefault(j,0);
                    if(cur/j != j){
                        ans += hm.getOrDefault(cur/j,0);
                    }
                    
                }
            }
            
        }
        
        return ans;
        
        
        // Using Multiples....
        
//         int n = arr1.length;
//         int m = arr2.length;
        
//         for(int i = 0 ; i < n ; i++){
//             if(arr1[i]%k == 0){
//                 arr1[i] = arr1[i]/k;
//             }else{
//                 arr1[i] = -1;
//             }
//         }
        
//         HashMap<Integer,Integer> freqArr1 = new HashMap<>();
        
//         for(int i = 0 ; i < n ; i++){
//             if(arr1[i] == -1){
//                 continue;
//             }
            
//             freqArr1.put(arr1[i],freqArr1.getOrDefault(arr1[i],0)+1);
//         }
        
//         HashMap<Integer,Integer> freqArr2 = new HashMap<>();
        
//         for(int i = 0 ; i < m ; i++){
            
//             freqArr2.put(arr2[i],freqArr2.getOrDefault(arr2[i],0)+1);
//         }
        
//         long ans = 0;
        
//         for(int ele : freqArr2.keySet()){
            
//             // multiples...
            
//             for(int i = ele ; i <= (int)1e6 ; i=i+ele){
//                 if(freqArr1.containsKey(i)){
//                     ans += freqArr2.get(ele)*freqArr1.get(i);
//                 }
//             }
//         }
        
//         return ans;
    }
}