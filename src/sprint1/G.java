package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G {
    private static String getBinaryNumber(int n) {
        StringBuilder string = new StringBuilder();
        if (n == 0){
            return "0";
        }

        while (n != 0) {
            string.insert(0, n % 2);
            n /= 2;
        }
        return string.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            System.out.println(getBinaryNumber(n));
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}