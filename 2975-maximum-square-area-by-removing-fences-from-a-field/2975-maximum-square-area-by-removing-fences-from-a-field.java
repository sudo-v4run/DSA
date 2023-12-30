class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        
        int mod = (int)1e9+7;
        
        ArrayList<Integer> h = new ArrayList<>();
        h.add(1);
        h.add(m);  
        for(int fence : hFences){
            h.add(fence);
        }
        
        ArrayList<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(n);
        for(int fence : vFences){
            v.add(fence);
        }
        
        Collections.sort(h);
        Collections.sort(v);
        
        long maxArea = -1;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0 ; i < h.size() ; i++){
            for(int j = i+1 ; j < h.size() ; j++){
                
                int length = h.get(j) - h.get(i);
                hs.add(length);
            }
        }
        
        for(int i = 0 ; i < v.size() ; i++){
            for(int j = i+1 ; j < v.size() ; j++){
                
                int length = v.get(j) - v.get(i);
                if(hs.contains(length)){
                    maxArea = Math.max(maxArea,length);
                }
            }
        }
        
        if(maxArea == -1){
            return -1;
        }
        
        return (int)((maxArea*maxArea)%mod);
    }
}