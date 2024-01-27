class Solution {
    public int findTheWinner(int n, int k) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 1 ; i <= n  ; i++){
            arr.add(i);
        }
        
        k--;
        
        int i = 0;
        while(arr.size() > 1){
            i = (i+k) % arr.size();
            
            // System.out.println(i+"  "+arr.get(i));
            arr.remove(i);
            
        }
        
        return arr.get(0);
    }
}