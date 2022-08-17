class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int res[] = new int[arr.length-k+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int j = 0 ;
        int i = 0;
        for(;i<k;i++){
            while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]){
                q.removeLast();
            }
            q.addLast(i);
        }
        for(;i<arr.length;i++){
            res[j++] = arr[q.peek()];
         
            if(!q.isEmpty() && q.peek()==i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]){
                q.removeLast();
            }
            q.addLast(i);
        }
        res[j] = arr[q.peek()];
        
        return res;
    }
}