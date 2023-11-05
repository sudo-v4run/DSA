class Solution {
    public int findChampion(int n, int[][] edges) {
        
        boolean isChamp[] = new boolean[n];
        Arrays.fill(isChamp,true);
        
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            
            isChamp[v] = false;
        }
        
        int cnt = 0;
        int champ = -1;
        for(int i = 0 ; i < n ; i++){
            if(isChamp[i]){
                champ = i;
                cnt++;
            }
        }
        
        if(cnt != 1){
            return -1;
        }
        
        return champ;
    }
}