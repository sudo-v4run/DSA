class Solution {
    public int[] nextGreaterElements(int[] arr) {
        
        int n  = arr.length;
        
        int res[] = new int[n];
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 2*n-1 ; i >=0 ; i--){
            
            while(!s.isEmpty() && arr[i%n] >= s.peek()){
                s.pop();
            }
            if(i < n){
                res[i] = s.isEmpty() ? -1 : s.peek();
            }
            s.push(arr[i%n]);
        }
        
        return res;
    }
}