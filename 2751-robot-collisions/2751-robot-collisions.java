class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, 
                                               int[] healths, String directions) {
        
        Stack<Integer> s = new Stack<>();
        int n = positions.length;
        
        Integer indices[] = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            indices[i] = i;
        }
        Arrays.sort(indices,(a,b)->{return positions[a]-positions[b];});
        
        for(int i = 0 ; i < n ; i++){
            int index = indices[i];
            char dir = directions.charAt(index);
            
            if(s.isEmpty() && dir == 'L'){
                continue;
            }else if(dir == 'R'){
                s.push(index);
            }else{
                f(s,index,healths);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i : healths){
            if(i != 0){
                res.add(i);
            }
        }
        
        return res;
    }
    public static void f(Stack<Integer> s, int index, int h[]){
        
        while(!s.isEmpty()){
            int top = s.pop();
            
            if(h[top] > h[index]){
                h[top]--;
                h[index] = 0;
                s.push(top);
                return;
            }else if(h[top] == h[index]){
                h[top] = 0;
                h[index] = 0;
                return;
            }else{
                h[top] = 0;
                h[index]--;
            }
        }
    }
}