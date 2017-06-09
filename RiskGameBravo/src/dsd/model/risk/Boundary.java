package dsd.model.risk;

import java.util.ArrayList;


/**
 * @author UNC_RiskGameModel
 */
public class Boundary {

    private int ID;
    private final Territory[] Territories ;
    private final Territory[] Neighbours ;
    
    
    public Boundary(int id, Territory[] terr, Territory[] neig){
        ID = id;
        Territories = terr;
        Neighbours = neig;
    }
    
    
    /**
     * This method is the constructor of Boundary class.
     * @param id
     */
    public Boundary(int id,ArrayList<Territory> territories){
        String[] terr = new String[]{"OEKRAINË","OEKRAINË","OEKRAINË","OEKRAINË","IJSLAND","IJSLAND","SCANDINAVIË","SCANDINAVIË","SCANDINAVIË","SCANDINAVIË","SCANDINAVIË","WEST-EUROPA","WEST-EUROPA","WEST-EUROPA","WEST-EUROPA","WEST-EUROPA","GROOT-BRITTANIË","GROOT-BRITTANIË","GROOT-BRITTANIË","GROOT-BRITTANIË","GROOT-BRITTANIË","GROOT-BRITTANIË","ZUID-EUROPA","ZUID-EUROPA","ZUID-EUROPA","NOORD-EUROPA","NOORD-EUROPA","NOORD-EUROPA","VARENIGDE-STATEM(OOST)","VARENIGDE-STATEM(OOST)","VARENIGDE-STATEM(OOST)","VARENIGDE-STATEM(OOST)","VARENIGDE-STATEM(OOST)","VARENIGDE-STATEM(OOST)","VARENIGDE-STATEM(WEST)","VARENIGDE-STATEM(WEST)","VARENIGDE-STATEM(WEST)","VARENIGDE-STATEM(WEST)","VARENIGDE-STATEM(WEST)","VARENIGDE-STATEM(WEST)","VARENIGDE-STATEM(WEST)","NORTHWEST-TERRITORIES","NORTHWEST-TERRITORIES","ALBERTA","ALBERTA","ALBERTA","ALBERTA","ALBERTA","MIDDEN-AMERIKA","MIDDEN-AMERIKA","MIDDEN-AMERIKA","MIDDEN-AMERIKA","MIDDEN-AMERIKA","ALASKA","ALASKA","ALASKA","ALASKA","ONTARIO","ONTARIO","ONTARIO","ONTARIO","QUEBEC","QUEBEC","QUEBEC","QUEBEC","GROENLAND","GROENLAND","SIBERIË","SIBERIË","SIBERIË","IRKOETSK","IRKOETSK","IRKOETSK","IRKOETSK","INDIA","INDIA","INDIA","JAPON","JAPON","JAKOETSK","JAKOETSK","JAKOETSK","JAKOETSK","MONGOLOË","MONGOLOË","MONGOLOË","MONGOLOË","CHINA","CHINA","CHINA","CHINA","CHINA","MIDDEN-OOSTEN","MIDDEN-OOSTEN","MIDDEN-OOSTEN","MIDDEN-OOSTEN","ZEIDOOST-AZIË","ZEIDOOST-AZIË","ZEIDOOST-AZIË","KAMTAJARKA","KAMTAJARKA","KAMTAJARKA","KAMTAJARKA","KAMTAJARKA","AFGHANISTAN","AFGHANISTAN","NIEUW-GUINEA","NIEUW-GUINEA","INDONESIË","INDONESIË","INDONESIË","INDONESIË","WEST-AUSTRALIË","WEST-AUSTRALIË","WEST-AUSTRALIË","OOST-AUSTRALIË","OOST-AUSTRALIË","ZUID-AFRIKA","ZUID-AFRIKA","ZUID-AFRIKA","CENTRAAL-AFRIKA","CENTRAAL-AFRIKA","CENTRAAL-AFRIKA","OOST-AFRIKA","OOST-AFRIKA","OOST-AFRIKA","NOORD-AFRIKA","NOORD-AFRIKA","NOORD-AFRIKA","EGYPTE","EGYPTE","EGYPTE","MADAGASCAR","MADAGASCAR","BRASILIË","BRASILIË","BRASILIË","PERU","PERU","VENEZUELA","VENEZUELA","VENEZUELA","ARGENTINË","ARGENTINË","OERAL","OERAL"};
        String[] neigh = new String[]{"IJSLAND","SCANDINAVIË","WEST-EUROPA","MADAGASCAR","OEKRAINË","SCANDINAVIË","OEKRAINË","IJSLAND","WEST-EUROPA","GROOT-BRITTANIË","VARENIGDE-STATEM(WEST)","OEKRAINË","SCANDINAVIË","GROOT-BRITTANIË","ZUID-EUROPA","NOORD-EUROPA","SCANDINAVIË","WEST-EUROPA","ZUID-EUROPA","VARENIGDE-STATEM(OOST)","VARENIGDE-STATEM(WEST)","SIBERIË","WEST-EUROPA","GROOT-BRITTANIË","NOORD-EUROPA","WEST-EUROPA","ZUID-EUROPA","ARGENTINË","GROOT-BRITTANIË","VARENIGDE-STATEM(WEST)","ALASKA","IRKOETSK","JAKOETSK","MONGOLOË","SCANDINAVIË","GROOT-BRITTANIË","VARENIGDE-STATEM(OOST)","NORTHWEST-TERRITORIES","ALBERTA","MIDDEN-AMERIKA","ALASKA","VARENIGDE-STATEM(WEST)","ALBERTA","VARENIGDE-STATEM(WEST)","NORTHWEST-TERRITORIES","MIDDEN-AMERIKA","ONTARIO","GROENLAND","VARENIGDE-STATEM(WEST)","ALBERTA","ALASKA","ONTARIO","QUEBEC","VARENIGDE-STATEM(OOST)","VARENIGDE-STATEM(WEST)","MIDDEN-AMERIKA","QUEBEC","ALBERTA","MIDDEN-AMERIKA","QUEBEC","GROENLAND","MIDDEN-AMERIKA","ALASKA","ONTARIO","OERAL","ALBERTA","ONTARIO","GROOT-BRITTANIË","IRKOETSK","EGYPTE","VARENIGDE-STATEM(OOST)","SIBERIË","INDIA","JAKOETSK","IRKOETSK","JAPON","KAMTAJARKA","INDIA","ZUID-AFRIKA","VARENIGDE-STATEM(OOST)","IRKOETSK","MONGOLOË","MIDDEN-OOSTEN","VARENIGDE-STATEM(OOST)","JAKOETSK","CHINA","MIDDEN-OOSTEN","MONGOLOË","MIDDEN-OOSTEN","ZEIDOOST-AZIË","KAMTAJARKA","OERAL","JAKOETSK","MONGOLOË","CHINA","ZEIDOOST-AZIË","CHINA","KAMTAJARKA","AFGHANISTAN","INDIA","CHINA","MIDDEN-OOSTEN","ZEIDOOST-AZIË","AFGHANISTAN","ZEIDOOST-AZIË","KAMTAJARKA","INDONESIË","WEST-AUSTRALIË","NIEUW-GUINEA","WEST-AUSTRALIË","OOST-AUSTRALIË","ZUID-AFRIKA","NIEUW-GUINEA","INDONESIË","OOST-AUSTRALIË","INDONESIË","WEST-AUSTRALIË","JAPON","INDONESIË","CENTRAAL-AFRIKA","ZUID-AFRIKA","OOST-AFRIKA","NOORD-AFRIKA","CENTRAAL-AFRIKA","NOORD-AFRIKA","MADAGASCAR","CENTRAAL-AFRIKA","OOST-AFRIKA","EGYPTE","SIBERIË","NOORD-AFRIKA","BRASILIË","OEKRAINË","OOST-AFRIKA","EGYPTE","PERU","VENEZUELA","BRASILIË","VENEZUELA","BRASILIË","PERU","ARGENTINË","VENEZUELA","NOORD-EUROPA","CHINA","QUEBEC"};
        Territories = new Territory[terr.length];
        Neighbours = new Territory[terr.length];
        for (int i = 0; i < terr.length; i++) {
            for (int j = 0; j < territories.size(); j++) {
                if(terr[i].equals(territories.get(j).getName())){
                    Territories[i] = territories.get(j);
                }
            }
        }
        for (int i = 0; i < terr.length; i++) {
            for (int j = 0; j < territories.size(); j++) {
                if(terr[i].equals(territories.get(j).getName())){
                    Neighbours[i] = territories.get(j);
                }
            }
        }
        ID = id;
    }
    
    /**
     * This method sets the value of id of the boundary
     * @param value 
     */
    public void setID(int value) {
        this.ID = value;
    }

    /**
     * This method gets the value of ID of the boundary
     * @return The ID of the boundary
     */
    public int getID() {
        return ID;
    }
    
    /**
     * This method gets the territories of the boundary
     * @return The array territory 
     */
    public Territory[] getTerritories() {
        return this.Territories;
    }
    
    /**
     * This method gets the neighbours of the boundary
     * @return The array getNeighbours
     */
    public  Territory[] getNeighbours() {
        return this.Neighbours;
    }
}
