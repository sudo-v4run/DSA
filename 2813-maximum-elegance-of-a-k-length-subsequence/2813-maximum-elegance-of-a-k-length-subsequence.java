class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        
        Arrays.sort(items,(a,b)->{return b[0]-a[0];});
        
        HashSet<Integer> categorySet = new HashSet<>();
        ArrayList<Integer> dups = new ArrayList<>();
        
        long sum = 0;
        long ans = 0;
        
        for(int i = 0 ; i < items.length ; i++){
            
            if(i < k){
                if(categorySet.contains(items[i][1])){
                    dups.add(items[i][0]);
                }else{
                    categorySet.add(items[i][1]);
                }
                sum += items[i][0];
            }else{
                if(dups.size() == 0){
                    break;
                }
                sum -= dups.get(dups.size()-1);
                dups.remove(dups.size()-1);
                sum += items[i][0];
                
                if(categorySet.contains(items[i][1])){
                    dups.add(items[i][0]);
                }else{
                    categorySet.add(items[i][1]);
                }
            }
            
            ans = Math.max(ans,sum+1L*categorySet.size()*categorySet.size());
        }
        
        return ans;
    }
}