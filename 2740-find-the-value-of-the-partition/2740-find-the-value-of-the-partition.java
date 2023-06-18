class Solution {
    public int findValueOfPartition(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr.length;
        
        PriorityQueue<Integer> n1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> n2 = new PriorityQueue<>();
        
        n1.add(arr[0]);
        
        for(int i = 1 ; i < n ; i++){
            n2.add(arr[i]);
        }
        
        int res = Integer.MAX_VALUE;
        
        res = Math.min(res,Math.abs(n1.peek()-n2.peek()));
        
        for(int i = 1 ; i < n-1 ; i++){
            
            n1.add(arr[i]);
            n2.remove(arr[i]);
            
            res = Math.min(res,Math.abs(n1.peek()-n2.peek()));
        }
        
        return res;
    }
}