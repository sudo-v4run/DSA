class Solution {
    public String largestNumber(int[] nums) {
        
        int n = nums.length;
        String arr[] = new String[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        
//         Arrays.sort(arr, new Comparator<String>() 
//         {
//             public int compare(String s1, String s2) {
                
//                 String num1 = s1+s2;
//                 String num2 = s2+s1;
                
//                 return num2.compareTo(num1);
//             }
//         }          );
        
        Arrays.sort(arr,(s1,s2)->{return (s2+s1).compareTo(s1+s2);});
        
        String res = "";
        
        for(String s : arr){
            res += s;
        }
        
        if(res.charAt(0)=='0')
            return "0";
        
        return res;
    }
}