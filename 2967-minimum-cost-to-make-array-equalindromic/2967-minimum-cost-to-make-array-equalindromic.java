class Solution {
    public long minimumCost(int[] arr) {
        
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int median = arr[n/2];
        
        if(n%2 == 0){
            median = (arr[(n/2)-1] + arr[n/2]) / 2;
        }
        
        int[] nearestPalis = findNearestPalis(median);
        long minCost = Long.MAX_VALUE;
        
        for(int pali : nearestPalis){
            long cost = 0;
            for(int ele : arr){
                cost += Math.abs(ele-pali);
            }
            minCost = Math.min(minCost,cost);
        }
        
        return minCost;
    }
    public int[] findNearestPalis(int x){
        
        String num = String.valueOf(x);
        int len = num.length();
        
        String leftPart = num.substring(0,(len+1)/2);
        
        int leftPart1 = Integer.parseInt(leftPart);
        int leftPart2 = Integer.parseInt(leftPart)-1;
        int leftPart3 = Integer.parseInt(leftPart)+1;
        
        String leftStr1 = String.valueOf(leftPart1);
        String leftStr2 = String.valueOf(leftPart2);
        String leftStr3 = String.valueOf(leftPart3);
        
        String s1,s2,s3;
        
        if(len%2 == 0){
            
            s1 = leftStr1+reverse(leftStr1);
            s2 = leftStr2+reverse(leftStr2);
            s3 = leftStr3+reverse(leftStr3);
        }else{
            
            s1 = leftStr1+reverse(leftStr1.substring(0,leftStr1.length()-1));
            s2 = leftStr2+reverse(leftStr2.substring(0,leftStr2.length()-1));
            s3 = leftStr3+reverse(leftStr3.substring(0,leftStr3.length()-1));
        }
        
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2); 
        int n3 = Integer.parseInt(s3);
        
        int oneDigitLess = (int)Math.pow(10,len-1)-1;
        int oneDigitMore = (int)Math.pow(10,len-1)+1;
        
        return new int[]{n1,n2,n3,oneDigitLess,oneDigitMore};
    }
    public String reverse(String s){
        String ans = "";
        
        for(int i = s.length()-1 ;  i>= 0 ; i--){
            ans += s.charAt(i);
        }
        
        return ans;
    }
}