package Controller;

import Model.Battleship;
import Model.Entity;
import Model.Fleet;

public class GameController {

    private int boardSize = 10;
    Entity[][] EntityArrPlayer1 = new Entity[boardSize][boardSize];
    Entity[][] EntityArrPlayer2 = new Entity[boardSize][boardSize];
    
    //Creates a base board when program is initialized
    public void createBoard(boolean isPlayer1) {

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if (isPlayer1) {
                    EntityArrPlayer1[i][j] = new Entity(false);
                } else {
                    
                   EntityArrPlayer2[i][j] = new Entity(false);

                }
                   
                

            }
        }

    }

    //Overrides the base board so that it can output updated boards with ships on it
    public void outputBoard(boolean isPlayer1) {

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                if (isPlayer1) {
                    System.out.print(EntityArrPlayer1[i][j].toString() + " ");
                } else {
                    
                    System.out.print(EntityArrPlayer2[i][j].toString() + " ");
                }
                
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    //Modular Method to update singular coordinates on the board (Can be used in placing and destroying ships)
    public void updateBoard(int x, int y, boolean isOpen, boolean isPlayer1) {
        //If statement is used to check if coordinate is in bounds
        if (x >= 1 && x <= 10 && y >= 1 && y <= 10) {
            if (isPlayer1) {
                
            
            EntityArrPlayer1[y - 1][x - 1].setIsOccupied(isOpen);
            } else {
            EntityArrPlayer2[y - 1][x - 1].setIsOccupied(isOpen);
            }
        } else {
            System.out.println("The coordinates entered is invalid");
        }

    }

//    //method to place ships of different sizes from the fleet on the board
//    public void placeShip(int x, int y, boolean isOpen, int pickShip, boolean isHorisontal) {
//
//        Fleet ships = new Fleet();
//        Battleship[] ship = ships.getFleet();
//
//        for (int i = 0; i < ship[pickShip].getShipSize() - 1; i++) {
//
//            if (isHorisontal && !(EntityArr[x][y].getIsOccupied())) {
//
//                if (pickShip == 0 && x >= 1 && x <= 9 && y >= 1 && y <= 10) {
//                    System.out.println(ship[0].toString());
//                    updateBoard(x, y, isOpen);
//                    updateBoard(x + 1, y, isOpen);
//                }
//                if (pickShip == 1 && x >= 1 && x <= 8 && y >= 1 && y <= 10) {
//                    System.out.println(ship[1].toString());
//                    updateBoard(x, y, isOpen);
//                    updateBoard(x + 1, y, isOpen);
//                    updateBoard(x + 2, y, isOpen);
//                }
//                if (pickShip == 2 && x >= 1 && x <= 8 && y >= 1 && y <= 10) {
//                    System.out.println(ship[2].toString());
//                    updateBoard(x, y, isOpen);
//                    updateBoard(x + 1, y, isOpen);
//                    updateBoard(x + 2, y, isOpen);
//                }
//                if (pickShip == 3 && x >= 1 && x <= 7 && y >= 1 && y <= 10) {
//                    updateBoard(x, y, isOpen);
//                    updateBoard(x + 1, y, isOpen);
//                    updateBoard(x + 2, y, isOpen);
//                    updateBoard(x + 3, y, isOpen);
//                }
//                if (pickShip == 4 && x >= 1 && x <= 6 && y >= 1 && y <= 10) {
//                    System.out.println(ship[4].toString());
//                    updateBoard(x, y, isOpen);
//                    updateBoard(x + 1, y, isOpen);
//                    updateBoard(x + 2, y, isOpen);
//                    updateBoard(x + 3, y, isOpen);
//                    updateBoard(x + 4, y, isOpen);
//                }
//            }
//        }
//
//    }

//    public void checkIsOccupied(int x, int y, int ship) {
//
//        ship = 4;
//
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < 4; j++) {
//                if (EntityArr[x + j][y].getIsOccupied()) {
//
//                    System.out.println("Occupied" + j);
//
//                } else {
//                    System.out.println("Not Occ");
//                }
//            }
//
//        }
//
//    }

    public void placeShip2(int x, int y, boolean isOpen, int pickShip, boolean isHorisontal, boolean isPlayer1) {

        Fleet ships = new Fleet();
        Battleship[] ship = ships.getFleet();

        if (isHorisontal) {
            
            for (int i = 0; i < ship[pickShip].getShipSize(); i++) {
                if (EntityArrPlayer1[x+i][y].getIsOccupied()) {
                    //add error msg
                    System.out.println("jwvjwbvwbdvwbv");
                    return;
                }
            }
            

            for (int j = 0; j < ship[pickShip].getShipSize(); j++) {
                if (x + ship[pickShip].getShipSize() <= 11 && x > 0) {
                    
                
                
                    updateBoard(x + j, y, isOpen, isPlayer1);
                }
            }

        } else {
            
            for (int j = 0; j < ship[pickShip].getShipSize(); j++) {
                if (y + ship[pickShip].getShipSize() <= 11 && y > 0) {
                    
                
                updateBoard(x, y + j, isOpen, isPlayer1);
                }
        }
    }
    
    }
    
    public void destroyShip(int x, int y, boolean isPlayer1) {
        
        if (isPlayer1) {
            
            if (EntityArrPlayer2[x][y].getIsOccupied()) {
                
                System.out.println("You have hit a ship at (" + x + "," + y + ")\n");
                updateBoard(x, y, false, !isPlayer1);
            }
            
            
        } else {
            
            if (EntityArrPlayer1[x][y].getIsOccupied()) {
                
                System.out.println("You have hit a ship at (" + x + "," + y + ")\n");
                updateBoard(x, y, false, isPlayer1);
            }
            
        }
        
    }
}
