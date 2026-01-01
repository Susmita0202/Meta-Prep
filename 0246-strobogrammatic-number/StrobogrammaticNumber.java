class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;

        while (left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);

            if (!isValidPair(l, r)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValidPair(char a, char b) {
        return (a == '0' && b == '0') ||
               (a == '1' && b == '1') ||
               (a == '8' && b == '8') ||
               (a == '6' && b == '9') ||
               (a == '9' && b == '6');
    }
}
