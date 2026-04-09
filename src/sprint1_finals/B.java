package sprint1_finals;

import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int k = readInt(reader);
            writer.write(String.valueOf(readGrid(reader, k)));
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static int readGrid(BufferedReader reader, int k) throws IOException {
        int[] arrayNumber = new int[10];
        int maxNumber = -1;
        int score = 0;

        for (int i = 0; i < 4; i++) {
            String row = reader.readLine();
            for (int j = 0; j < 4; j++) {
                char c = row.charAt(j);

                if (c == '.') continue;

                int num = c - '0';
                arrayNumber[num] += 1;

                if (maxNumber < num) maxNumber = num;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (i > maxNumber) break;
            if (arrayNumber[i] == 0) continue;
            if (arrayNumber[i] <= 2 * k) score++;
        }

        return score;
    }
}