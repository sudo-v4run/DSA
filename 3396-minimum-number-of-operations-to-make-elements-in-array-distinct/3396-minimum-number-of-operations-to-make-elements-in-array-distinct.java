class Solution {
    public int minimumOperations(int[] arr) {
        
        int n = arr.length;
        HashMap<Integer,Integer> hm  = new HashMap<>();
        
        int cnt = n;
        
        for(int x : arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        
        int min = 0;
        
        int i = 0;
        while(i < n){
            
            if(cnt == hm.size()){
                break;
            }
            
            for(int j = i ; j < i+3 && j < n ; j++){
                
                hm.put(arr[j],hm.get(arr[j])-1);
                if(hm.get(arr[j]) == 0){
                    hm.remove(arr[j]);
                }
            }
            i = i+3;
            min++;
            cnt -= 3;
        }
        
        return min;
    }
}