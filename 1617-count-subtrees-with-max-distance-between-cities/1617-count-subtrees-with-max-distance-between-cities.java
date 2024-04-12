class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        // Since it is a tree(not a graph), there will be unique path between any 2 
        // nodes. Thus, min dist between these 2 nodes will be the max dist as well.
        // for e.g. (1) -> (4) => minD = maxD = 2.
        
        // Also, it is given that distance between the two cities is the number of 
        // edges in the path between them.
        
        // Floyd Warshall...
        
        int matrix[][] = new int[n][n];
        for(int row[] : matrix){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        for(int i = 0 ; i < n ; i++){
            matrix[i][i] = 0;
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            u--;v--;
            
            matrix[u][v] = matrix[v][u] = 1;
        }
        
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    
                    if(matrix[i][k] == Integer.MAX_VALUE || 
                       matrix[k][j] == Integer.MAX_VALUE){
                        
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        
        int ans[] = new int[n-1];
        
        // Generating all possible subsets...
        
        // lets say we have 3 nodes, then the number of selections would be.
        // [select/not select][select/not select][select/not select] = 2*2*2 = 8.
        //  hence 0 through 7 would be
        // 000
        // 001
        // 010
        // 011
        // 100
        // 101
        // 110
        // 111
        
        // 1 represents node taken and 0 represents node not taken...
        // for eg. 110 means, we are considering (1),(2) as a subtree.
        
        // It will also generate invalid subsets(subtree), but we will not consider
        // them -> handled in the code.
        
        // E.g. for invalid subset in the given first example testcase would be->
        // 1001 -> (1),(4) but, as we know, it is not a valid subset/substree.
        // (1)(2)(4) is valid but not (1)(4)
        
        // How do we handle invalidity? Since, it is a tree, for n nodes, there should
        // be n-1 edges, and if for any subset, e != n-1, we ignore it.
            
            
        for(int subset = 0 ; subset < (1<<n) ; subset++){
            
            int curMaxD = getMaxDist(subset,matrix,n);
            
            if(curMaxD > 0){
                ans[curMaxD-1]++;   // -1 for coverting into 0 indexed...
            }
        }
        
        return ans;
    }
    int getMaxDist(int subset, int matrix[][], int n){
        
        int nodes = 0;
        int edges = 0;
        int maxD = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            if((subset & ( 1<<(n-1-i) )) == 0){
                continue;
            }
            
            nodes++;
            
            for(int j = i+1 ; j < n ; j++){
                
                if((subset & ( 1<<(n-1-j) )) == 0){
                    continue;
                }
                
                if(matrix[i][j] == 1){
                    
                    // matrix[i][j] == 1 means single edge, so edges++
                    // i.e. we are counting unique edges...
                    
                    edges++;
                }
                
                maxD = Math.max(maxD,matrix[i][j]);
            }
        }
        
        if(edges != nodes-1){
            return -1;
        }
        
        return maxD;
    }
}