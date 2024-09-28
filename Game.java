public class Game {

    Deck deck;
    Player[] players;
    Player dealer;

    public Game(int players) {
        this.players = new Player[players];
        this.deck = new Deck();
        dealer = new Player();
        drawAllCards(true);
    }

    public void drawAllCards(boolean createNewPlayers) {
        dealer.addCard(deck.pickCard());
        if (createNewPlayers) {
            for (int i = 0; i < players.length; i++) {
                players[i] = new Player();
                players[i].addCard(deck.pickCard());
            }
            drawAllCards(false);
        }
        else {
            for (Player player : players) {
                player.addCard(deck.pickCard());
            }
        }
    }

    public String toString() {
        StringBuilder table = new StringBuilder("Dealer: " + dealer.toString());
        for (int i = 0; i < players.length; i++) {
            table.append("\nPlayer ").append(i+1).append(": ").append(players[i].toString());
        }
        return table.toString();
    }
}
