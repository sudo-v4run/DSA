typedef long long int ll;

const int N = 1e6+1;

int cnt1[N];
int cnt2[N];

class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        memset(cnt1, 0, sizeof(cnt1));
        memset(cnt2, 0, sizeof(cnt2));
        
        for (auto i : nums1) {
            if (i % k == 0) cnt1[i/k] ++;
        }
        for (auto i : nums2) cnt2[i] ++;
        
        ll ans = 0;
        for (int i = 1; i < N; i ++) {
            if (cnt2[i] == 0) continue;
            
            ll sum = 0;
            for (int j = i; j < N; j += i) sum += cnt1[j];
            ans += sum*cnt2[i];
        }
        return ans;
    }
};