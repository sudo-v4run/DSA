class Solution {
    class Pair{
        int diff, ele;
        Pair(int diff, int ele){
            this.diff = diff;
            this.ele = ele;
        }
    }
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.diff < b.diff){
                return 1;
            }else if(a.diff == b.diff && a.ele < b.ele){
                return 1;
            }
            return -1;
        });
        
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            pq.add(new Pair(Math.abs(nums[i]-x),nums[i]));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        while(!pq.isEmpty()){
            res.add(pq.poll().ele);
        }
        
        Collections.sort(res);
        
        return res;
        
        
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
}