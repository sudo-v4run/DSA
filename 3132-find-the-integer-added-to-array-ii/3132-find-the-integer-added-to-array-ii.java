class Solution {
    public int minimumAddedInteger(int[] arr1, int[] arr2) {
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int median2 = arr2[n2/2];
        
        int ans = Integer.MAX_VALUE;
        
        HashMap<Integer,Integer> hmArr2 = new HashMap<>();
        for(int i = 0 ; i < n2 ; i++){
            hmArr2.put(arr2[i],hmArr2.getOrDefault(arr2[i],0)+1);
        }
        
        for(int i = 0 ; i < n1 ; i++){
            int median1 = arr1[i];
            int diff = median2-median1;
            
            HashMap<Integer,Integer> hmArr1 = new HashMap<>();
            for(int ele : arr1){
                int newEle = ele+diff;
                hmArr1.put(newEle,hmArr1.getOrDefault(newEle,0)+1);
            }
            
            boolean flag = true;
            for(int key : hmArr2.keySet()){
                if(!hmArr1.containsKey(key)){
                    flag = false;
                    break;
                }
                if(hmArr2.get(key) > hmArr1.get(key)){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                ans = Math.min(ans,diff);
            }
        }
        
        return ans;
    }
}