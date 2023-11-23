class Solution {
    class Pair{
        int maxVal, ind;
        Pair(int maxVal, int ind){
            this.maxVal = maxVal;
            this.ind = ind;
        }
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
         
        int n = heights.length;
        
        int ans[] = new int[queries.length];
        Arrays.fill(ans,-1);
        
        HashMap<Integer,ArrayList<Pair>> hm = new HashMap<>();
        
        for(int i = 0 ; i < queries.length ; i++){
            
            int a = queries[i][0];
            int b = queries[i][1];
            
            if(a == b){
                ans[i] = a;
            }else if(heights[a] > heights[b] && a > b){
                ans[i] = a;
            }else if(heights[b] > heights[a] && b > a){
                ans[i] = b;
            }else{
                
                int maxInd = Math.max(a,b);
                int maxVal = Math.max(heights[a],heights[b]);
                
                if(!hm.containsKey(maxInd)){
                    hm.put(maxInd, new ArrayList<>());
                }
                hm.get(maxInd).add(new Pair(maxVal,i));
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.maxVal-b.maxVal;
        });
        
        for(int i = 0 ; i < heights.length ; i++){
            
            while(!pq.isEmpty() && pq.peek().maxVal < heights[i]){
                int qInd = pq.poll().ind;
                ans[qInd] = i;
            }
            
            if(hm.containsKey(i)){
                for(Pair p : hm.get(i)){
                    pq.add(p);
                }
            }
        }
        
        return ans;
    }
    
    
    
//     public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        
//         int n = heights.length;
        
//         HashMap<String,Integer> hm = new HashMap<>();
        
//         int ans[] = new int[queries.length];
//         int k = 0;
        
//         for(int q[] : queries){
//             int a = q[0];
//             int b = q[1];
            
//             String temp = a+","+b;
//             if(hm.containsKey(temp)){
//                 ans[k++] = hm.get(temp);
//                 continue;
//             }
            
//             int max = Math.max(a,b);
//             int aVal = heights[a];
//             int bVal = heights[b];
            
//             if(a == b){
//                 ans[k] = a;
//                 hm.put(temp,a);
//                 k++;
//                 continue;
//             }else if(aVal > bVal && a > b){
//                 ans[k] = a;
//                 hm.put(temp,a);
//                 k++;
//                 continue;
//             }else if(bVal > aVal && b > a){
//                 ans[k] = b;
//                 hm.put(temp,b);
//                 k++;
//                 continue;
//             }
            
//             boolean flag = false;
//             for(int j = max+1 ; j < n ; j++){
//                 if(heights[j] > aVal && heights[j] > bVal){
//                     ans[k] = j;
//                     hm.put(temp,j);
//                     k++;
//                     flag = true;
//                     break;
//                 }
//             }
//             if(!flag){
//                 ans[k] = -1;
//                 hm.put(temp,ans[k]);
//                 k++;
//             }
//         }
        
//         return ans;
//     }
}