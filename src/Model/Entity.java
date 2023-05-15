package Model;

public class Entity {

    Battleship Ship;
    boolean isOccupied;

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Entity(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Entity() {
    }

    //Provides simple GUI for testing the backend algorythms
    @Override
    public String toString() {

        if (this.isOccupied) {
            return "X";
        } else {
            
            return "O";
        }
    }

}
