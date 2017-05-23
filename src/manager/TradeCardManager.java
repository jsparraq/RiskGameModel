/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import View.Place_army_Interface;
import java.util.ArrayList;
import javax.swing.JFrame;
import riskgamemodel.*;

/**
 *
 * @author user
 */
public class TradeCardManager {
    
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
            if (card.getOwner().equals(playerstart.getColor())) {
                cards_player.add(card);
            }
        }
        String[] card_string = new String[cards_player.size()];
        for (int i = 0; i < cards_player.size(); i++) {
            card_string[i] = cards_player.get(i).getString();
        }
        return card_string;
    }
    
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
            while(!Card.Trades(playerstart, card1, card2, card3)){
                
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
}
