class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int arr1[] = new int[nums1.length+4];
        int arr2[] = new int[nums2.length+4];

        int n1 = arr1.length;
        int n2 = arr2.length;

        if(n2 < n1){
            return findMedianSortedArrays(nums2,nums1);
        }

        arr1[0] = arr1[1] = Integer.MIN_VALUE;
        arr1[n1-1] = arr1[n1-2] = Integer.MAX_VALUE;

        arr2[0] = arr2[1] = Integer.MIN_VALUE;
        arr2[n2-1] = arr2[n2-2] = Integer.MAX_VALUE;

        for(int i = 0 ; i < nums1.length; i++){
            arr1[i+2] = nums1[i];
        }
        for(int i = 0 ; i < nums2.length; i++){
            arr2[i+2] = nums2[i];
        }

        int l1 = 0;
        int h1 = n1-1;
        int l2 = 0;
        int h2 = n2-1;

        while(l1 <= h1){
            int m1 = (l1+h1)/2;
            int m2 = (((n1+n2+1)/2)-(m1+1))-1;

            if(arr1[m1] <= arr2[m2+1] && arr2[m2] <= arr1[m1+1]){
                if((n1+n2)%2 == 0){
                    return (Math.max(arr1[m1],arr2[m2])+Math.min(arr1[m1+1],arr2[m2+1]))/2.0;

                }else{
                    return Math.max(arr1[m1],arr2[m2]);
                }
            }else if(arr1[m1] > arr2[m2+1]){
                h1 = m1-1;
            }else if(arr2[m2] > arr1[m1+1]){
                l1 = m1+1;
            }
        }

        return 0.0;
    }
}