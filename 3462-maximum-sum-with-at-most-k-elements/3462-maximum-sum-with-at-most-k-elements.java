class Solution {
    public long maxSum(int[][] arr, int[] limits, int k) {

        int m = arr.length;
        int n = arr[0].length;
        
        long ans = 0;

        PriorityQueue<Integer>[] pqArr = new PriorityQueue[m];
        for(int i = 0 ; i < m ; i++){
            pqArr[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                pqArr[i].add(arr[i][j]);
            }
        }

        while(k > 0){
            int max = -1;
            int maxPqArrInd = -1;
            for(int i = 0 ; i < m ; i++){
                if(limits[i] <= 0){
                    continue;
                }
                if(pqArr[i].peek() > max){
                    max = pqArr[i].peek();
                    maxPqArrInd = i;
                }
            }
            ans += max;
            pqArr[maxPqArrInd].poll();
            limits[maxPqArrInd]--;
            k--;
        }

        return ans;
    }
}