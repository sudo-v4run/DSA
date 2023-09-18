class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, 
                                 List<Integer> stock, List<Integer> cost) {
        
        long ans = 0;
        
        for(int i = 0 ; i < composition.size() ; i++){
            List<Integer> ithMachineCompo = composition.get(i);
            
            long lo = 0;
            long hi = 2*(int)1e8;
            long res = 0;
            while(lo <= hi){
                long mid = lo+(hi-lo)/2;

                if(isPossible(mid,ithMachineCompo,stock,cost,budget)){
                    res = mid;
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
            ans = Math.max(ans,res);
        }
        
        return (int)ans;
    }
    public static boolean isPossible(long alloys, List<Integer> compo, List<Integer> stock,
                                    List<Integer> cost, int budget){
        
        long totCost = 0;
        
        for(int i = 0 ; i < compo.size() ; i++){
            
            int compoi = compo.get(i);
            int si = stock.get(i);
            int costi = cost.get(i);
            
            totCost += Math.max((alloys*compoi-si),0)*costi;
                // max(res,0) coz if the stock is more than required, we get -ve.
                // to avoid that we take max(res,0). Why 0? coz when we have 
                // adequate stock, we don't need any more metal
        }
        
        return totCost <= budget;
    }
}