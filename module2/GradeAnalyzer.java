// import java.io.*; 
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
 
public class GradeAnalyzer {
    static private int invalidLines = 0; // to count invalid lines
 
    public static void main(String[] args) {
        // Optional
        if (args.length < 1) {
            System.out.println("Please provide a filename as an argument.");
            return;
        }
        String filename = args[0]; // could also verify validity

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(filename);

        // Step 2: calculate statistics
        double average = calculateAverage(scores);
        // Main Test
        // System.out.println("Test should equal 2.0. Result: " + calculateAverage(new ArrayList<>(List.of(1,2,3))));

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        // get min and max
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        // Step 3: write and print report
        if (scores.size() == 0) {
            System.out.println("No valid scores to analyze.");
            return;
        }

        String outputFile = "report.txt";
        writeReport(scores, average, highest, lowest, outputFile);

        // printing summary to console
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();

        // reading file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // verifying input
                    // skipping empty lines
                    // allowing for grade values outside 0-100
                    // skipping non-integer types
                try {
                    line = line.trim();
                    if (line.isEmpty()) {
                        System.out.println("Skipping empty line");
                        invalidLines++;
                        continue;
                    }
                    scores.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Not an integer: " + line);
                    invalidLines++;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        double avg = 0.0;

        if (scores.size() > 0) {
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            avg = (double) sum / scores.size();
        }

        return avg;
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("=== Grade Analysis Report ===\n");
            writer.write(String.format("Total scores processed: %d%n", scores.size()));
            writer.write(String.format("Invalid lines skipped: %d%n", invalidLines));

            writer.newLine();
            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));

            // counting letter grades
            int countA = 0; // 90+ inclusive
            int countB = 0; // 80-89 inclusive
            int countC = 0; // 70-79 inclusive
            int countD = 0; // 60-69 inclusive
            int countF = 0; // 0-59 inclusive

            for (int score : scores) {
                if (score >= 90) {
                    countA++;
                } else if (score >= 80) {
                    countB++;
                } else if (score >= 70) {
                    countC++;
                } else if (score >= 60) {
                    countD++;
                } else {
                    countF++;
                }
            }

            writer.newLine();
            writer.write("Grade distribution:\n");
            writer.write(String.format("A (90+): %d%n", countA));
            writer.write(String.format("B (80-89): %d%n", countB));
            writer.write(String.format("C (70-79): %d%n", countC));
            writer.write(String.format("D (60-69): %d%n", countD));
            writer.write(String.format("F (59 and below): %d%n", countF));

            System.out.println("Report write complete: " + outputFile + "\n");

        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
} 