package riskgamemodel;

/**
 * @author UNC Risk Game Model
 */
public class Map {
    private String Name;
    private Continent[] Continents;
    private Card[] Cards;
    private Boundary Boundary;
    
    /**
     * 
     * @param name
     * @param continents
     * @param cards
     * @param boundary 
     */
    public Map(String name,Continent[] continents, Card[] cards, Boundary boundary){
        Name = name;
        Continents = continents;
        Cards = cards;
        Boundary = boundary;
    }
    
    /**
     * @return The boundary of the map
     */
    public Boundary getboundary(){
        return Boundary;
    }
    
    /**
     * @param value 
     */
    public void setName(String value){
        Name = value;
    }
    
    /**
     * @return The name of the map 
     */
    public String getName(){
        return Name;
    }
    
    /**
     * 
     * @return 
     */
    public Continent[] getContinents(){
        return Continents;
    }
    
    /**
     * 
     * @return 
     */
    public Card[] getCards(){
        return Cards;
    }
    
}
