class Solution {
public:
    int longestValidParentheses(string s) {
        int n=s.length();
        int balance=0;
        int lastInvalid =-1;
        int ans=0;
        for(int i=0;i<n;i++){
            if(s[i]==')') balance--;
            else balance++;

            if(balance<0) {
                balance=0;
                lastInvalid =i;
                continue;
            }
            if(balance==0){
                ans=max(ans,i-lastInvalid );
            }
        }
        balance=0;
        lastInvalid =n;

        for(int i=n-1;i>=0;i--){
            if(s[i]=='(') balance--;
            else balance++;

            if(balance<0) {
                balance=0;
                lastInvalid =i;
                continue;
            }
            if(balance==0){
                ans=max(ans,lastInvalid -i);
            }
        }
        return ans;
    }
};
