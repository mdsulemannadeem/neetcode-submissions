class Solution {
    public boolean isPalindrome(String s) {
    // Convert the string to lower case and remove non-alphanumeric characters
    s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
    
    int start = 0;
    int end = s.length() - 1;

    while (start <= end) {
        if (s.charAt(start) != s.charAt(end)) {
            return false; // If characters don't match, it's not a palindrome
        }
        start++;
        end--;
    }

    return true; // If all characters matched, it's a palindrome
}
}