package sprint1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class C {
    private static List<Integer> getNeighbours(List<List<Integer>> matrix, int row, int col) {
        int upRow = row - 1;
        int downRow = row + 1;
        int leftCol = col - 1;
        int rightCol = col + 1;
        List<Integer> list = new ArrayList<>();

        if (upRow >= 0) {
            list.add(matrix.get(upRow).get(col));
        }
        if (downRow < matrix.size()) {
            list.add(matrix.get(downRow).get(col));
        }
        if (leftCol >= 0) {
            list.add(matrix.get(row).get(leftCol));
        }
        if (rightCol < matrix.getFirst().size()) {
            list.add(matrix.get(row).get(rightCol));
        }

        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rowsCount = readInt(reader);
            int colsCount = readInt(reader);
            List<List<Integer>> matrix = readMatrix(reader, rowsCount);
            int rowId = readInt(reader);
            int colId = readInt(reader);
            List<Integer> neighbours = getNeighbours(matrix, rowId, colId);
            for (int element : neighbours) {
                System.out.print(element + " ");
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static List<List<Integer>> readMatrix(BufferedReader reader, int rowsCount) throws IOException {
        List<List<Integer>> matrix = new ArrayList<>(rowsCount);
        for (int i = 0; i < rowsCount; i++) {
            matrix.add(readList(reader));
        }
        return matrix;
    }
}