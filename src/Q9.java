import java.util.Scanner;
import java.util.Stack;

public class Q9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> results = new Stack<>();
        System.out.println("Enter one number or operator per line, Q to quit.");

        boolean done = false;

        while (!done) {
            String input = in.nextLine();


            if (input.equals("+")) {
                results.push(results.pop() + results.pop());
            } else if (input.equals("-")) {
                int arg2 = results.pop();
                results.push(results.pop() - arg2);
            } else if (input.equals("*") || input.equals("x")) {
                results.push(results.pop() * results.pop());
            } else if (input.equals("/")) {
                int arg2 = results.pop();
                results.push(results.pop() / arg2);
            } else if (input.equalsIgnoreCase("Q")) {
                done = true;
            } else {

                try {
                    results.push(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a number or valid operator (+, -, *, /).");
                }
            }
            System.out.println("Stack: " + results);
        }
        System.out.println("Exiting calculator. Final stack: " + results);
        in.close();
    }
}
