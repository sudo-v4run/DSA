class Solution {
    public List<Integer> countOfPeaks(int[] arr, int[][] queries) {
        
        int n = arr.length;
        SegmentTree st = new SegmentTree(n);
        
        st.buildTree(0,0,n-1,arr);
        
        List<Integer> res = new ArrayList<>();
        
        for(int q[] : queries){
            int a = q[0];
            int b = q[1];
            int c = q[2];
            
            if(a == 1){
                int cur = st.getAns(0,0,n-1,b+1,c-1);
                res.add(cur);
            }else{
                arr[b] = c;
                st.updateTree(0,0,n-1,b,c,arr);
                
                // update adjecent elements...
                if(b-1 >= 0)
                    st.updateTree(0,0,n-1,b-1,arr[b-1],arr);
                if(b+1 < n)
                    st.updateTree(0,0,n-1,b+1,arr[b+1],arr);
            }
        }
        
        return res;
    }
    
    class SegmentTree{
        
        int n;
        int prefix[];
        SegmentTree(int n){
            this.n = n;
            prefix = new int[4*n];
        }
        
        public void buildTree(int prefixIndex, int l, int h, int arr[]){
            
            if(l == h){
                if(l == 0 || l == n-1){
                    prefix[prefixIndex] = 0;
                    return;
                }
                
                if(arr[l] > arr[l-1] && arr[l] > arr[l+1]){
                    prefix[prefixIndex] = 1;
                    
                    return;
                }
                prefix[prefixIndex] = 0;
                return;
            }
            
            int mid = (l+h)/2;
            buildTree(2*prefixIndex+1,l,mid,arr);
            buildTree(2*prefixIndex+2,mid+1,h,arr);
            
            prefix[prefixIndex] = prefix[2*prefixIndex+1] + prefix[2*prefixIndex+2];
        }
        public void updateTree(int prefixIndex, int l, int h, int updateIndex, 
                               int updateVal, int arr[]){
            
            if(l == h){
                
                if(l == 0 || l == n-1){
                    prefix[prefixIndex] = 0;
                    return;
                }
                
                if(updateVal > arr[l-1] && updateVal > arr[l+1]){
                    prefix[prefixIndex] = 1;
                    return;
                }
                
                prefix[prefixIndex] = 0;
                return;
            }
            
            int mid = (l+h)/2;
            
            if(updateIndex <= mid){
                updateTree(2*prefixIndex+1,l,mid,updateIndex,updateVal,arr);
            }else{
                updateTree(2*prefixIndex+2,mid+1,h,updateIndex,updateVal,arr);
            }
            
            prefix[prefixIndex] = prefix[2*prefixIndex+1] + prefix[2*prefixIndex+2];
        }
        public int getAns(int prefixIndex, int l, int h, int x, int y){
            
            if(h < x || l > y){
                return 0;
            }
            
            if(l >= x && h <= y){
                return prefix[prefixIndex];
            }
            
            int mid = (l+h)/2;
            
            int left = getAns(2*prefixIndex+1,l,mid,x,y);
            int right = getAns(2*prefixIndex+2,mid+1,h,x,y);
            
            return left+right;
        }
    }
}