class Solution {
    
    static HashMap<String, Integer> hm;
    public int mostFrequentPrime(int[][] mat) {
        
        
        int m = mat.length;
        int n = mat[0].length;
        
        hm = new HashMap<>();
        
        String arr[][] = new String[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = String.valueOf(mat[i][j]);
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                f(i,j,arr[i][j],arr);
            }
        }
        
        int maxF = Integer.MIN_VALUE;
        int res = -1;
        
        for(String k : hm.keySet()){
            int f = hm.get(k);
            
            if(f > maxF){
                maxF = f;
                res = Integer.valueOf(k);
            }
            
            if(f == maxF){
                res = Math.max(res,Integer.valueOf(k));
            }
        }
        
        return res;
    }
    
    public static void f(int r, int c, String cur, String arr[][]){
        
        int m = arr.length;
        int n = arr[0].length;
        
        String temp = cur;
        
//         for(int i = r-1 ; i >= 0 ; i--){
//             temp += arr[i][c];
//             if(temp.length() >= 2 && isPrime(temp)){
//                 hm.put(temp,hm.getOrDefault(temp,0)+1);
//             }
//         }
        
//         temp = cur;
        
        for(int i = -1 ; i <= 1 ; i++){
            for(int j = -1 ; j <= 1 ; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                temp = cur;
                
                int nr = r+i;
                int nc = c+j;
                
                while(nr >=0 && nr < m && nc >=0 && nc < n){
                    temp += arr[nr][nc];
                    
                    if(temp.length() >= 2 && isPrime(temp)){
                        hm.put(temp,hm.getOrDefault(temp,0)+1);
                    }
                    
                    nr += i;
                    nc += j;
                }
                
            }
        }
        
//         for(int i = r-1, j = c-1 ; i >= 0 && j >= 0 ; i--, j--){
//             temp += arr[i][j];
//             if(temp.length() >= 2 && isPrime(temp)){
//                 hm.put(temp,hm.getOrDefault(temp,0)+1);
//             }
//         }
        
//         temp = cur;
        
//         for(int i = c-1 ; i >= 0 ; i--){
//             temp += arr[r][i];
//             if(temp.length() >= 2 && isPrime(temp)){
//                 hm.put(temp,hm.getOrDefault(temp,0)+1);
//             }
//         }
        
//         temp = cur;
        
//         for(int i = r+1, j = c-1 ; i < m && j >= 0 ; i++,j--){
//             temp += arr[i][j];
//             if(temp.length() >= 2 && isPrime(temp)){
//                 hm.put(temp,hm.getOrDefault(temp,0)+1);
//             }
//         }
        
//         temp = cur;
        
//         for(int i = r+1 ; i < m ; i++){
//             temp += arr[i][c];
//             if(temp.length() >= 2 && isPrime(temp)){
//                 hm.put(temp,hm.getOrDefault(temp,0)+1);
//             }
//         }
        
//         temp = cur;
//         for(int i = r+1, j = c+1 ; i < m && j < n ; i++,j++){
//             temp += arr[i][j];
//             if(temp.length() >= 2 && isPrime(temp)){
//                 hm.put(temp,hm.getOrDefault(temp,0)+1);
//             }
//         }
        
//         temp = cur;
        
//         for(int i = c+1 ; i < n ; i++){
//             temp += arr[r][i];
//             if(temp.length() >= 2 && isPrime(temp)){
//                 hm.put(temp,hm.getOrDefault(temp,0)+1);
//             }
//         }
        
//         temp = cur;
//         for(int i = r-1, j = c+1 ; i >= 0 && j < n ; i--,j++){
//             temp += arr[i][j];
//             if(temp.length() >= 2 && isPrime(temp)){
//                 hm.put(temp,hm.getOrDefault(temp,0)+1);
//             }
//         }
        
        
    }
    public static void ul(int r, int c, String cur, String arr[][]){
        
        int m = arr.length;
        int n = arr[0].length;
        
        if(cur.length() >= 2 && isPrime(cur)){
            hm.put(cur,hm.getOrDefault(cur,0)+1);
        }
        
        if(r-1 >= 0 && c-1 >= 0){
            f(r+1,c,cur+arr[r+1][c],arr);
        }
        
    }

    public static boolean isPrime(String s){
        
        int x = Integer.valueOf(s);
        
        for(int i = 2 ; i < x ; i++){
            if(x%i == 0){
                return false;
            }
        }
        
        return true;
    }
}