class Solution {
    // public int[] assignElements(int[] groups, int[] elements) {
        
    //     int sieve[] = new int[(int)1e6];
    //     Arrays.fill(sieve,-1);

    //     for(int i = 0 ; i < elements.length ; i++){
    //         int cur = elements[i];
    //         if (sieve[cur] != -1){
    //             continue;
    //         }
    //         for(int j = cur ; j <= (int)1e5 ; j = j+cur){
    //             if(sieve[j] == -1){
    //                 sieve[j] = i;
    //             }
    //         }
    //     }

    //     int n = groups.length;

    //     int assigned[] = new int[n];

    //     for(int i = 0 ; i < n ; i++){
    //         assigned[i] = sieve[groups[i]];
    //     }

    //     return assigned;
    // }
    public int[] assignElements(int[] groups, int[] elements) {

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            hm.putIfAbsent(elements[i], i);
        }

        int n = groups.length;

        int[] result = new int[groups.length];

        for (int i = 0 ; i < n ; i++){
            int minIndex = Integer.MAX_VALUE;
            int curGrpSz = groups[i];
            for (int j = 1; j * j <= curGrpSz; j++) {
                if (curGrpSz % j == 0) {
                    if (hm.containsKey(j)){
                        minIndex = Math.min(minIndex, hm.get(j));
                    }
                    if (hm.containsKey(curGrpSz/j)) {
                        minIndex = Math.min(minIndex, hm.get(curGrpSz/j));
                    }
                }
            }
            result[i] = (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
        }

        return result;
    }

}