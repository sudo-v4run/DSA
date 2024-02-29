class Solution {
    public int earliestSecondToMarkIndices(int[] arr, int[] changeIndices) {
        
        int m = changeIndices.length;
        
        int ans = -1;
        
        int lo = 1;
        int hi = m;
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(isValid(arr,changeIndices,mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    public boolean isValid(int[] arr, int[] changeIndices, int n){
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            if(arr[changeIndices[i]-1] == 0){
                continue;
            }
            if(!hm.containsKey(changeIndices[i])){
                hm.put(changeIndices[i],i);
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.arrVal-b.arrVal;});
        long extra = 0;
        
        for(int i = n-1 ; i >= 0 ; i--){
            if(!hm.containsKey(changeIndices[i])){
                extra++;
                continue;
            }
            if(hm.get(changeIndices[i]) != i){
                extra++;
            }else{
                pq.add(new Pair(changeIndices[i],arr[changeIndices[i]-1]));
                if(extra > 0){
                    extra--;
                }else{
                    pq.poll();
                    extra++;
                }
            }
        }
        
        long markedSum = 0;
        while(!pq.isEmpty()){
            markedSum += pq.poll().arrVal+1;
        }
        
        long arrSum = 0;
        for(int x : arr){
            arrSum += x+1;
        }
        long req = arrSum - markedSum;
        
        return req <= extra;
    }
    class Pair{
        int changeIndVal, arrVal;
        Pair(int changeIndVal, int arrVal){
            this.changeIndVal = changeIndVal;
            this.arrVal = arrVal;
        }
    }
}