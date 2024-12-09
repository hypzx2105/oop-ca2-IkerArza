import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Blockk {
    int quantity;
    double price;

    public Blockk(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}

public class Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Block> queue = new LinkedList<>();
        double totalGain = 0;

        System.out.println("Enter commands (buy quantity price, sell quantity, quit):");
        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equalsIgnoreCase("buy")) {
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                queue.add(new Block(quantity, price));
                System.out.println("Bought " + quantity + " shares at $" + price + " each.");
            } else if (parts[0].equalsIgnoreCase("sell")) {
                int quantityToSell = Integer.parseInt(parts[1]);
                double sellPrice = Double.parseDouble(parts[2]);
                double gain = 0;

                while (quantityToSell > 0 && !queue.isEmpty()) {
                    Block block = queue.peek();
                    if (block.quantity <= quantityToSell) {
                        gain += block.quantity * (sellPrice - block.price);
                        quantityToSell -= block.quantity;
                        queue.poll();
                    } else {
                        gain += quantityToSell * (sellPrice - block.price);
                        block.quantity -= quantityToSell;
                        quantityToSell = 0;
                    }
                }

                if (quantityToSell > 0) {
                    System.out.println("Not enough shares to sell!");
                } else {
                    totalGain += gain;
                    System.out.println("Sold shares for a gain of $" + gain);
                }
            } else if (parts[0].equalsIgnoreCase("quit")) {
                System.out.println("Total gain: $" + totalGain);
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }
}

