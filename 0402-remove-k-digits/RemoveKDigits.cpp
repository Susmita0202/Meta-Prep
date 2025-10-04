class Solution {
public:
    string removeKdigits(string num, int k) {
        int n = num.size();
        string ans;
        for(int i = 0; i < n; i++){
            while(ans.size() != 0 && num[i] < ans.back() && k > 0){
                ans.pop_back();
                k--;
            }
            ans += num[i];
        }

        while(k){
            ans.pop_back();
            k--;
        }

        int i = 0;
        n = ans.size();
        while(i < n){
            if(ans[i] != '0'){
                break;
            }
            i++;
        }
        ans = ans.substr(i);


        return ans.empty() ? "0" : ans;

    }
};
