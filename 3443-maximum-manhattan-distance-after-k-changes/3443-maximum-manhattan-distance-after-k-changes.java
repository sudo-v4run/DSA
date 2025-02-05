class Solution {
    public int maxDistance(String s, int k) {

        int ans = -1;

        char vertical[] = {'N' , 'S'};
        char horizontal[] = {'W' , 'E'};

        for(char ver : vertical){
            for(char hor : horizontal){
                int remK = k;
                int x = 0;
                int y = 0;
                for(char ch : s.toCharArray()){

                    if(ch == ver && remK > 0){
                        if(ch == 'N'){
                            ch = 'S';
                        }else{
                            ch = 'N';
                        }
                        remK--;
                    }else if(ch == hor && remK > 0){
                        if(ch == 'W'){
                            ch = 'E';
                        }else{
                            ch = 'W';
                        }
                        remK--;
                    }

                    x = x + ((ch == 'N') ? 1 : 0);
                    x = x - ((ch == 'S') ? 1 : 0);
                    y = y - ((ch == 'W') ? 1 : 0);
                    y = y + ((ch == 'E') ? 1 : 0);

                    ans = Math.max(ans,Math.abs(x)+Math.abs(y));
                }
            }
        }

        return ans;
    }
}