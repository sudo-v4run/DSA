class Solution {
    public int findTheWinner(int n, int k) {
        
//         Queue<Integer> q = new LinkedList<>();
        
//         for(int i = 1 ; i <= n ; i++){
//             q.add(i);
//         }
        
//         while(q.size() > 1){
//             int x = k;
//             while(x-- > 1){
//                 q.add(q.poll());
//             }
//             q.poll();
//         }
        
//         return q.peek();
        
        
        
        // Recursive Sol...
        
        // Intuition ->
        // https://cs.stackexchange.com/questions/7048/a-recursive-formula-for-generalized-josephus-problem
        
        
        return f(n,k)+1;       // +1 for coverting into 1 based...
    }
    public int f(int n, int k){
        
        if(n == 1){
            return 0;
        }
        
        return (f(n-1,k)+k)%n;
    }
}