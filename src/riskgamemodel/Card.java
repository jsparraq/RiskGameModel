/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;

/**
 * @author UNC_ RiskGameModel
 */
public class Card {
        private String Type;
        private int ID;
        private String Owner;
        private String Design;
        private Territory Territory;
        
        public Card(){
            
        }
        
        /**
         * 
         * @param type
         * @param id
         * @param owner
         * @param design
         * @param territory 
         */
        public Card(String type, int id, String owner, String design,Territory territory){
            Type = type;
            ID = id;
            Owner = owner;
            Design = design;
            Territory = territory;
        }
        
        /**
         * 
         * @param value 
         */
        public void setType(String value){
            this.Type = value;
        }
        
        /**
         * 
         * @return 
         */
        public String getType(){
            return Type;
        }
        
        /**
         * 
         * @param value 
         */
        public void setID(int value){
            this.ID = value;
        }
        
        /**
         * 
         * @return 
         */
        public int getID(){
            return ID;
        }
        
        /**
         * 
         * @param value 
         */
        public void setOwner(String value){
            this.Owner = value;
        }
        
        /**
         * 
         * @return 
         */
        public String getOwner(){
            return Owner;
        }
        
        /**
         * 
         * @param value 
         */
        public void setDesign(String value){
            this.Design = value;
        }
        
        /**
         * 
         * @return 
         */
        public String getDesign(){
            return Design;
        }
        
        /**
         * 
         * @param player
         * @param card1
         * @param card2
         * @param card3
         * @return 
         */
        public static boolean Trades(Player player,Card card1,Card card2,Card card3){
           Card[] CARDS_TRADES = new Card[3];
           CARDS_TRADES[0] = card1;
           CARDS_TRADES[1] = card2;
           CARDS_TRADES[2] = card3;
           if (CARDS_TRADES[0] == CARDS_TRADES[1] || CARDS_TRADES[0] == CARDS_TRADES[2]){
               return false;
           }else if (card2 == card3){
               return false;
           }else if(CARDS_TRADES[0].getOwner() == null || CARDS_TRADES[1].getOwner() == null || CARDS_TRADES[2].getOwner() == null){
               return false;
           }
           card1.setOwner("WHITE");
           card2.setOwner("WHITE");
           card3.setOwner("WHITE");
           player.setCardAmount(player.getCardAmount() - 3);
           player.setArmy(player.getArmy() + 10);
           return true;
        }
        
        /**
         * 
         * @return 
         */
        public String getString(){            
            return this.Type + "-" + this.Design + "-" + this.Territory.getName();
        }
}
