class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        
        int n1 = arr1.length, n2 = arr2.length;
        
        if(n1>n2){
            return findMedianSortedArrays(arr2,arr1);
        }
        
        int l = 0;
        int h = n1;
            // h = n1 but not n1-1 coz that's how we take cuts...n1 is also inclusive
            // i.e. n1 accounts for all elements taken...and 0 means no elements taken...
            // In that way, cut = 1 means we are taking elements at 0th and before indices
            // So, cut = n1 means we are taking n-1th element and before indecies elements
        
        while(l<=h){
            
            int cut1 = (l+h)/2;
            int cut2 = ((n1+n2)/2) - cut1;
            
            int l1 = cut1==0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int l2 = cut2==0 ? Integer.MIN_VALUE : arr2[cut2-1];
            
            int r1 = cut1==n1 ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2==n2 ? Integer.MAX_VALUE : arr2[cut2];
            
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return Math.min(r1,r2);
                }
            }
            
            if(l1>r2){
                h = cut1-1;
            }else if(l2>r1){
                l = cut1+1;
            }
        
        }
        
        return 0.0;
    }
}