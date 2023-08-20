class Solution {
    public int minimumSum(int n, int k) {
        
        int sum = 0;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 1 ; hs.size() < n ; i++){
            if(!hs.contains(k-i)){
                sum += i;
                hs.add(i);
            }
        }
        
        return sum;
    }
}