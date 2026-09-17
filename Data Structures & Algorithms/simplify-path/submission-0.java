class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");
        
        // 1. Process each part using a simple for loop
        for (int i = 0; i < parts.length; i++) {
            String dir = parts[i];
            
            if (dir.equals("") || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(dir);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        // 2. Rebuild the path using a simple loop over the stack size
        for (int i = 0; i < st.size(); i++) {
            result.append("/").append(st.get(i));
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
}
