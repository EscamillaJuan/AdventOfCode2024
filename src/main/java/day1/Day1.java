package day1;

import utils.Utils;

import java.util.*;
import java.util.stream.IntStream;

public class Day1 {

    /**
     * This method gives the Advent
     * Of Code 2024 day 1 part 1 solution
     */
    public static void solvePart1() {
        try {
            List<String> input = Utils.readInputLineByLine("D:\\juane\\Documents\\Development\\AdventOfCode2024\\src\\main\\java\\day1\\input.txt");
            if (input.isEmpty()) {
                System.out.println("Input empty");
                return;
            }
            List<Integer> leftNumbers = new ArrayList<>();
            List<Integer> rightNumbers = new ArrayList<>();
            for (String item : input) {
                String[] lineNumbers = item.split("\\s{3}");
                if (lineNumbers.length != 2) {
                    System.out.println("Invalid line format");
                    return;
                }
                leftNumbers.add(Integer.parseInt(lineNumbers[0]));
                rightNumbers.add(Integer.parseInt(lineNumbers[1]));
            }

            if (leftNumbers.size() != rightNumbers.size()) {
                System.out.println("Size of number lists are different");
                return;
            }
            int result = calculateTotalDistanceWithSum(leftNumbers, rightNumbers);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Private method to order and
     * sum the 2 number lists
     * which represent location IDs
     * @param leftNumbers left side IDs
     * @param rightNumbers right side IDs
     * @return int which represent the total distance
     */
    private static int calculateTotalDistanceWithSum(List<Integer> leftNumbers, List<Integer> rightNumbers) {
        Collections.sort(leftNumbers);
        Collections.sort(rightNumbers);
        return IntStream.range(0, leftNumbers.size())
                .map(i -> Math.abs(leftNumbers.get(i) - rightNumbers.get(i)))
                .sum();
    }

    /**
     * This method gives the Advent
     * Of Code 2024 day 1 part 2 solution
     */
    public static void solvePart2() {
        try {
            List<String> input = Utils.readInputLineByLine("D:\\juane\\Documents\\Development\\AdventOfCode2024\\src\\main\\java\\day1\\input.txt");
            if (input.isEmpty()) {
                System.out.println("Input empty");
                return;
            }
            List<Integer> leftNumbers = new ArrayList<>();
            List<Integer> rightNumbers = new ArrayList<>();
            for (String item : input) {
                String[] lineNumbers = item.split("\\s{3}");
                if (lineNumbers.length != 2) {
                    System.out.println("Invalid line format");
                    return;
                }
                leftNumbers.add(Integer.parseInt(lineNumbers[0]));
                rightNumbers.add(Integer.parseInt(lineNumbers[1]));
            }

            if (leftNumbers.size() != rightNumbers.size()) {
                System.out.println("Size of number lists are different");
                return;
            }
            int result = calculateTotalDistanceWithOccurrences(leftNumbers, rightNumbers);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Private method to check all
     * left location IDs
     * occurrences in the right element list
     * and multiply each location ID by the
     * number of occurrences
     * @param leftNumbers left side IDs
     * @param rightNumbers right side IDs
     * @return int which represent the total distance
     */
    private static int calculateTotalDistanceWithOccurrences(List<Integer> leftNumbers, List<Integer> rightNumbers) {
        int[] occurrences = leftNumbers.stream().mapToInt(leftNumber -> Collections.frequency(rightNumbers, leftNumber)).toArray();
        return IntStream.range(0, leftNumbers.size())
                .map(i -> Math.abs(leftNumbers.get(i) * occurrences[i]))
                .sum();
    }
}
