
class Solution {
public:
    bool validPalindrome(string s) {
        int l = 0, r = s.size() - 1;
        auto checkPallindrome = [&](int a, int b) -> bool {
            while (a <= b) {
                if (s[a] != s[b])
                    return false;
                a++;
                b--;
            }
            return true;
        };
        while (l <= r) {
            if (s[l] != s[r]) {
                // Two cases : skip left or skip right
                // After skipping check if the remaining is pallindrome or not
                bool left = checkPallindrome(l + 1, r);
                bool right = checkPallindrome(l, r - 1);

                // We pick whichever is true
                return left || right;
            }
            l++;
            r--;
        }
        return true;
    }
};
