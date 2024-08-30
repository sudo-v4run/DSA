class Solution {
    public int countPairs(int[] arr) {
        
        int n = arr.length;

        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            for(int j = i+1 ; j < n ; j++){
                
                String x = String.valueOf(arr[i]);
                String y = String.valueOf(arr[j]);
                
                if(x.length() > y.length()){
                    String temp = x;
                    x = y;
                    y = temp;
                }
                
                if(x.length() < y.length()){
                    while(x.length() != y.length()){
                        x = '0'+x;
                    }
                }
                
                char xarr[] = x.toCharArray();
                
                if(x.equals(y)){
                    ans++;
                    continue;
                }
                
                
                for(int xi = 0 ; xi < xarr.length ; xi++){
                    for(int xj = xi+1 ; xj < xarr.length ; xj++){
                        char t = xarr[xj];
                        xarr[xj] = xarr[xi];
                        xarr[xi] = t;
                        
                        if(String.valueOf(xarr).equals(y)){
                            ans++;
                            
                            xi = xarr.length;
                            break;
                        }
                        
                        t = xarr[xj];
                        xarr[xj] = xarr[xi];
                        xarr[xi] = t;
                    }
                }
            }
        }
        
        return ans;
    }
}