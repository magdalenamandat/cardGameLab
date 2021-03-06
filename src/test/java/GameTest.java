import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Player player1;
    Player player2;
    Deck deck;
    Card card1;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void Before() {
        game = new Game("Eliminator");
        player1 = new Player("Magda");
        player2 = new Player("Gary");
        deck = new Deck();
        card1 = new Card(SuitType.CLUBS, RankType.QUEEN);
        card2 = new Card(SuitType.HEARTS, RankType.FIVE);
        card3 = new Card(SuitType.SPADES, RankType.FIVE);
        card4 = new Card(SuitType.CLUBS, RankType.FOUR);
    }

    @Test
    public void hasName() {
        assertEquals("Eliminator", game.getName());
    }

    @Test
    public void canCreateDeck(){
        game.createDeck(deck);
        assertEquals(52, deck.cardCount() );
    }

    @Test
    public void canDealCards() {
       game.createDeck(deck);
       game.deal(deck, player1, player2);
       assertEquals(48, deck.cardCount());
       assertEquals(2, player1.countHand());
       assertEquals(2, player2.countHand());
    }

    @Test
    public void canCheckPlayersCardsRank() {
        player1.addCardToHand(card2);
        assertEquals(5, player1.getCardRank());
    }

//    @Test
//    public void checkWinnerPlayer1Wins() {
//        player1.addCardToHand(card1);
//        player2.addCardToHand(card2);
//        Player winner = game.checkWinner(player1, player2);
//        assertEquals(player1, winner);
//    }
//
//    @Test
//    public void checkWinnerPlayer2Wins() {
//        player1.addCardToHand(card2);
//        player2.addCardToHand(card1);
//        Player winner = game.checkWinner(player1, player2);
//        assertEquals(player2, winner);
//    }
//
//    @Test
//    public void checkForDraw() {
//        player1.addCardToHand(card2);
//        player2.addCardToHand(card3);
//        Player winner = game.checkWinner(player1, player2);
//        assertEquals(null, winner);
//    }

    @Test
    public void checkWinnerPlayer1Wins() {
        player1.addCardToHand(card1);
        player2.addCardToHand(card2);
        player1.addCardToHand(card3);
        player2.addCardToHand(card4);
        Player winner = game.checkWinner(player1, player2);
        assertEquals(player1, winner);
    }

    @Test
    public void checkWinnerPlayer2Wins() {
        player1.addCardToHand(card2);
        player2.addCardToHand(card1);
        player1.addCardToHand(card3);
        player2.addCardToHand(card4);
        Player winner = game.checkWinner(player1, player2);
        assertEquals(player2, winner);
    }

    @Test
    public void checkForDraw() {
        player1.addCardToHand(card1);
        player2.addCardToHand(card1);
        player1.addCardToHand(card1);
        player2.addCardToHand(card1);
        Player winner = game.checkWinner(player1, player2);
        assertEquals(null, winner);
    }
}
