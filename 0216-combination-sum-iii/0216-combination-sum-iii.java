class Solution {
    
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<>();
        solve(k, n, temp, 1);
        return ans;
    }

    private void solve(int k, int n, List<Integer> temp, int idx) {
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            if (k == 0) break;
            temp.add(i);
            solve(k - 1, n - i, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}