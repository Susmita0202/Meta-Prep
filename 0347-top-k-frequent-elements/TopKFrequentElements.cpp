class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> mp;

        for(int i : nums) {
            mp[i]++; // frequency count
        }

        vector<int> ans;
        vector<pair<int, int>> temp;

        for(auto it : mp) {
            temp.push_back(make_pair(it.second, it.first));
        }

        sort(temp.rbegin(), temp.rend());

        for(int i = 0; i < temp.size() && k != 0; i++) {
            ans.push_back(temp[i].second);
            k--;
        }
        return ans;

    }
};
