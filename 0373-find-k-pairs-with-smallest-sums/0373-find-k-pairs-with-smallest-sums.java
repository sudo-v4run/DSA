class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {return a.sum - b.sum;});

        for(int i = 0; i < k && i < nums1.length; i++){
            pq.add(new Pair(nums1[i]+nums2[0], new ArrayList<>(List.of(i,0))));
        }

        while(res.size() < k){
            Pair pop = pq.poll();
            List<Integer> uv = pop.uv;
            int u = uv.get(0);
            int v = uv.get(1);
            res.add(new ArrayList<>(List.of(nums1[u],nums2[v])));
            if(uv.get(1)+1 == nums2.length){
                continue;
            }
            pq.add(new Pair(nums1[u]+nums2[v+1], new ArrayList<>(List.of(u,v+1))));
        }
        
        return res;
    }
    class Pair{
        int sum;
        List<Integer> uv;
        Pair(int sum, List<Integer> uv){
            this.sum = sum;
            this.uv = uv;
        }
    }
}