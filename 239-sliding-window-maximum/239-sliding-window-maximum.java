class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        
        int n = arr.length;
        int res[] = new int[n-k+1];
        int ri = 0;
        int i = 0, j = 0;
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        while(j<n){
            while(!q.isEmpty() && q.peekLast()<arr[j]){
                q.pollLast();
            }
            q.add(arr[j]);
            if(j-i+1==k){
                res[ri++] = q.peekFirst();
                if(q.peek()==arr[i]) q.pollFirst();
                i++;
            }
            j++;
        }
        
        return res;
    }
}