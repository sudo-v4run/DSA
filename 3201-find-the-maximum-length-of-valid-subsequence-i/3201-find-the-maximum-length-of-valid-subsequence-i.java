class Solution {
    public int maximumLength(int[] arr) {
        
        int n = arr.length;
        
        if(n <= 2){
            return n;
        }
        
        int rem = 0;
        int ans1 = 0;
        for(int x : arr){
            if(x%2 == rem){
                ans1++;
            }
        }
        
        rem = 1;
        int ans2 = 0;
        for(int x : arr){
            if(x%2 == rem){
                ans2++;
            }
        }
        
        rem = 0;
        int ans3 = 0;
        for(int x : arr){
            if(x%2 == rem){
                ans3++;
                rem = 1-rem;
            }
        }
        
        rem = 1;
        int ans4 = 0;
        for(int x : arr){
            if(x%2 == rem){
                ans4++;
                rem = 1 - rem;
            }
        }
        
        return Math.max(ans1,Math.max(ans2,Math.max(ans3,ans4)));
    }
}