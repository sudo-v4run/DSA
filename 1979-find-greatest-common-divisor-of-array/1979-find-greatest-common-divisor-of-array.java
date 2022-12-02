class Solution {
    public int findGCD(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        
        return gcd(max,min);
    }
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        
        return gcd(b,a%b);
    }
}