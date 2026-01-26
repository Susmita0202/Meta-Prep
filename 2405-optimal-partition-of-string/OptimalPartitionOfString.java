class Solution {
    public int partitionString(String s) {
        int i = 0, count = 0;
        boolean[] seen = new boolean[26];
        while(i < s.length()) {
            if(seen[s.charAt(i)-'a']){
                count++;
                seen = new boolean[26];
            }
            seen[s.charAt(i)-'a'] = true;
            i++;
        }
        return count+1;
    }
}
