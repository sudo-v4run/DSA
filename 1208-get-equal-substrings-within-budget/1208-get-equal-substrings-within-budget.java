class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        // we are asked to find max substring...so take and notTake does not work...
        
        int n = s.length();
        
        int i = 0;
        int j = 0;
        int cost = 0;
        int max = Integer.MIN_VALUE;
        
        while(j < n){
            
            cost += Math.abs((int)s.charAt(j)-(int)t.charAt(j));
            
            if(cost <= maxCost){
                max = Math.max(max,j-i+1);
                j++;
            }else if(cost > maxCost){
                while(cost > maxCost){
                    cost = cost-Math.abs((int)s.charAt(i)-(int)t.charAt(i));
                    i++;
                }
                max = Math.max(max,j-i+1);
                j++;
            }
        }
        
        return max;
    }
}