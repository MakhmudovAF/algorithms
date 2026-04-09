package sprint1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class F {
    private static boolean isPalindrome(String text) {
        text = text.toLowerCase().replaceAll("[^\\p{Alnum}]", "");

        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            if (isPalindrome(text)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}