class Solution {
    int horizontalCut[];
    int verticalCut[];
    HashMap<String,Integer> dp;
    public int minimumCost(int M, int N, int[] horizontalCut, int[] verticalCut) {
        
        this.horizontalCut = horizontalCut;
        this.verticalCut = verticalCut;
        
        dp = new HashMap<>();
        
        int m = horizontalCut.length;
        int n = verticalCut.length;
        
        return f(0,n,0,m);
    }
    public int f(int cS, int cE, int rS, int rE){
        
        if(cS >= cE && rS >= rE){
            return 0;
        }
        
        String state = cS+","+cE+","+rS+","+rE;
        
        if(dp.containsKey(state)){
            return dp.get(state);
        }
        
        int ans = (int)1e7;
        
        if(cS != cE){
            for(int i = cS ; i < cE ; i++){
                int cur = verticalCut[i] + f(cS,i,rS,rE)+f(i+1,cE,rS,rE);
                ans = Math.min(ans,cur);
            }
        }
        
        if(rS != rE){
            for(int i = rS ; i < rE ; i++){
                int cur = horizontalCut[i] + f(cS,cE,rS,i)+f(cS,cE,i+1,rE);
                ans = Math.min(ans,cur);
            }
        }
        
        dp.put(state,ans);
        
        return ans;
    }
}