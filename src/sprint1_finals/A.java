package sprint1_finals;

import java.io.*;
import java.util.Arrays;

public class A {
    private static int[] resultArray(int[] houseNumbers) {
        int dist = -1;
        for (int i = 0; i < houseNumbers.length; i++) {
            if (houseNumbers[i] == 0) {
                dist = i;
            } else if (dist != -1) {
                houseNumbers[i] = i - dist;
            } else {
                houseNumbers[i] = Integer.MAX_VALUE;
            }
        }

        dist = -1;
        for (int i = houseNumbers.length - 1; i >= 0; i--) {
            if (houseNumbers[i] == 0) {
                dist = i;
            } else if (dist != -1) {
                houseNumbers[i] = Math.min(houseNumbers[i], dist - i);
            }
        }

        return houseNumbers;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int streetLength = readInt(reader);
            int[] houseNumbers = resultArray(readArray(reader));

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < streetLength; i++) {
                stringBuilder.append(houseNumbers[i]).append(" ");
            }

            writer.write(String.valueOf(stringBuilder));
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static int[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}