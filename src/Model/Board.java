package Model;

import javax.swing.JOptionPane;

public class Board {

    private int boardSize = 10;
    Entity[][] EntityArr = new Entity[boardSize][boardSize];

    //Creates a base board when program is initialized
    public Board() {

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                EntityArr[i][j] = new Entity(false);

            }
        }

    }

    //Overrides the base board so that it can output updated boards with ships on it
    public void outputBoard() {

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                System.out.print(EntityArr[i][j].toString() + " ");
            }
            System.out.println("");
        }

    }

    //Modular Method to update singular coordinates on the board (Can be used in placing and destroying ships)
    public void updateBoard(int x, int y, boolean isOpen) {
        //If statement is used to check if coordinate is in bounds
        if (x >= 1 && x <= 10 && y >= 1 && y <= 10) {
            EntityArr[y - 1][x - 1].setIsOccupied(true);
        } else {
            System.out.println("The coordinates entered is invalid");
        }

    }

    //method to place ships of different sizes from the fleet on the board
    public void placeOrDestroyShip(int x, int y, boolean isOpen, int pickShip) {

        Fleet ships = new Fleet();
        Battleship[] ship = ships.getFleet();

        if (pickShip == 0 && x >= 1 && x <= 9 && y >= 1 && y <= 10) {
            System.out.println(ship[0].toString());
            updateBoard(x, y, isOpen);
            updateBoard(x + 1, y, isOpen);
        } else {
            System.out.println("The coordinates entered is invalid");
        }
        if (pickShip == 1 && x >= 1 && x <= 8 && y >= 1 && y <= 10) {
            System.out.println(ship[1].toString());
            updateBoard(x, y, isOpen);
            updateBoard(x + 1, y, isOpen);
            updateBoard(x+ 2, y, isOpen);
        } else {
            System.out.println("The coordinates entered is invalid");
        }
        if (pickShip == 2 && x >= 1 && x <= 8 && y >= 1 && y <= 10) {
            System.out.println(ship[2].toString());
            updateBoard(x, y, isOpen);
            updateBoard(x + 1, y, isOpen);
            updateBoard(x+ 2, y, isOpen);
        } else {
            System.out.println("The coordinates entered is invalid");
        }
        if (pickShip == 3 && x >= 1 && x <= 7 && y >= 1 && y <= 10) {
            updateBoard(x, y, isOpen);
            updateBoard(x + 1, y, isOpen);
            updateBoard(x+ 2, y, isOpen);
            updateBoard(x + 3, y, isOpen);
        } else {
            System.out.println("The coordinates entered is invalid");
        }
                if (pickShip == 4 && x >= 1 && x <= 6 && y >= 1 && y <= 10) {
                    System.out.println(ship[4].toString());
            updateBoard(x, y, isOpen);
            updateBoard(x + 1, y, isOpen);
            updateBoard(x+ 2, y, isOpen);
            updateBoard(x + 3, y, isOpen);
            updateBoard(x + 4, y, isOpen);
        } else {
            System.out.println("The coordinates entered is invalid");
        }
    
    }

}
