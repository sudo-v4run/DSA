class Solution {
    public int maxDistinctElements(int[] arr, int k) {

        int n = arr.length;
        Arrays.sort(arr);

        int cnt = 0;
        int last = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            int min = arr[i]-k;
            int max = arr[i]+k;

            if(last < min){
                cnt++;
                last = min;
            }else if(last < max){
                cnt++;
                last++;
            }
        }

        return cnt;
    }
}