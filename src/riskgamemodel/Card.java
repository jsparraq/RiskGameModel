/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;

/**
 *
 * @author Sebastian
 */
public class Card {
        private String Type;
        private int ID;
        private String Owner;
        private String Design;
        private Territory Territory;
        
        public Card(){
            
        }
        public Card(String type, int id, String owner, String design,Territory territory){
            Type = type;
            ID = id;
            Owner = owner;
            Design = design;
            Territory = territory;
        }
        
        public void setType(String value){
            this.Type = value;
        }
        public String getType(){
            return Type;
        }
        public void setID(int value){
            this.ID = value;
        }
        public int getID(){
            return ID;
        }
        public void setOwner(String value){
            this.Owner = value;
        }
        public String getOwner(){
            return Owner;
        }
        public void setDesign(String value){
            this.Design = value;
        }
        public String getDesign(){
            return Design;
        }
        public static boolean Trades(Player player,Card card1,Card card2,Card card3){
           Card[] CARDS_TRADES = new Card[3];
           CARDS_TRADES[0] = card1;
           CARDS_TRADES[1] = card2;
           CARDS_TRADES[2] = card3;
           if (CARDS_TRADES[0] == CARDS_TRADES[1] || CARDS_TRADES[0] == CARDS_TRADES[2]){
               return false;
           }else if (card2 == card3){
               return false;
           }
           card1.setOwner("WHITE");
           card2.setOwner("WHITE");
           card3.setOwner("WHITE");
           player.setCardAmount(player.getCardAmount() - 3);
           player.setArmy(player.getArmy() + 10);
           return true;
        }
        
        public String getString(){            
            return this.Type + "-" + this.Design + "-" + this.Territory.getName();
        }
}
