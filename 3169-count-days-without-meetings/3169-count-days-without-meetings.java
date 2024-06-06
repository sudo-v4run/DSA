class Solution {
    public int countDays(int days, int[][] meetings) {
        
        Arrays.sort(meetings,(a,b)->{return a[0]-b[0];});
        
        int start = meetings[0][0];
        int end = meetings[0][1];
        int n = meetings.length;
        ArrayList<int[]> res = new ArrayList<>();
        
        for(int[] m : meetings){
            if(m[0] > end){
                res.add(new int[]{start,end});
                start = m[0];
                end = m[1];
            }else{
                end = Math.max(end,m[1]);
            }
        }
        res.add(new int[]{start,end});
        
        int ans = 0;
        
        for(int i = 0 ; i < res.size()-1 ; i++){
            ans += res.get(i+1)[0]-res.get(i)[1]-1;
        }
        
        ans += res.get(0)[0]-1;
        ans += days-res.get(res.size()-1)[1];
        
        return ans;
    }
}