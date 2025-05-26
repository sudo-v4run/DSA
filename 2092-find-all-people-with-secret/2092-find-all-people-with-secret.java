class Solution {
    class DSU{
        int par[];
        DSU(int n){
            par = new int[n];
            for(int i = 0 ; i < n ; i++){
                par[i] = i;
            }
        }

        int findParent(int x){
            if(par[x] == x){
                return x;
            }
            return par[x] = findParent(par[x]);
        }

        void union(int a, int b){

            int parOfa = findParent(a);
            int parOfb = findParent(b);

            if(parOfa == parOfb){
                return;
            }

            par[parOfa] = parOfb;
        }

        void resetParent(int x){
            par[x] = x;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        DSU dsu = new DSU(n);

        Arrays.sort(meetings,(a,b)->{
            return a[2]-b[2];
        });

        HashSet<Integer> personsWithSec = new HashSet<>();
        personsWithSec.add(0);
        personsWithSec.add(firstPerson);

        dsu.union(0,firstPerson);

        HashSet<Integer> res = new HashSet<>();
        res.add(0);
        res.add(firstPerson);

        for(int i = 0 ; i < meetings.length ; i++){
            
            int curTime = meetings[i][2];

            HashSet<Integer> cur = new HashSet<>();

            while(i < meetings.length && meetings[i][2] == curTime){
                int x = meetings[i][0];
                int y = meetings[i][1];

                dsu.union(x, y);

                cur.add(x);
                cur.add(y);

                i++;
            }
            i--;

            for(int p : cur){
                if(dsu.findParent(p) == dsu.findParent(0)){
                    res.add(p);
                }else{
                    dsu.resetParent(p);
                }
            }

        }

        List<Integer> ans = new ArrayList<>();
        for(int x : res){
            ans.add(x);
        }

        return ans;
    }
}