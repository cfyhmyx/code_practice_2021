// https://leetcode.com/problems/design-file-system/

import java.util.HashMap;
import java.util.Map;

public class Cp1166 {
    public static void main(String args[]) {
    }

    class FileSystem {
        private Map<String, Integer> file = new HashMap<>();

        public FileSystem() {
            file.put("", -1);
        }

        // Main idea: map.
        // Time: O(n).
        // Space: O(n).
        public boolean create(String path, int value) {
            int idx = path.lastIndexOf("/");
            String parent = path.substring(0, idx);
            if (!file.containsKey(parent)) {
                return false;
            }
            return file.putIfAbsent(path, value) == null;
        }

        public int get(String path) {
            return file.getOrDefault(path, -1);
        }
    }
}
