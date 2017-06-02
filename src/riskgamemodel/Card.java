package riskgamemodel;

/**
 * @author UNC_ RiskGameModel
 */
public class Card {
        private static int[] values = new int[]{4,6,8,10,12,15};
        private String Type;
        private String Owner;
        private String Design;
        private Territory Territory;
        
        /**
         * This method is the constructor of Card class
         */
        public Card(){
            Type = null;
            Owner = null;
            Design = null;
            Territory = null;
        }
        
        /**
         * This method is the constructor of Card class
         * @param type
         * @param owner
         * @param design
         * @param territory 
         */
        public Card(String type, String owner, String design,Territory territory){
            Type = type;
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
         * @return The type of the card
         */
        public String getType(){
            return Type;
        }
        
        /**
         * 
         * @param value 
         */
        public void setOwner(String value){
            this.Owner = value;
        }
        
        /**
         * @return The owner of the owner
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
         * @return The design of the card
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
            if(!CARDS_TRADES[0].getDesign().equals(CARDS_TRADES[1].getDesign()) && !CARDS_TRADES[0].getDesign().equals(CARDS_TRADES[2].getDesign()) && !CARDS_TRADES[2].getDesign().equals(CARDS_TRADES[1].getDesign())){
                card1.setOwner("WHITE");
                card2.setOwner("WHITE");
                card3.setOwner("WHITE");
                player.setCardAmount(player.getCardAmount() - 3);
                if (player.gettrades() > 6){
                    player.setArmy(player.getArmy() + values[5] + (player.gettrades() - 6)*5);
                    player.settrades(player.gettrades() + 1);
                }else{
                    player.setArmy(player.getArmy() + values[3]);
                    player.settrades(player.gettrades() + 1);
                }
                return true;
            }else if(CARDS_TRADES[0].getDesign().equals(CARDS_TRADES[1].getDesign()) && CARDS_TRADES[2].getDesign().equals(CARDS_TRADES[1].getDesign())){
                card1.setOwner("WHITE");
                card2.setOwner("WHITE");
                card3.setOwner("WHITE");
                player.setCardAmount(player.getCardAmount() - 3);
                if (player.gettrades() > 6){
                    player.setArmy(player.getArmy() + values[5] + (player.gettrades() - 6)*5);
                    player.settrades(player.gettrades() + 1);
                }else{
                    player.setArmy(player.getArmy() + values[player.gettrades() - 1]);
                    player.settrades(player.gettrades() + 1);
                }
                return true;
            }
            return false;
        }
        /**
         * @return 
         */
        public String getString(){            
            return this.Type + "-" + this.Design + "-" + this.Territory.getName();
        }
}
