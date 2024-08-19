class Solution {
    long dp[][];
    public long maxEnergyBoost(int[] arr1, int[] arr2) {
        
        dp = new long[arr1.length][2];
        for(long row[] : dp){
            Arrays.fill(row,-1);
        }
        
        long startWithFirstArr = f(0,1,arr1,arr2);
        for(long row[] : dp){
            Arrays.fill(row,-1);
        }
        
        long startWithSecondArr = f(0,0,arr1,arr2);
        
        return Math.max(startWithFirstArr,startWithSecondArr);
    }
    public long f(int index, int inFirstArr, int arr1[], int arr2[]){
        
        int n = arr1.length;
        
        if(index == n){
            return 0;
        }
        
        if(dp[index][inFirstArr] != -1){
            return dp[index][inFirstArr];
        }
        
        long takeFirst = 0;
        if(inFirstArr == 1){
            takeFirst = arr1[index] + f(index+1,1,arr1,arr2);
        }
        long notTakeFirst = 0;
        if(inFirstArr == 1){
            notTakeFirst = f(index+1,0,arr1,arr2);
        }
        
        long takeSecond = 0;
        if(inFirstArr == 0){
            takeSecond = arr2[index] + f(index+1,0,arr1,arr2);
        }
        long notTakeSecond = 0;
        if(inFirstArr == 0){
            notTakeSecond = f(index+1,1,arr1,arr2);
        }
        
        return dp[index][inFirstArr] =
            Math.max(takeFirst,Math.max(notTakeFirst,Math.max(takeSecond,notTakeSecond)));
    }
}