package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    private static String sumOfBinaries(String a, String b) {
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (ai >= 0 || bi >= 0 || carry != 0) {
            int bitA = (ai >= 0) ? a.charAt(ai) - '0' : 0;
            int bitB = (bi >= 0) ? b.charAt(bi) - '0' : 0;

            int sum = bitA + bitB + carry;
            result.append(sum % 2);
            carry = sum / 2;
            ai--;
            bi--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String a = reader.readLine();
            String b = reader.readLine();
            System.out.println(sumOfBinaries(a, b));
        }
    }
}