class Solution {
    public List<Integer> majorityElement(int[] arr) {
        
        int n = arr.length;
        int candidate1 = -1;
        int candidate2 = -1;
        int cnt1 = 0, cnt2 = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(cnt1 == 0 && arr[i] != candidate2){
                candidate1 = arr[i];
                cnt1 = 1;
            }else if(cnt2 == 0 && arr[i] != candidate1){
                candidate2 = arr[i];
                cnt2 = 1;
            }else if(arr[i] == candidate1){
                cnt1++;
            }else if(arr[i] == candidate2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == candidate1){
                cnt1++;
            }else if(arr[i] == candidate2){
                cnt2++;
            }
        }
        
        if(cnt1 > (n/3)){
            res.add(candidate1);
        }
        if(cnt2 > (n/3)){
            res.add(candidate2);
        }
        
        return res;
    }
}