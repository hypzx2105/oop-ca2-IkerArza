import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        String[] takeoffQueue = new String[10];
        int takeoffCount = 0;
        String[] landingQueue = new String[10];
        int landingCount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter commands: 'takeoff ', 'land ', 'next', or 'quit'.");

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("quit")) {
                System.out.println("Simulation stopped.");
                break;


            } else if (command.startsWith("takeoff")) {
                if (takeoffCount < 10) {
                    String flightCode = command.split(" ")[1];
                    takeoffQueue[takeoffCount] = flightCode;
                    takeoffCount++;
                    System.out.println("Flight " + flightCode + " queued for takeoff.");
                } else {
                    System.out.println("Takeoff queue is full.");
                }


            } else if (command.startsWith("land")) {
                if (landingCount < 10) {
                    String flightCode = command.split(" ")[1];
                    landingQueue[landingCount] = flightCode;
                    landingCount++;
                    System.out.println("Flight " + flightCode + " queued for landing.");
                } else {
                    System.out.println("Landing queue is full.");
                }


            } else if (command.equals("next")) {

                if (landingCount > 0) {

                    String nextLanding = landingQueue[0];
                    System.out.println("Flight " + nextLanding + " has landed.");

                    for (int i = 1; i < landingCount; i++) {
                        landingQueue[i - 1] = landingQueue[i];
                    }
                    landingCount--;


                } else if (takeoffCount > 0) {

                    String nextTakeoff = takeoffQueue[0];
                    System.out.println("Flight " + nextTakeoff + " has taken off.");

                    for (int i = 1; i < takeoffCount; i++) {
                        takeoffQueue[i - 1] = takeoffQueue[i];
                    }
                    takeoffCount--;
                } else {
                    System.out.println("No flights are waiting.");
                }


            } else {
                System.out.println("Invalid command. Please try again.");
            }

            System.out.print("Landing queue: ");
            for (int i = 0; i < landingCount; i++) {
                System.out.print(landingQueue[i] + " ");
            }
            System.out.println();

            System.out.print("Takeoff queue: ");
            for (int i = 0; i < takeoffCount; i++) {
                System.out.print(takeoffQueue[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

