class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        
        Integer[] arr = IntStream.of(nums)
                                .boxed()
                                .toArray(Integer[]::new);
        
        Arrays.sort(arr, new Comparator<Integer>() 
        {
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                
                String num1 = s1+s2;
                String num2 = s2+s1;
                
                return num2.compareTo(num1);
            }
        }          );
        
        String res = "";
        
        for(int i : arr){
            res += String.valueOf(i);
        }
        
        if(res.charAt(0)=='0')
            return "0";
        
        return res;
    }
    
    
}