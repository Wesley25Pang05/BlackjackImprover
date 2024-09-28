import java.util.ArrayList;

public class Player {

    ArrayList<String> cards;
    int amount;

    public Player() {
        cards = new ArrayList<String>();
        amount = 0;
    }

    public void addCard(String card) {
        cards.add(card);
        countAmount();
    }

    public void countAmount() {
        int ace = 0;
        amount = 0;
        for (String card : cards) {
            card = card.substring(0, card.indexOf(" "));
            if (card.length() == 1) {
                amount += Integer.parseInt(card);
            }
            else if (card.equals("Ace")) {
                ace++;
            }
            else {
                amount += 10;
            }
        }
        while (ace > 0) {
            if (amount > 10) {
                amount += 1;
            }
            else {
                amount += 11;
            }
            ace--;
        }
    }

    public String toString() {
        return cards.toString() + " " + amount;
    }
}
