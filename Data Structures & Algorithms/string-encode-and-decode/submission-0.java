class Solution {
// Encodes a list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // Find the position of the delimiter '#'
            int delimiterIndex = s.indexOf('#', i);
            // Get the length of the next string
            int length = Integer.parseInt(s.substring(i, delimiterIndex));
            // Extract the string using the length
            String str = s.substring(delimiterIndex + 1, delimiterIndex + 1 + length);
            decoded.add(str);
            // Move the pointer to the next part
            i = delimiterIndex + 1 + length;
        }
        return decoded;
    }
}
