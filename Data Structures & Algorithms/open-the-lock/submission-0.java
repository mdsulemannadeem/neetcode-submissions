public class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;

        Set<String> visit = new HashSet<>(Arrays.asList(deadends));
        if (visit.contains("0000")) return -1;

        Set<String> begin = new HashSet<>();
        begin.add("0000");
        Set<String> end = new HashSet<>();
        end.add(target);
        int steps = 0;

        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }

            steps++;
            Set<String> temp = new HashSet<>();
            for (String lock : begin) {
                for (int i = 0; i < 4; i++) {
                    for (int j : new int[]{-1, 1}) {
                        char[] chars = lock.toCharArray();
                        chars[i] = (char) ((chars[i] - '0' + j + 10) % 10 + '0');
                        String nextLock = new String(chars);

                        if (end.contains(nextLock)) return steps;
                        if (visit.contains(nextLock)) continue;

                        visit.add(nextLock);
                        temp.add(nextLock);
                    }
                }
            }
            begin = temp;
        }
        return -1;
    }
}