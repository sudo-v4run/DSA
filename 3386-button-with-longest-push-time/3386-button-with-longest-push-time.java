class Solution {
    public int buttonWithLongestTime(int[][] events) {

        int n = events.length;

        int max = events[0][1];
        int ans = events[0][0];

        for(int i = 1 ; i < n ; i++){
            if(events[i][1]-events[i-1][1] > max){
                max = events[i][1]-events[i-1][1];
                ans = events[i][0];
            }
            if(events[i][1]-events[i-1][1] == max){
                ans = Math.min(ans,events[i][0]);
            }
        }

        return ans;
    }
}