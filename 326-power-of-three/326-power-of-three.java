class Solution {
    public boolean isPowerOfThree(int n) {
        int maxP = (int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3)) );
        
        // MaxP = 3^19 coz 3^20 is not int Int range...
        
        return (n>0 && maxP%n==0);  //return ( n>0 &&  1162261467%n==0);
    }
}