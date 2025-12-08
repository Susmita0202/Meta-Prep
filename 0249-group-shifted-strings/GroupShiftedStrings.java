class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = getKey(s); // generate unique shifting pattern
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Generate a shift pattern
    // Example: "abc" -> "1#1#"
    //          "bcd" -> "1#1#"  (same pattern)
    private String getKey(String s) {
        if (s.length() == 1) return "single";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            if (diff < 0) diff += 26; // wrap around
            sb.append(diff).append('#');
        }
        return sb.toString();
    }
}
