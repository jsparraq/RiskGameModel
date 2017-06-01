package Controller;

import View.Place_army_Interface;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import riskgamemodel.*;

/**
 *
 * @author UNC Risk Game Model
 */
public class TradeCardManager {
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static String[] cards(Session sessionstart){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
            }
        }
        ArrayList<Card> cards_player = new ArrayList();
        Card[] cards = sessionstart.getMap().getCards();
        for (Card card : cards) {
            if (card.getOwner().equals(playerstart.getColor())){
                cards_player.add(card);
            }
        }
        if (cards_player.isEmpty()){
            return new String[]{"You don't have more cards"};
        }
        String[] card_string = new String[cards_player.size()];
        for (int i = 0; i < cards_player.size(); i++) {
            card_string[i] = cards_player.get(i).getString();
        }
        return card_string;
    }
    
    /**
     * 
     * @param sessionstart
     * @param window
     * @param card1_string
     * @param card2_string
     * @param card3_string 
     */
    public static void Button_Trade(Session sessionstart, JFrame window,String card1_string,String card2_string,String card3_string){
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card[] cards = sessionstart.getMap().getCards();
        for (Card card : cards) {
            if (card.getString().equals(card1_string)) {
                card1 = card;
            } else if (card.getString().equals(card2_string)) {
                card2 = card;
            } else if (card.getString().equals(card3_string)) {
                card3 = card;
            }
        }
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
            }
        }
        ArrayList<Card> cards_player = new ArrayList();
        for (Card card : cards) {
            if (card.getOwner().equals(playerstart.getColor())) {
                cards_player.add(card);
            }
        }
        if(cards_player.size() > 6){
            while(!Card.Trades(playerstart, card1, card2, card3) && cards_player.size() > 6){
            }
            window.setVisible(false);
            new Place_army_Interface(sessionstart).setVisible(true);
        }else if(cards_player.size() < 3){
            window.setVisible(false);
            new Place_army_Interface(sessionstart).setVisible(true);
        }else{
            Card.Trades(playerstart, card1, card2, card3);
            window.setVisible(false);
            new Place_army_Interface(sessionstart).setVisible(true);
        }
    }
    
    /**
     * 
     * @param first_Card
     * @param Second_Card
     * @param Third_Card
     * @param button 
     */
    public static void diferents(String first_Card, String Second_Card,String Third_Card, JButton button){
        if(!first_Card.equals(Second_Card) && !first_Card.equals(Third_Card) && !Third_Card.equals(Second_Card)){
            button.setText("Trades cards");
        }
    }
}
