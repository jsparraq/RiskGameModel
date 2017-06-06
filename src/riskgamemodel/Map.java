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
     *  This method is the constructor of Map class
     * @param name
     * @param continents
     * @param cards
     * @param boundary 
     */
    public Map(){
        
    }
    
    public Map(String name,Continent[] continents, Card[] cards, Boundary boundary){
        Name = name;
        Continents = continents;
        Cards = cards;
        Boundary = boundary;
    }
    
    /**
     * This method gets the boundary of the map
     * @return The boundary of the map
     */
    public Boundary getboundary(){
        return Boundary;
    }
    
    public void setboundary(Boundary aa){
        Boundary = aa;
    }
    /**
     * This method sets the name of the map
     * @param value 
     */
    public void setName(String value){
        Name = value;
    }
    
    /**
     * This method gets the name of the map
     * @return The name of the map 
     */
    public String getName(){
        return Name;
    }
    
    /**
     * This method gets the continents of the map
     * @return 
     */
    public Continent[] getContinents(){
        return Continents;
    }
    
    public void setContinents(Continent[] a){
        Continents = a;
    }
    /**
     * This method gets the cards of the map
     * @return 
     */
    public Card[] getCards(){
        return Cards;
    }
    
    public void setCards(Card[] aa){
        Cards = aa;
    }
    
}
