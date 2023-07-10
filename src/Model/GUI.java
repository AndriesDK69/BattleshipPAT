
package Model;

import Controller.GameController;
import javax.swing.JOptionPane;

public class GUI {

    
    public static void main(String[] args) {
      
      GameController x = new GameController();
      x.createBoard(true);
      x.createBoard(false);
//      x.placeShip2(1, 3, true, 3, false, true);
//      x.outputBoard(true);
//     System.out.println("\n");
//      x.placeShip2(1, 3, true, 3, true, false);
//      x.outputBoard(false);
//      x.checkIsOccupied(1, 3, 4);
      
//
//     x.placeShip2(7, 7, true, 3, false);
//     x.outputBoard();
//    
      
      boolean isActiveGame = true;
      boolean isPlayer1 = true;
      int countP1 = 0;
      int countP2 = 0;
      
        while (isActiveGame) {            
            
            if (isPlayer1) {
                if (countP1 < 2) {

                x.placeShip2(Integer.parseInt(JOptionPane.showInputDialog("Ship x coordinate?")), Integer.parseInt(JOptionPane.showInputDialog("Ship y coordinate?")), true, countP1, Boolean.parseBoolean(JOptionPane.showInputDialog("Hor?")), isPlayer1);
                System.out.println("Player 1:\n");
                x.outputBoard(isPlayer1);
                countP1++;
                isPlayer1 = false;
                }
                
                //P1 attacking P2 (displays P2's board)
//                System.out.println("P2\n");
//                x.destroyShip(Integer.parseInt(JOptionPane.showInputDialog("Destroy x coordinate?")), Integer.parseInt(JOptionPane.showInputDialog("Destroy y coordinate?")), !isPlayer1);
//                x.outputBoard(!isPlayer1);
                
            } else {
                if (countP2 < 2) {

                x.placeShip2(Integer.parseInt(JOptionPane.showInputDialog("Ship x coordinate?")), Integer.parseInt(JOptionPane.showInputDialog("Ship y coordinate?")), true, countP2, Boolean.parseBoolean(JOptionPane.showInputDialog("Hor?")), isPlayer1);
                    System.out.println("Player 2:\n");
                x.outputBoard(isPlayer1);
                countP2++;
                isPlayer1 = true;
                }
            }
            
        }
      
    }
    
}
