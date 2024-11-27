
import java.util.Scanner;

    public class Q2 {
        public static void main(String[] args) {
            int[] driveway = new int[10];
            int drivewayCount = 0;
            int[] street = new int[10];
            int streetCount = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a positive number to add a car, negative to remove a car, 0 to stop):");

            while (true) {
                int command = scanner.nextInt();

                if (command == 0) {
                    System.out.println("Simulation stopped.");
                    break;
                } else if (command > 0) {

                    if (drivewayCount < 10) {
                        driveway[drivewayCount] = command;
                        drivewayCount++;
                        System.out.println("Car " + command + " added to the driveway.");
                    } else {
                        System.out.println("The driveway is full. Cannot add more cars.");
                    }
                } else {

                    int carToRetrieve = -command;
                    boolean found = false;


                    for (int i = drivewayCount - 1; i >= 0; i--) {
                        if (driveway[i] == carToRetrieve) {
                            found = true;


                            while (driveway[drivewayCount - 1] != carToRetrieve) {
                                street[streetCount] = driveway[drivewayCount - 1];
                                drivewayCount--;
                                streetCount++;
                            }


                            drivewayCount--;
                            System.out.println("Car " + carToRetrieve + " retrieved from the driveway.");


                            while (streetCount > 0) {
                                driveway[drivewayCount] = street[streetCount - 1];
                                drivewayCount++;
                                streetCount--;
                            }

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Car " + carToRetrieve + " is not in the driveway.");
                    }
                }


                System.out.print("Current driveway: ");
                for (int i = 0; i < drivewayCount; i++) {
                    System.out.print(driveway[i] + " ");
                }
                System.out.println();
            }

            scanner.close();
        }
    }


