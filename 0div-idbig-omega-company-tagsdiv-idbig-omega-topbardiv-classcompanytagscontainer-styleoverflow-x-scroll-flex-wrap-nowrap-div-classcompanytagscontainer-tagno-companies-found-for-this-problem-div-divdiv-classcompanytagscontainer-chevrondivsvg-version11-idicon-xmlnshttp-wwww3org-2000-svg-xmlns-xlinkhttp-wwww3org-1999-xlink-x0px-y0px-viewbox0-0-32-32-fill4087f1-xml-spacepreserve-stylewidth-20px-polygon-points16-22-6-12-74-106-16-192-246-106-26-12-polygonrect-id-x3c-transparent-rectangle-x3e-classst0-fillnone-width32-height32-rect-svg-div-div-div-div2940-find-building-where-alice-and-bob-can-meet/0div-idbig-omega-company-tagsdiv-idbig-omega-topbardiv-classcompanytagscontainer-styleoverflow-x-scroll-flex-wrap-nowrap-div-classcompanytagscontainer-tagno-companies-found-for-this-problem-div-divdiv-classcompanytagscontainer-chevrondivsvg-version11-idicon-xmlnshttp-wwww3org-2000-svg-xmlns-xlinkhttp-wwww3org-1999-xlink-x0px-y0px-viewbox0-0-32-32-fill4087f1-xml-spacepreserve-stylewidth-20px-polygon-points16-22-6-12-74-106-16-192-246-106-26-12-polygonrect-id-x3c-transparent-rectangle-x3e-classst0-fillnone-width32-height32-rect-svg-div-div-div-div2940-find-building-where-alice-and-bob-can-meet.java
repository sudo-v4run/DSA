class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        
        int n = heights.length;
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        int ans[] = new int[queries.length];
        int k = 0;
        
        for(int q[] : queries){
            int a = q[0];
            int b = q[1];
            
            String temp = a+","+b;
            if(hm.containsKey(temp)){
                ans[k++] = hm.get(temp);
                continue;
            }
            
            int max = Math.max(a,b);
            int aVal = heights[a];
            int bVal = heights[b];
            
            if(a == b){
                ans[k] = a;
                hm.put(temp,a);
                k++;
                continue;
            }else if(aVal > bVal && a > b){
                ans[k] = a;
                hm.put(temp,a);
                k++;
                continue;
            }else if(bVal > aVal && b > a){
                ans[k] = b;
                hm.put(temp,b);
                k++;
                continue;
            }
            
            boolean flag = false;
            for(int j = max+1 ; j < n ; j++){
                if(heights[j] > aVal && heights[j] > bVal){
                    ans[k] = j;
                    hm.put(temp,j);
                    k++;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans[k] = -1;
                hm.put(temp,ans[k]);
                k++;
            }
        }
        
        return ans;
    }
}