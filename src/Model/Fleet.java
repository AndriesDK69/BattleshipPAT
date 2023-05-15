package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fleet {

    private Battleship[] fleet = new Battleship[5];

    public Battleship[] getFleet() {
        return fleet;
    }
    
    //Extracts data of battleships from the text file "Ships" and stores it in an array of objects battleship
    public Fleet() {

        try {

            File myFile = new File("/Users/andriesdekock/Desktop/BattleshipPAT/src/Ships");
            Scanner ScFile = new Scanner(myFile);
            int count = 0;

            while (ScFile.hasNextLine()) {
                String line = ScFile.nextLine();
                Scanner ScLine = new Scanner(line).useDelimiter("#");

                String shipName = ScLine.next();
                int shipSize = ScLine.nextInt();

                fleet[count] = new Battleship(shipName, shipSize);
                count++;

            }

        } catch (FileNotFoundException e) {
            System.out.println("Error " + e);

        }
    }

}
