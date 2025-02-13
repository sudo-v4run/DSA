class Solution {
    HashMap<Integer,Long> lcmMap;
    public int minimumIncrements(int[] arr, int[] target) {
        
        int n = arr.length;

        lcmMap = new HashMap<>();

        for(int mask = 1 ; mask < (1 << target.length) ; mask++){
            long lcm = 1;
            for(int j = 0 ; j < target.length ; j++){
                if((mask & (1 << j)) != 0){
                    lcm = findLCM(lcm,target[j]);
                }
            }
            lcmMap.put(mask,lcm);
        }

        long dp[][] = new long[n][(1 << target.length)];
        for(long row[] : dp){
            Arrays.fill(row,-1);
        }

        return (int)f(0,0,arr,target,dp);
    }
    public long f(int index, int mask, int arr[], int target[], long dp[][]){

        int n = arr.length;

        if(mask == ((1 << target.length)-1)){
            return 0;
        }

        if(index == n){
            return (long)1e9;
        }

        if(dp[index][mask] != -1){
            return dp[index][mask];
        }

        long ans = (long)1e9;

        // notTake...

        long notTake = f(index+1,mask,arr,target,dp);
        ans = Math.min(ans,notTake);

        // take...

        for(int subset = 1 ; subset < (1 << target.length) ; subset++){

            long subsetLCM = lcmMap.get(subset);
            long nextMultiple = 
                    (long) (Math.ceil((arr[index] * 1.0) / subsetLCM) * subsetLCM);

            long take = (nextMultiple-arr[index]) + f(index+1,(mask|subset),arr,target,dp);

            ans = Math.min(ans,take);
        }

        return dp[index][mask] = ans;
    }
    public long findLCM(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}