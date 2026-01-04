class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return isIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":")) {
            return isIPv6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    private boolean isIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;

        for (String part : parts) {
            // empty or length > 3 is invalid
            if (part.length() == 0 || part.length() > 3) return false;

            // leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') return false;

            // digits only
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }

            int val = Integer.parseInt(part);
            if (val < 0 || val > 255) return false;
        }
        return true;
    }

    private boolean isIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return false;

        for (String part : parts) {
            // length must be 1 to 4
            if (part.length() == 0 || part.length() > 4) return false;

            // hexadecimal check
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c) &&
                    !(c >= 'a' && c <= 'f') &&
                    !(c >= 'A' && c <= 'F')) {
                    return false;
                }
            }
        }
        return true;
    }
}
