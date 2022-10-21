/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakEle(mountainArr);
        int firstTry = orderAgnosticBs(mountainArr,target,0,peak);
        if(firstTry != -1)
            return firstTry;
        return orderAgnosticBs(mountainArr,target,peak+1,mountainArr.length()-1);
    }
    public static int peakEle(MountainArray mountainArr){
        int s = 0;
        int e = mountainArr.length()-1;
        
        while(s<e){
            int m = s+(e-s)/2;
            
            if(mountainArr.get(m)<mountainArr.get(m+1)){
                s = m+1;
            }else{
                e = m;
            }
        }
        
        return s;
    }
    public static int orderAgnosticBs(MountainArray mountainArr,int x,int s,int e){
        boolean isAsc = mountainArr.get(s) < mountainArr.get(e);
        
        while(s<=e){
            int m = s+(e-s)/2;
            
            if(x==mountainArr.get(m)){
                return m;
            }
            if(isAsc){
                if(x<mountainArr.get(m)){
                    e = m-1;
                }else{
                    s = m+1;
                }
            }else{
                if(x<mountainArr.get(m)){
                    s = m+1;
                }else{
                    e = m-1;
                }
            }
        }
        
        return -1;
    }
}