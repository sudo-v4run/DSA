class Solution {
    class Pair{
        int diff, ele;
        Pair(int diff, int ele){
            this.diff = diff;
            this.ele = ele;
        }
    }
    
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        
        // Using BS and 2 Prts...
        
        int n = nums.length;
        
        List<Integer> res = new ArrayList<>();
        
        int index = findIndex(nums,x);
        
        int i = index;
        int j = index;
        
        while(k != 0){
            if(i == j){
                res.add(nums[index]);
                i--;
                j++;
            }else if(i < 0){
                res.add(nums[j]);
                j++;
            }else if(j > n-1){
                res.add(nums[i]);
                i--;
            }else if(Math.abs(x-nums[i]) <= Math.abs(x-nums[j])){
                res.add(nums[i]);
                i--;
            }else{
                res.add(nums[j]);
                j++;
            }
            k--;
        }
        
        Collections.sort(res);
        
        return res;
        
        
        // Using PQ....
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
//             if(a.diff < b.diff){
//                 return 1;
//             }else if(a.diff == b.diff && a.ele < b.ele){
//                 return 1;
//             }
//             return -1;
//         });
        
//         int n = nums.length;
//         for(int i = 0 ; i < n ; i++){
//             pq.add(new Pair(Math.abs(nums[i]-x),nums[i]));
            
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
        
//         List<Integer> res = new ArrayList<>();
        
//         while(!pq.isEmpty()){
//             res.add(pq.poll().ele);
//         }
        
//         Collections.sort(res);
        
//         return res;
        
        // Brute Force...
        
        
//         ArrayList<Integer> arr = new ArrayList<>();
        
//         for(int ele : nums){
//             arr.add(ele);
//         }
        
//         Collections.sort(arr,(a,b)->{
//             if(Math.abs(a-x) < Math.abs(b-x)){
//                 return -1;
//             }else if(Math.abs(a-x) == Math.abs(b-x) && a < b){
//                 return -1;
//             }
//             return 1;
//         });
        
//         List<Integer> res = new ArrayList<>();
        
//         for(int ele : arr){
//             res.add(ele);
//             if(res.size() == k){
//                 break;
//             }
//         }
        
//         Collections.sort(res);
        
//         return res;
    }
    public int findIndex(int arr[], int x){
        
        int n = arr.length;
        
        if(x < arr[0]){
            return 0;
        }
        if(x > arr[n-1]){
            return n-1;
        }
        
        int ans = -1;
        int s = 0;
        int e = n-1;
        while(s <= e){
            int mid = s+(e-s)/2;
            
            if(arr[mid] == x){
                return mid;
            }
            
            ans = mid;
            
            if(arr[mid] < x){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        
        if(ans-1 >= 0 && x < arr[ans]){
            if(Math.abs(x-arr[ans-1]) <= Math.abs(x-arr[ans])){
                ans = ans-1;
            }
        }else if(ans+1 <= n-1 && x > arr[ans]){
            if(Math.abs(x-arr[ans+1]) < Math.abs(x-arr[ans])){
                ans = ans+1;
            }
        }
        
        return ans;
    }
}