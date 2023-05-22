import java.util.ArrayList;

public class Poker {
    private PlayingCards deck;
    ArrayList<String> hand1 = new ArrayList<String>();
    ArrayList<String> hand2 = new ArrayList<String>();

    public void dealHands() {
        for (int i = 0; i < 5; i++) {
            hand1.add(deck.getNextCard());
            hand2.add(deck.getNextCard());
        }
    }

    public Poker() {
        deck = new PlayingCards();
        deck.Shuffle();
        dealHands();
    }

    public Poker(ArrayList<String> h1, ArrayList<String> h2) {
        deck = new PlayingCards();
        hand1 = h1;
        hand2 = h2;
    }

    public void showHand(int i) {
        if (i == 1) {
            System.out.println("Player 1's hand: \n" + hand1);
        }
        if (i == 2) {
            System.out.println("Player 2's hand: \n" + hand2);
        }
    }

    public int[] countSuite(ArrayList<String> h) {
        int[] suite = new int[4];
        for (int i = 0; i < h.size(); i++) {
            String card = h.get(i);
            if (card.contains("Clubs")) {
                suite[0]++;
            }
            if (card.contains("Diamonds")) {
                suite[1]++;
            }
            if (card.contains("Hearts")) {
                suite[2]++;
            }
            if (card.contains("Spades")) {
                suite[3]++;
            }
        }
        return suite;
    }

    public int[] countValues(ArrayList<String> h) {
        int[] values = new int[14];
        for (int i = 0; i < h.size(); i++) {
            String card = h.get(i);
            if (card.contains("A")) {
                values[0]++;
            }
            if (card.contains("2")) {
                values[1]++;
            }
            if (card.contains("3")) {
                values[2]++;
            }
            if (card.contains("4")) {
                values[3]++;
            }
            if (card.contains("5")) {
                values[4]++;
            }
            if (card.contains("6")) {
                values[5]++;
            }
            if (card.contains("7")) {
                values[6]++;
            }
            if (card.contains("8")) {
                values[7]++;
            }
            if (card.contains("9")) {
                values[8]++;
            }
            if (card.contains("10")) {
                values[9]++;
            }
            if (card.contains("J")) {
                values[10]++;
            }
            if (card.contains("Q")) {
                values[11]++;
            }
            if (card.contains("K")) {
                values[12]++;
            }
        }

        return values;
    }

    public int numPairs(int[] hand) {
        int pairs = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == 2) {
                pairs++;
            }
        }
        return pairs;
    }

    public int threeOfAKind(int[] hand) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == 3) {
                return hand[i];
            }
        }
        return 0;
    }

    public int fourOfAKind(int[] hand) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == 4) {
                return hand[i];
            }
        }
        return 0;
    }

    public boolean fullHouse(int[] hand) {
        if (threeOfAKind(hand) != 0 && numPairs(hand) == 1) {
            return true;
        }
        return false;
    }

    public boolean straight(int[] hand) {
        for(int i=0 ; i<hand.length; i++)
        {
            if(hand[i]==1 && hand[i+1]==1 && hand[i+2]==1 && hand[i+3]==1 && hand[i+4]==1)
            {
                return true;
            }
        }
        if(hand[0]==1 && hand[9]==1 && hand[10]==1 && hand[11]==1 && hand[12]==1)
        {
            return true;
        }
        return false;
    }

    public boolean flush(int[] hand) {
        for(int i = 0; i < 4; i++)
        {
            if(hand[i]==5) {
                return true;
            }
        }
        return false;
    }

    public boolean straightFlush(int[] hand, int[] suite) {

        if (straight(hand) == true && flush(suite) == true) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean royalFlush(int[] hand, int[] suite) {
        boolean temp = false;
        if(flush(suite) && hand[0]==1 && hand[9]==1 && hand[10]==1 && hand[11]==1 && hand[12]==1)
        {
            temp = true;
        }
        return temp;
    }

    public String scoreHand(int i) {
        String score = "";
        int[] suite = new int[4];
        int[] hand = new int[14];
        if (i == 1) {
            hand = countValues(hand1);
            suite = countSuite(hand1);
        }
        if (i == 2) {
            hand = countValues(hand2);
            suite = countSuite(hand2);
        }
        if (royalFlush(hand, suite)) {
            score = "Royal Flush";
        }
        else if(straightFlush(hand, suite))
        {
            score = "Straight Flush";
        }
        else if(fourOfAKind(hand) != 0)
        {
            score = "4 of a kind";
        }
        else if(fullHouse(hand))
        {
            score = "Full House";
        }
        else if(flush(suite))
        {
            score = "Flush";
        }
        else if(straight(hand))
        {
            score = "Straight";
        }
        else if(threeOfAKind(hand) != 0)
        {
            score = "3 of a Kind";
        }
        else if(numPairs(hand) == 2)
        {
            score = "2 pairs";
        }
        else if(numPairs(hand) == 1)
        {
            score = "1 pair";
        }
        else
        {
            score = "High Card";
        }

        return score;
    }
}
