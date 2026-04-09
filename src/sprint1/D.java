package sprint1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.io.IOException;


public class D {
    private static int getWeatherRandomness(List<Integer> temperatures) {
        int n = temperatures.size();
        if (n == 1) return 1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean leftCheck = (i == 0) || temperatures.get(i) > temperatures.get(i - 1);
            boolean rightCheck = (i == n - 1) || temperatures.get(i) > temperatures.get(i + 1);

            if (leftCheck && rightCheck) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfDays = readInt(reader);
            List<Integer> temperatures = readList(reader);
            int chaosNumber = getWeatherRandomness(temperatures);
            System.out.println(chaosNumber);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}