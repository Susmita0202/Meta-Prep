class Solution {
public:
    void solve(vector<vector<int>>&ans,vector<int>&tmp,vector<int>candidates,int target,int idx){
        if(idx==candidates.size() || target<candidates[idx]){
            if(target==0){
                ans.push_back(tmp);
            }
            return;
        }
        
        tmp.push_back(candidates[idx]);
        solve(ans,tmp,candidates,target-candidates[idx],idx);
        tmp.pop_back();
        solve(ans,tmp,candidates,target,idx+1);
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>>ans;
        vector<int>tmp;
        sort(candidates.begin(),candidates.end());
        solve(ans,tmp,candidates,target,0);
        return ans;
    }
};
