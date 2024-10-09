class Solution {
    public int maxGoodNumber(int[] nums) {
        
//         int ans = -1;
        
//         for(int i = 0 ; i < 3 ; i++){
//             for(int j = 0 ; j < 3 ; j++){
//                 for(int k = 0 ; k < 3 ; k++){
                    
//                     if(i == j || j == k || k == i){
//                         continue;
//                     }
                    
//                     String b1 = Integer.toBinaryString(arr[i]);
//                     String b2 = Integer.toBinaryString(arr[j]);
//                     String b3 = Integer.toBinaryString(arr[k]);
                    
//                     String res = b1+b2+b3;
                    
//                     ans = Math.max(ans,Integer.parseInt(res,2));
//                 }
//             }
//         }
        
        
        String binary = "";
        
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arr,(a,b)->{
            String b1 = Integer.toBinaryString(a);
            String b2 = Integer.toBinaryString(b);
            
            return -1*(b1+b2).compareTo(b2+b1);
        });
        
        for(int x : arr){
            binary += Integer.toBinaryString(x);
        }
        
        return Integer.parseInt(binary,2);
    }
}