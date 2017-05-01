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
}
