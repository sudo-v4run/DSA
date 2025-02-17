class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        
        int sieve[] = new int[(int)1e6];
        Arrays.fill(sieve,-1);

        for(int i = 0 ; i < elements.length ; i++){
            int cur = elements[i];
            if (sieve[cur] != -1){
                continue;
            }
            for(int j = cur ; j <= (int)1e5 ; j = j+cur){
                if(sieve[j] == -1){
                    sieve[j] = i;
                }
            }
        }

        int n = groups.length;

        int assigned[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            assigned[i] = sieve[groups[i]];
        }

        return assigned;
    }
}