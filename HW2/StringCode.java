import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods
public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A run is a series of adjacent chars that are the same.
     */
    public static int maxRun(String str) {
        if (str.isEmpty()) return 0;
        int maxLen = 1, currentLen = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                currentLen++;
            }

            else {
                currentLen = 1;
            }

            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }
        return maxLen;
    }

    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following.
     */
    public static String blowup(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (i + 1 < str.length()) {
                    char next = str.charAt(i + 1);
                    result.append(String.valueOf(next).repeat(Math.max(0, num)));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (len <= 0 || a.length() < len || b.length() < len) {
            return false;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i <= a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }

        for (int i = 0; i <= b.length() - len; i++) {
            if (set.contains(b.substring(i, i + len))) return true;
        }

        return false;
    }

    // Main test
    public static void main(String[] args) {
        // Test maxRun
        System.out.println("maxRun tests:");
        System.out.println(maxRun("xxyyyz")); // 3

        // Test blowup
        System.out.println("\nblowup tests:");
        System.out.println(blowup("a3tx2z")); // attttxzzz
        // Test stringIntersect
        System.out.println("\nstringIntersect tests:");
        System.out.println(stringIntersect("abcdef", "cde", 2));   // true
    }
}
