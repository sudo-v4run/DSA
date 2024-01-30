class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        // Why sorting Heights in descending order when the widths are same? ->
        // to prevent calculating the envelope with the same width. For eg.
        // [3, 1] [3, 2] [3, 3] will get 3, but [3, 3], [3, 2], [3, 1] will get 1.
        
        int n = envelopes.length;
        
        // Apply LIS on Heights...
        
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = envelopes[i][1];
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        temp.add(arr[0]);
        int len = 1;
        for(int i = 1 ; i < n ; i++){
            if(arr[i]>temp.get(temp.size()-1)){
                temp.add(arr[i]);
                len++;
            }else{
                int uprBoundIndex = upperBound(temp,arr[i]);
                temp.set(uprBoundIndex,arr[i]);
            }
        }
        
        return len; // or temp.size();
    }
    public static int upperBound(ArrayList<Integer> arr, int target){
        
        int n = arr.size();
        
        int s = 0;
        int e = n-1;
        
        int ans = n-1;
        
        while(s<=e){
            int mid = s+(e-s)/2;
            
            if(arr.get(mid)==target){
                return mid;
            }
            
            if(arr.get(mid) < target){
                s = mid+1;
            }else{
                ans = mid;
                e = mid-1;
            }
        }
        
        return ans;
    }
}