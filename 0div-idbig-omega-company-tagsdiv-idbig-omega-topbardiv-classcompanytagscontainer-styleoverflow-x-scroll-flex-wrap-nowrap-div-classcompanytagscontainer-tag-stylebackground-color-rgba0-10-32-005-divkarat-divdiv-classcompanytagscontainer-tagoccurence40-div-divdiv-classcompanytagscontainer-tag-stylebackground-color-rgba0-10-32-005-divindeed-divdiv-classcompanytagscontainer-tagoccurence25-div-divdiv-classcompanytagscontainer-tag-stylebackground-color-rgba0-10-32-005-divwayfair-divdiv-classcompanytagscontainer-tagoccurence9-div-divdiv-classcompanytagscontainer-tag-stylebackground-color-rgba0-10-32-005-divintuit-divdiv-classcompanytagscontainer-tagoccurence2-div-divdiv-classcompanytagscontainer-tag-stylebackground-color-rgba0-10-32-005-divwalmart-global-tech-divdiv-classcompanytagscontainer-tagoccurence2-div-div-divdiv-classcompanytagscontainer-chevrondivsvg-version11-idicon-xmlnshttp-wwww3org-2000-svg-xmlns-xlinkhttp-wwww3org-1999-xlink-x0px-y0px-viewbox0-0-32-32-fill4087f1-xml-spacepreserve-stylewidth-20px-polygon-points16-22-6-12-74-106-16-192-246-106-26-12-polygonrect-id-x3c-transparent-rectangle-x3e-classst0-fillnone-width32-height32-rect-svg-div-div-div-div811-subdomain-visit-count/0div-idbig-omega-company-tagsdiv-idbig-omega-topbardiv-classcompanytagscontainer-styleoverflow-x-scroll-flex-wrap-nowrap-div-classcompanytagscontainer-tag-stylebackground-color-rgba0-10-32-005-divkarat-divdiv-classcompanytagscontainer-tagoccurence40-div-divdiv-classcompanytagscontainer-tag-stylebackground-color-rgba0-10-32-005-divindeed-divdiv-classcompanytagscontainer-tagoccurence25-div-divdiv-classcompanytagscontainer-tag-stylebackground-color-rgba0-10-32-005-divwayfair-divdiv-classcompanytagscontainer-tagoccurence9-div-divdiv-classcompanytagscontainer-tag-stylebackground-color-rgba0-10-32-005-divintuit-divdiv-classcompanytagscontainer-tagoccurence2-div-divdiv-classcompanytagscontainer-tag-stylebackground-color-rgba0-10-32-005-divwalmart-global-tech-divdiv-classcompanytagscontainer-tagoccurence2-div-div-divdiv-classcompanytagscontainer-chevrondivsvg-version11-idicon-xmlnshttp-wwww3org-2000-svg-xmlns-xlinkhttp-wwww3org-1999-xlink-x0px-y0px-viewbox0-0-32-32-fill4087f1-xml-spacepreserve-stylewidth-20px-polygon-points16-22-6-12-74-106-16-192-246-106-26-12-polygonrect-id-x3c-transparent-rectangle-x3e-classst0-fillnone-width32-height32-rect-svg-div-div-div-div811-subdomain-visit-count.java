class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        int n = cpdomains.length;
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(String s : cpdomains){
            String cnt_domain[] = s.split(" ");
            
            int cnt = Integer.valueOf(cnt_domain[0]);
            String domain = cnt_domain[1];
            
            hm.put(domain,hm.getOrDefault(domain,0)+cnt);
            String domain_splitted[] = domain.split("\\.");
            
            if(domain_splitted.length == 2){
                String d2 = domain_splitted[1];
                hm.put(d2,hm.getOrDefault(d2,0)+cnt);
            }else{
                String d2 = domain_splitted[1];
                String d3 = domain_splitted[2];
                hm.put(d2+"."+d3,hm.getOrDefault(d2+"."+d3,0)+cnt);
                hm.put(d3,hm.getOrDefault(d3,0)+cnt);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(String key : hm.keySet()){
            String domain = key;
            int cnt = hm.get(key);
            
            res.add(cnt+" "+domain);
        }
        
        return res;
    }
}