class Solution {
    public int maximumLength(int[] arr, int k) {
        
        int n = arr.length;
        
        HashMap<Integer,ArrayList<Integer>> indices = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = arr[i]%k;
        }
        
        for(int i = 0 ; i < n ; i++){
            
            if(!indices.containsKey(arr[i])){
                indices.put(arr[i], new ArrayList<>());
            }
            indices.get(arr[i]).add(i);
        }
        
        int max = 1;
        
        for(int i = 0 ; i < k ; i++){
            for(int j = 0 ; j < k ; j++){
                
                ArrayList<Integer> iList = indices.getOrDefault(i, new ArrayList<>());
                ArrayList<Integer> jList = indices.getOrDefault(j, new ArrayList<>());
                int iIndex = 0;
                int jIndex = 0;
                
                int cnt = 0;
                int prevIndex = -1;
                
                while(true){
                    
                    while(iIndex < iList.size() && iList.get(iIndex) <= prevIndex){

                        iIndex++;
                    }

                    if(iIndex == iList.size()){
                        break;
                    }

                    cnt++;
                    prevIndex = iList.get(iIndex);

                    while(jIndex < jList.size() && jList.get(jIndex) <= prevIndex){

                        jIndex++;
                    }

                    if(jIndex == jList.size()){
                        break;
                    }

                    cnt++;
                    prevIndex = jList.get(jIndex);
                }
                
                max = Math.max(max,cnt);
            }
        }
        
        return max;
    }
}