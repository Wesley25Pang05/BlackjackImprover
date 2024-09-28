import java.util.Random;

public class Deck {

    String[] deck;
    Random random;

    public Deck() {
        random = new Random();
        deck = new String[52];
        for (int i = 0; i < 52; i++) {
            switch (i / 4) {
                case 0:
                    deck[i] = "Ace of ";
                    break;
                case 10:
                    deck[i] = "Jack of ";
                    break;
                case 11:
                    deck[i] = "Queen of ";
                    break;
                case 12:
                    deck[i] = "King of ";
                    break;
                default:
                    deck[i] = (i/4) + " of ";
                    break;
            }
            switch (i % 4) {
                case 0:
                    deck[i] += "Clubs";
                    break;
                case 1:
                    deck[i] += "Hearts";
                    break;
                case 2:
                    deck[i] += "Diamonds";
                    break;
                case 3:
                    deck[i] += "Spades";
                    break;
            }
        }
    }

    public String pickCard() {
        int card = random.nextInt(51);
        while (deck[card].isEmpty()) {
            card = random.nextInt(51);
        }
        String chosenCard = deck[card];
        deck[card] = "";
        return chosenCard;
    }

    public void printDeck() {
        for (String s : deck) {
            System.out.println(s);
        }
    }
}
