import java.util.*;

class Block {
    int quantity;
    double price;

    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}

public class Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Queue<Block>> stockData = new HashMap<>();
        Map<String, Double> totalGains = new HashMap<>();

        System.out.println("Enter commands (buy symbol quantity price, sell symbol quantity price, quit):");

        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equalsIgnoreCase("buy")) {
                String symbol = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                double price = Double.parseDouble(parts[3]);

                stockData.putIfAbsent(symbol, new LinkedList<>());
                stockData.get(symbol).add(new Block(quantity, price));

                System.out.println("Bought " + quantity + " shares of " + symbol + " at $" + price + " each.");

            } else if (parts[0].equalsIgnoreCase("sell")) {
                String symbol = parts[1];
                int quantityToSell = Integer.parseInt(parts[2]);
                double sellPrice = Double.parseDouble(parts[3]);

                if (!stockData.containsKey(symbol) || stockData.get(symbol).isEmpty()) {
                    System.out.println("No shares of " + symbol + " available to sell!");
                    continue;
                }

                Queue<Block> queue = stockData.get(symbol);
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
                    System.out.println("Not enough shares of " + symbol + " to sell!");
                } else {
                    totalGains.put(symbol, totalGains.getOrDefault(symbol, 0.0) + gain);
                    System.out.println("Sold shares of " + symbol + " for a gain of $" + gain);
                }

            } else if (parts[0].equalsIgnoreCase("quit")) {
                System.out.println("Total gains:");
                for (String symbol : totalGains.keySet()) {
                    System.out.println(symbol + ": $" + totalGains.get(symbol));
                }
                break;

            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }
}
