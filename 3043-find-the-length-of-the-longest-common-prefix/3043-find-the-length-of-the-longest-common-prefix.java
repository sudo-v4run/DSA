class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int x : arr1){
            int temp = x;
            while(temp > 0){
                hs.add(temp);
                temp = temp/10;
            }
        }
        
        int max = 0;
        
        for(int x : arr2){
            int temp = x;
            while(temp > 0){
                if(hs.contains(temp)){
                    max = Math.max(max,findLen(temp));
                }
                temp = temp/10;
            }
        }
        
        return max;
    }
    public int findLen(int x){
        
        return String.valueOf(x).length();
    }
}