class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        
        int n = arr2.length;
        
        Stack<Integer> s = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = n-1 ; i >= 0 ; i--){
            while(!s.isEmpty() && s.peek() <= arr2[i]){
                s.pop();
            }
            int temp = -1;
            if(!s.isEmpty()){
                temp = s.peek();
            }
            hm.put(arr2[i],temp);
            s.push(arr2[i]);
        }
        
        n = arr1.length;
        int res[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            res[i] = hm.get(arr1[i]);    
        }
        
        return res;
    }
}