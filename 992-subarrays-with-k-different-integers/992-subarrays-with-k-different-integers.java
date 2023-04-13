class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
        
        return atmost(arr,k)-atmost(arr,k-1);
    }
    public static int atmost(int arr[], int k){
        
        if(k == 0){
            return 0;
        }
        
        int i = 0, j = 0;
        int n = arr.length;
        int cnt = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        while(j < n){
            hm.put(arr[j],hm.getOrDefault(arr[j],0)+1);
            
            if(hm.size() <= k){
                cnt += j-i+1;
                j++;
            }else if(hm.size() > k){
                while(hm.size() > k){
                    hm.put(arr[i],hm.get(arr[i])-1);
                    if(hm.get(arr[i]) == 0){
                        hm.remove(arr[i]);
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