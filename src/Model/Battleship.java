
package Model;


public class Battleship {
 
    private String ShipName;
    private int shipSize;
    

    public Battleship() {
    }
    
    public Battleship(String ShipName, int shipSize) {
        this.ShipName = ShipName;
        this.shipSize = shipSize;
    }
    
    //Will check if ships overlap
    public boolean CheckOverlaps(Battleship x) {
    
  
        return true;
    }
    
    

    @Override
    public String toString() {
        return "You have picked " + ShipName + " with a size of " + shipSize;
    }

    public int getShipSize() {
        return shipSize;
    }
        
}