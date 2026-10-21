import java.util.Scanner;

public class Task2 {

    public static int calculateTotal(int[] marks) {
        int total = 0;

        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
        }

        return total;
    }

    public static double calculatePercentage(int total, int n) {
        return (double) total / (n * 100) * 100;
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of subjects must be positive.");
            sc.close();
            return;
        }

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter marks for subject "
                        + (i + 1) + " (0-100): ");

                int mark = sc.nextInt();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.out.println(
                            "Invalid marks! Enter marks between 0 and 100.");
                }
            }
        }

        int total = calculateTotal(marks);
        double percentage = calculatePercentage(total, n);
        String grade = calculateGrade(percentage);

        System.out.println("\n----- Student Result -----");
        System.out.println("Total Marks: " + total + " / " + (n * 100));
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}