class Solution {
    public int countCompleteSubarrays(int[] arr) {
        
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i : arr){
            hs.add(i);
        }
        
        int k = hs.size();
        
        return atmost(arr,k) - atmost(arr,k-1);
    }
    public static int atmost(int arr[], int k){
        
        if(k == 0){
            return 0;
        }
        
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int i = 0;
        int j = 0;
        
        int cnt = 0;
        
        while(j < n){
            
            hm.put(arr[j],hm.getOrDefault(arr[j],0)+1);
            
            if(hm.size() <= k){
                cnt += j-i+1;
                j++;
            }else{
                while(hm.size() > k){
                    if(hm.containsKey(arr[i])){
                        hm.put(arr[i],hm.get(arr[i])-1);
                        if(hm.get(arr[i]) == 0){
                            hm.remove(arr[i]);
                        }
                    }
                    i++;
                }
                cnt += j-i+1;
                j++;
            }
        }
        
        return cnt;
    }
}