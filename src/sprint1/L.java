package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L {
    private static char getExcessiveLetter(String s, String t) {
        for (char c : s.toCharArray()) {
            t = t.replaceFirst(String.valueOf(c), "");
        }

        return t.charAt(0);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();
            System.out.println(getExcessiveLetter(s, t));
        }
    }
}