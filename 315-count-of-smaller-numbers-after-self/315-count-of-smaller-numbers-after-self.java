class Solution {
    static class Pair{
        int ele = 0;
        int ind = 0;
        Pair(int ele, int ind){
            this.ele = ele;
            this.ind = ind;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;
        
        Pair[] arr = new Pair[n];
        
        for(int i = 0 ; i < n ; i++){
            Pair p = new Pair(nums[i],i);
            arr[i] = p;
        }
        
        int[] cnt = new int[n];
        
        merge(arr,0,n-1,cnt);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int ele : cnt){
            res.add(ele);
        }
        
        return res;
    }
    public static void merge(Pair[] vals, int l, int h, 
                             int[] cnt){
        
        if(l<h){
            int m = (l+h)/2;
            merge(vals,l,m,cnt);
            merge(vals,m+1,h,cnt);
            mergeSort(vals,l,m,h,cnt);
        }
    }
    public static void mergeSort(Pair[] vals, int l , int m, int h,
                                 int[] cnt){
        
        int i = l;
        int j = m+1;
        
        Pair[] temp = new Pair[h-l+1];
        int k = 0;
        
        while(i<=m && j<=h){
            if(vals[i].ele > vals[j].ele){
                cnt[vals[i].ind] += h-j+1;
                temp[k++] = vals[i++];
            }else{
                temp[k++] = vals[j++];
            }
        }
        
        while(i<=m){
            temp[k++] = vals[i++];
        }
        
        while(j<=h){
            temp[k++] = vals[j++];
        }
        
        i = l;
        k = 0;
        
        for( ; i<=h ; i++){
            vals[i] = temp[k++];
        }
        
    }
}