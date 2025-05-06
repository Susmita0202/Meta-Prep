class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        boolean hasOdd = false;

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Use frequencies to compute longest palindrome
        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                ans += freq;
            } else {
                ans += freq - 1;
                hasOdd = true;
            }
        }

        // Allow one character with odd frequency in the center
        if (hasOdd) {
            ans += 1;
        }

        return ans;
    }
}
