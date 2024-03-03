class Solution {
    public int minimumOperationsToWriteY(int[][] arr) {
        
        int n = arr.length;
        
        HashSet<String> hs = new HashSet<>();
        
        for(int i = 0 ; i <= n/2 ; i++){
            hs.add(i+","+i);
        }
        for(int i = 0 ; i <= n/2 ; i++){
            hs.add(i+","+(n-1-i));
        }
        for(int i = n/2 ; i < n ; i++){
            hs.add(i+","+(n/2));
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0 ; i <= 2 ; i++){
            for(int j = 0 ; j <= 2 ; j++){
                if(i != j){
                    int cur = f(arr,i,j,hs);
                    ans = Math.min(ans,cur);
                }
            }
        }
        
        return ans;
    }
    public int f(int arr[][], int toY, int notToY, HashSet<String> hs){
        
        int n = arr.length;
        
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                String curCell = i+","+j;
                
                if(hs.contains(curCell) && arr[i][j] != toY){
                    cnt++;
                }
                if(!hs.contains(curCell) && arr[i][j] != notToY){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}