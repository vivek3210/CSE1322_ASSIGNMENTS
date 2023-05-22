import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    public static Lot getNextLot(ArrayList<Lot> lots) {
        if (lots.size() > 0) {
            Lot lot = lots.get(0);
            lots.remove(lot);
            return lot;
        }
        else {
            return new Lot();
        }
    }
    public void addItem(ArrayList<Lot> lots) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the description of this item");
        String description = sc.nextLine();
        System.out.println("What is the starting bid");
        int startingBid = sc.nextInt();
        System.out.println("What is the bid increment");
        int bidIncrement = sc.nextInt();
        Lot lot = new Lot(description, startingBid, bidIncrement);
        lots.add(lot);
    }
    public static void bid(Lot lot) {
        Scanner input = new Scanner(System.in);
        System.out.println("How much would you like to bid?\n" + "Minimum bid is " + lot.nextBid());
        int newBid = input.nextInt();
        if (newBid < lot.nextBid()) {
            System.out.println("You must bid at least " + lot.nextBid());
        }
        else lot.set_currentBid(newBid);
    }
    public static void markSold(Lot lots) {
        lots.markSold();
        System.out.println(lots);
    }

    public Lot mainMenu(ArrayList<Lot> lots) {
        Scanner scan = new Scanner(System.in);
        Lot currentLot = null;
        int choice;
        do {
            if(currentLot != null && !currentLot.get_description().equals("Unknown Item")) {
                System.out.println("Current Lot:\n" +
                        currentLot + "\n");
            }
            else {
                System.out.println("We are not currently bidding");
            }
            System.out.println("1. Add Lot to Auction");
            System.out.println("2. Start bidding on next Lot");
            System.out.println("3. Bid on current Lot");
            System.out.println("4. Mark current Lot sold");
            System.out.println("5. Quit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    addItem(lots);
                    break;
                case 2:
                    if (lots.size() == 0) {
                        System.out.println("There is nothing to bid on, add an item first");
                    }

                    else if (currentLot != null && !currentLot.get_sold()) {
                        System.out.println("You must mark the current lot as sold before bringing up the next Lot");
                    } else {
                        currentLot = getNextLot(lots);
                        System.out.println(currentLot.toString());
                    }
                    break;
                case 3:
                    if (currentLot == null || currentLot.get_description().equals("Unknown Item") || currentLot.get_sold()) {
                        System.out.println("You must first bring a Lot up for bidding");
                    } else {
                        bid(currentLot);
                    }
                    break;
                case 4:
                    if (currentLot == null || currentLot.get_description().equals("Unknown Item") || currentLot.get_sold()) {
                        System.out.println("You must first bring a Lot up for bidding");
                    } else if (lots.size() > 0) {
                        markSold(currentLot);
                    }
                    break;
                case 5:
                    choice = 5;
                    break;
                default:
                    System.out.println("Invalid input! Please try again!");
                    break;
            }
        } while (choice != 5);
        return null;
    }
    public static void main(String[] args) {
        ArrayList<Lot> auction = new ArrayList<Lot>();
        Driver main = new Driver();
        main.mainMenu(auction);
    }
}
