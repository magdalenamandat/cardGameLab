public class Game {

    private String name;

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void createDeck(Deck deck) {
        for (SuitType suit : SuitType.values()){

            for (RankType rank : RankType.values()) {

                Card card = new Card(suit, rank);
                deck.addCard(card);
            }
        }
    }

    public void deal(Deck deck, Player player1, Player player2) {
        deck.shuffleCards();
        Card card1 = deck.removeCard();
        Card card2 = deck.removeCard();
        Card card3 = deck.removeCard();
        Card card4 = deck.removeCard();
        player1.addCardToHand(card1);
        player2.addCardToHand(card2);
        player1.addCardToHand(card3);
        player2.addCardToHand(card4);
    }

    public Player checkWinner(Player player1, Player player2) {
        int value1 = player1.totalHandValue();
        int value2 = player2.totalHandValue();
        if (value1 == value2) return null;
        if (value1 > value2) {
            return player1;
        }
        else {
            return player2;
        }
    }

}
