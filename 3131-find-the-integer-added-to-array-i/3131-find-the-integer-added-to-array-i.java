class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int median1 = nums1[n1/2];
        int median2 = nums2[n2/2];
        
        return median2-median1;
    }
}