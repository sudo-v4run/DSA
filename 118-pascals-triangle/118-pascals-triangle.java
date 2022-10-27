class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rl = new ArrayList<List<Integer>>();
        
        List<Integer> cl;
        
        for(int i = 0 ; i < numRows ; i++){
            cl = new ArrayList<Integer>();
            for(int j = 0 ; j <= i ; j++){
                if( j==0 || j==i ){
                    cl.add(1);
                }else{
                    cl.add(rl.get(i-1).get(j-1) + rl.get(i-1).get(j));
                }
            }
            rl.add(cl);
        }
        
        return rl;
    }
}