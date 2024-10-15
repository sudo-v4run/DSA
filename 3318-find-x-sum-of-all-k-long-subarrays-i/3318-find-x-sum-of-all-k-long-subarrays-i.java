class Solution {
    public int[] findXSum(int[] arr, int k, int x) {
        
        int n = arr.length;
        
        int res[] = new int[n-k+1];
        
        for(int i = 0 ; i < n-k+1 ; i++){
            
            HashMap<Integer,Integer> hm = new HashMap<>();
            
            for(int j = i ; j < i+k ; j++){
                
                hm.put(arr[j],hm.getOrDefault(arr[j],0)+1);
            }
            
            ArrayList<Pair> temp = new ArrayList<>();
            
            for(int key : hm.keySet()){
                temp.add(new Pair(key,hm.get(key)));
            }
            
            Collections.sort(temp,(a,b)->{
                if(a.f == b.f){
                    return b.x - a.x;
                }
                return b.f - a.f;
            });
            
            int xsum = 0;
            
            for(int j = 0 ; j < temp.size() && j < x ; j++){
                xsum += (temp.get(j).x)*temp.get(j).f;
            }
            
            res[i] = xsum;
        }
        
        return res;
    }
    class Pair{
        int x, f;
        Pair(int x, int f){
            this.x = x;
            this.f = f;
        }
    }
}