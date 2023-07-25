class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        
        Collections.sort(usageLimits);
        
        int n = usageLimits.size();
        
        long elesReqForCurGrp = 0;
        long elesHave = 0;
        
        int grp = 1;
        
        for(int i = 0 ; i < n ; i++){
            elesReqForCurGrp = grp*(grp+1)/2;   // sum of eles till n
            elesHave += usageLimits.get(i);
            
            if(elesReqForCurGrp <= elesHave){
                grp++;
            }
        }
        
        return grp-1;   // -1 coz we started with grp = 1..
    }
}