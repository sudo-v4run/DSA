class Solution {
    public String[] shortestSubstrings(String[] arr) {
        
        int n = arr.length;
        
        HashMap<Integer,HashSet<String>> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            String cur = arr[i];
            if(!hm.containsKey(i)){
                hm.put(i,new HashSet<>());
            }
            
            for(int index = 0 ; index < cur.length() ; index++){
                String temp = "";
                for(int j = index ; j < cur.length() ; j++){
                    temp += cur.charAt(j);
                    hm.get(i).add(temp);
                }
            }
        }

        String res[] = new String[n];

        for(int i = 0 ; i < n ; i++){
            HashSet<String> curHs = hm.get(i);
            String ans = "";
            for(String s : curHs){
                boolean exists = false;
                for(int j = 0 ; j < n ; j++){
                    if(j == i){
                        continue;
                    }
                    if(hm.get(j).contains(s)){
                        exists = true;
                        break;
                    }
                }
                if(!exists){
                    if(ans.equals("") || s.length() < ans.length()){
                        ans = s;
                    }else if(ans.length() == s.length()){
                        if(ans.compareTo(s) > 0){
                             ans = s;
                        }
                    }
                }
            }
            res[i]  = ans;
        }

        return res;
    }
}