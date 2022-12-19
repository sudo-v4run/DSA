class Solution {
    public int lengthOfLIS(int[] arr) {
        
        int n = arr.length;
        
        // Binary Search...TC - O(N logN) and SC - O(N)...-> can not print LIS(only len)
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        temp.add(arr[0]);
        int len = 1;
        for(int i = 1 ; i < n ; i++){
            if(arr[i]>temp.get(temp.size()-1)){
                temp.add(arr[i]);
                len++;
            }else{
                int lowerBoundIndex = lowerBound(temp,arr[i]);
                temp.set(lowerBoundIndex,arr[i]);
            }
        }
        
        return len;
        
        
        // Tabulation.... O(N) SC....
        
//         int dp[] = new int[n];
//         int max = 1;
        
//         for(int index = 0 ; index < n ; index++){
//             dp[index] = 1;
//             for(int prevInd = 0 ; prevInd < index ; prevInd++){
//                 if(arr[prevInd] < arr[index]){
//                     dp[index] = Math.max(dp[index],dp[prevInd]+1);
//                 }
//             }
//             max = Math.max(max,dp[index]);
//         }
        
//         return max;
        
        
        
        
        
        // Tabulation.... Printing the LIS O(N) SC....
        
//         int dp[] = new int[n];
//         int prevs[] = new int[n];
//         int max = 1;
        
//         int lastInd = 0;
        
//         for(int index = 0 ; index < n ; index++){
//             dp[index] = 1;
//             prevs[index] = index;
//             for(int prevInd = 0 ; prevInd < index ; prevInd++){
//                 if(arr[prevInd] < arr[index] && dp[prevInd]+1 > dp[index]){
//                     dp[index] = dp[prevInd]+1;
//                     prevs[index] = prevInd;
//                 }
//             }
//             if(dp[index]>max){
//                 max = dp[index];
//                 lastInd = index;
//             }
//         }
        
//         ArrayList<Integer> printLIS = new ArrayList<>();
//         printLIS.add(arr[lastInd]);
        
//         while(prevs[lastInd] != lastInd){
//             lastInd = prevs[lastInd];
//             printLIS.add(arr[lastInd]);
//         }
        
//         System.out.println(printLIS); // prints in reverse Order...
        
//         return max;
        
        
        
        // Tabulation .... Buttom Up... Space Optimized...
        
//         int cur[] = new int[n+1];
//         int next[] = new int[n+1];
        
//         for(int index = n-1 ; index >= 0 ; index--){
//             for(int prevInd = index-1 ; prevInd >= -1 ; prevInd--){
//                 int take = 0;
        
//                 if(prevInd == -1 || arr[index]>arr[prevInd]){
//                     take = 1 + next[index+1];
//                 }

//                 int notTake = next[prevInd+1];

//                 cur[prevInd+1] = Math.max(take,notTake);
//             }
            
//             next = cur.clone();
//         }
        
//         return next[-1+1];
        
        
        
        
        // Tabulation .... Buttom Up...
        
//         int dp[][] = new int[n+1][n+1];
        
//         for(int index = n-1 ; index >= 0 ; index--){
//             for(int prevInd = index-1 ; prevInd >= -1 ; prevInd--){
//                 int take = 0;
        
//                 if(prevInd == -1 || arr[index]>arr[prevInd]){
//                     take = 1 + dp[index+1][index+1];
//                 }

//                 int notTake = dp[index+1][prevInd+1];

//                 dp[index][prevInd+1] = Math.max(take,notTake);
//             }
//         }
        
//         return dp[0][-1+1];
        
        
        // Memoization ... Top Down...
        
//         int dp[][] = new int[n][n+1];
        
//         for(int row[] : dp){
//             Arrays.fill(row,-1);
//         }
        
//         return f(0,-1,arr,dp);
    }
    
    public static int lowerBound(ArrayList<Integer> arr, int target){
        int s = 0;
        int e = arr.size()-1;
        
        while(s<=e){
            int mid = s+(e-s)/2;
            
            if(arr.get(mid)==target){
                return mid;
            }
            
            if(target<arr.get(mid)){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        
        return s;
        
    }
    
    
    public static int f(int index, int prevInd , int arr[],int dp[][]){
        
        if(index==arr.length){
            return 0;
        }
        
        if(dp[index][prevInd+1] != -1){
            return dp[index][prevInd+1];
        }
        
        int take = 0;
        
        if(prevInd == -1 || arr[index]>arr[prevInd]){
            take = 1 + f(index+1,index,arr,dp);
        }
        
        int notTake = f(index+1,prevInd,arr,dp);
        
        return dp[index][prevInd+1] = Math.max(take,notTake);
        
        
        // Recursion...
        
//         if(index>=arr.length){
//             return 0;
//         }
        
//         int maxLen = 0;
        
//         int take = 0;
            
//         if(arr[index]>last){
//             take = 1 + f(index+1,arr[index],arr);
//         }
        
//         int notTake = f(index+1,last,arr);
        
//         maxLen = Math.max(take,notTake);
        
//         return maxLen;
    }
}