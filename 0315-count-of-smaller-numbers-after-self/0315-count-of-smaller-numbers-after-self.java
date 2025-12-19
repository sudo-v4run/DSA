class Solution {
    int res[];
    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        
        res = new int[n];
        Pair arr[] = new Pair[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(i, nums[i]);
        }

        mergeSort(0, n-1, arr);

        return Arrays.stream(res).boxed().toList();
    }
    public void mergeSort(int low, int high, Pair arr[]){

        if(low >= high){
            return;
        }

        int mid = (low+high)/2;

        mergeSort(low, mid, arr);
        mergeSort(mid+1, high, arr);

        merge(low, mid, high, arr);
    }
    public void merge(int low, int mid, int high, Pair arr[]){

        Pair temp[] = new Pair[high-low+1];
        int index = 0;

        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(arr[left].ele > arr[right].ele){
                temp[index] = new Pair(arr[left].index, arr[left].ele);

                res[arr[left].index] += high-right+1;

                index++;
                left++;
            }else{
                temp[index] = new Pair(arr[right].index, arr[right].ele);
                index++;
                right++;
            }
        }

        while(left <= mid){
            temp[index] = new Pair(arr[left].index, arr[left].ele);
            index++;
            left++;
        }

        while(right <= high){
            temp[index] = new Pair(arr[right].index, arr[right].ele);
            index++;
            right++;
        }

        index = 0;
        for(int i = low; i <= high; i++){
            arr[i] = temp[index++];
        }
    }
    class Pair{
        int index, ele;
        Pair(int index, int ele){
            this.index = index;
            this.ele = ele;
        }
    }
}