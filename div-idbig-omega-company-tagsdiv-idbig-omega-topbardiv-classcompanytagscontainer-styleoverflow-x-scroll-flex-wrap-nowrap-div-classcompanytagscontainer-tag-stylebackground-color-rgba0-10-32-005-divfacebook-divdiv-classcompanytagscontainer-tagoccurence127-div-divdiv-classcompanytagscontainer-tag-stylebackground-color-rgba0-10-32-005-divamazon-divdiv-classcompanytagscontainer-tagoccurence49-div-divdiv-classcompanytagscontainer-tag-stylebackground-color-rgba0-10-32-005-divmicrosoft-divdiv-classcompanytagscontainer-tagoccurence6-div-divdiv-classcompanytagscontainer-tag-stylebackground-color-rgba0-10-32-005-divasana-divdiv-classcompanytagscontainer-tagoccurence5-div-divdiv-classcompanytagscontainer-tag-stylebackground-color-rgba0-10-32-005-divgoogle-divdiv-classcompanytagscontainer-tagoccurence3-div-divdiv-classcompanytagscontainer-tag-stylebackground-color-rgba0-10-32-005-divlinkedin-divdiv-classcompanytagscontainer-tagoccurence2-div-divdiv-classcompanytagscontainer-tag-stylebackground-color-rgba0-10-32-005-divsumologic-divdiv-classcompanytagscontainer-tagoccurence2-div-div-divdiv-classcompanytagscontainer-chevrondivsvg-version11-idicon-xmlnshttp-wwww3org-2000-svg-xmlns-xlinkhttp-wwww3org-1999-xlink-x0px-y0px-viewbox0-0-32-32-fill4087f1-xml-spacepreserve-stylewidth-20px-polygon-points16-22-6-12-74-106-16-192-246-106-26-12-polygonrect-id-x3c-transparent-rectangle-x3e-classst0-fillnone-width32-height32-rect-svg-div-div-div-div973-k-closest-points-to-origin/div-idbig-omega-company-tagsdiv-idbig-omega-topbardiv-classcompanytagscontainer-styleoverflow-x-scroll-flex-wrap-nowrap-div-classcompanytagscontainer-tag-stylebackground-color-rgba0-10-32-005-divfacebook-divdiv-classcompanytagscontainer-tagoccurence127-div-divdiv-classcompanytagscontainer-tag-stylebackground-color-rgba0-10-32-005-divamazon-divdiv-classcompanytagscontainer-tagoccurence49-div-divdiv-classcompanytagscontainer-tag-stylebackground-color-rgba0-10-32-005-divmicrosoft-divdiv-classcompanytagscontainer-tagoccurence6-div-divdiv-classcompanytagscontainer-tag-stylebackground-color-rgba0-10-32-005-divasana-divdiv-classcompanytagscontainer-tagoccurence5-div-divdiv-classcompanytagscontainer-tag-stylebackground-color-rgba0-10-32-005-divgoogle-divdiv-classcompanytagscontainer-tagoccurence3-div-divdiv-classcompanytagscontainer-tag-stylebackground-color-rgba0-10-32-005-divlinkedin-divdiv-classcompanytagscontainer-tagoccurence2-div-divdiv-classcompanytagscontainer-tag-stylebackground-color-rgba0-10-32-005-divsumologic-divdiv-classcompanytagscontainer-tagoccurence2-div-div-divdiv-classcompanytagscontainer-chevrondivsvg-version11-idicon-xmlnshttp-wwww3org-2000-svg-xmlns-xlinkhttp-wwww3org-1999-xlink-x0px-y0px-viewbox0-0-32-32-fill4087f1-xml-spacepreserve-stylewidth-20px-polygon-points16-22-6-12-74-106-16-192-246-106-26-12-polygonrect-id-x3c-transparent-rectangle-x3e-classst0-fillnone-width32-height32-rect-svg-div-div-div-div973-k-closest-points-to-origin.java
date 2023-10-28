class Solution {
    class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        // Use QuickSelect for O(N) in Avg case and O(N^2) in worst case....
        
        int n = points.length;
        return quickSelect(0,n-1,k-1,points);
        
        // PQ...TC-> O(n.logk)...
        
//         int n = points.length;
//         Pair[] arr = new Pair[n];
        
//         for(int i = 0 ; i < n ; i++){
//             arr[i] = new Pair(points[i][0],points[i][1]);
//         }
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
//             return (b.x*b.x + b.y*b.y)-(a.x*a.x + a.y*a.y);
//         });
        
//         int res[][] = new int[k][2];
//         int j = 0;
        
//         for(Pair p : arr){
//             pq.add(p);
            
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
        
//         while(!pq.isEmpty()){
//             Pair cur = pq.poll();
//             res[j][0] = cur.x;
//             res[j][1] = cur.y;
//             j++;
//         }
        
//         return res;
    }
    public int[][] quickSelect(int l, int h, int k, int points[][]){
        
        if(l <= h){
            
            int pivotIndex = quickSelectSort(l,h,points);
            
            if(pivotIndex == k){
                return Arrays.copyOfRange(points,0,k+1);
            }
            if(k < pivotIndex){
                return quickSelect(l,pivotIndex-1,k,points);
            }else{
                return quickSelect(pivotIndex+1,h,k,points);
            }
        }
        
        return points;
    }
    public int quickSelectSort(int l, int h, int arr[][]){
        int i = l;
        int j = h;
        int pivot = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
        
        while(i <= j){
            while(i <= j && arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1] <= pivot){
                i++;
            }
            while(arr[j][0]*arr[j][0] + arr[j][1]*arr[j][1] > pivot){
                j--;
            }
            
            if(i < j){
                int temp[] = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp[] = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        
        return j;
    }
}