class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,List<String>> hm = new HashMap<>();
        
        // Using Arrays.sort() - TC: O(n.mlongm)
        // Using freq Array - TC : O(n.m) 
        
        for(String cur : strs){
            
            char charr[] = new char[26];
            
            for(char ch : cur.toCharArray()){
                charr[ch-'a']++;
            }
            
            // char charr[] = cur.toCharArray();
            // Arrays.sort(charr);
            
            String keyS = String.valueOf(charr);
            
            if(!hm.containsKey(keyS)){
                hm.put(keyS,new ArrayList<String>());
            }
            hm.get(keyS).add(cur);
        }
        
        
        return new ArrayList<>(hm.values());
        
    }
    
    
    
//     public List<List<String>> groupAnagrams(String[] strs) {
        
//         List<List<String>> res = new ArrayList<List<String>>();
//         int n = strs.length;
//         boolean vis[] = new boolean[n];
        
//         for(int i = 0 ; i < n ; i++){
            
//             if(vis[i] == true)
//                 continue;
            
//             ArrayList<String> ans = new ArrayList<>();
//             String cur = strs[i];
//             ans.add(cur);
            
//             for(int j = i+1 ; j < n ; j++){
                
//                 String cmp = strs[j];
//                 boolean isAnagram = checkAnagram(cur,cmp);
                
//                 if(isAnagram && vis[j] != true){
//                     vis[i] = true;
//                     vis[j] = true;
//                     ans.add(cmp);
//                 }
                
//             }
            
//             res.add(ans);
//         }
        
//         return res;
//     }
//     public boolean checkAnagram(String s, String t) {
        
//         int arr[] = new int[26];
        
//         for(char ch : s.toCharArray()){
//             arr[ch-'a']++;
//         }
        
//         for(char ch : t.toCharArray()){
//             arr[ch-'a']--;
//         }
        
//         for(int i : arr){
//             if(i!=0){
//                 return false;
//             }
//         }
        
//         return true;
//     }
}