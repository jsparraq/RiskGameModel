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
        
        public void setType(String type_new){
            this.Type = type_new;
        }
        public String getType(){
            return Type;
        }
        public void setID(int id_new){
            this.ID = id_new;
        }
        public int getID(){
            return ID;
        }
        public void setOwner(String owner_new){
            this.Owner = owner_new;
        }
        public String getOwner(){
            return Owner;
        }
        public void setDesign(String design_new){
            this.Design = design_new;
        }
        public String getDesign(){
            return Design;
        }
}
