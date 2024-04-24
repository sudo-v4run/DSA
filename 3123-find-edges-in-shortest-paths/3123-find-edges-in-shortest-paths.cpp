#define pii pair<int, int>
#define F first
#define S second

typedef long long int ll;

class Solution {
    vector<vector<pii>> g;
    vector<vector<int>> parents;
    
public:
    vector<bool> findAnswer(int n, vector<vector<int>>& edges) {
        g.clear(), g.resize(n);
        parents.clear(), parents.resize(n);
        
        for (auto e: edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].push_back({v, w});
            g[v].push_back({u, w});
        }
        
        vector<ll> dist(n, 1e18);
        dist[0] = 0;
        
        set<pii> s;
        for (int j = 0; j < n; j ++) s.insert({dist[j], j});
        
        while (!s.empty()) {
            int cur = s.begin() -> S;
            s.erase(s.begin());
            
            for (auto [v, w]: g[cur]) {
                ll can = dist[cur] + w;
                if (can > dist[v]) continue;
                
                if (can == dist[v]) parents[v].push_back(cur);
                else {
                    parents[v] = {cur};
                    
                    s.erase({dist[v], v});
                    dist[v] = can;
                    s.insert({dist[v], v});
                }
            }
        }
        
        map<pii, int> edges_ind;
        for (int i = 0; i < edges.size(); i ++) {
            edges_ind[{edges[i][0], edges[i][1]}] = i; 
            edges_ind[{edges[i][1], edges[i][0]}] = i; 
        }
        
        vector<bool> ans(edges.size(), false);
        vector<bool> vis(n, false);
        
        queue<int> q;
        q.push(n-1);        
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            
            for (auto nxt: parents[cur]) {
                // cout << cur << " " << nxt << " " << edges_ind[{cur, nxt}] << endl;
                ans[edges_ind[{cur, nxt}]] = true;
                if (!vis[nxt]) {
                    q.push(nxt);
                    vis[nxt] = true;
                }
            }
        }
        return ans;
    }
};