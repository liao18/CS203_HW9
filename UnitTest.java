import java.io.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.lang.*;

/**
 * UnitTest
 * The class that calls the constuctors and executes the main method to play the game
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */

public class UnitTest {
    public static void main(String ags[]) {
        double resources; 
        String choice;
        int input;
        int difficulty; //choice of 0-easy 1-normal 2-hard
        int survival = 0; //score of how long the player survives. Starts at 0 because of the nature of the first iteration of the loop.
        ChineseUnit[] tempChineseArmy = new ChineseUnit[10]; //temp arraylist that stores ChineseUnits sent to battle
        JapaneseUnit[] tempJapaneseArmy = new JapaneseUnit[10]; //temp arraylist that stores ChineseUnits sent to battle
        final int EASYSIZE = 70; //sizes of the Japanese army by difficulty
        final int NORMALSIZE = 150;
        final int HARDSIZE = 300;
        final double soldierCost = 11.95; //cost of a ChineseSoldier
        final double tankCost = 54.25; //cost of a ChineseTank
        int rSize; //send x number of units into the battlefield at a time
        //construct the Japanese, opposing army AND the civilians
        JapaneseUnit JapanArmy = new JapaneseUnit(0, 1); //create the SINGLE JapaneseUnit that is responsible for keeping track of the JapaneseArmy Arraylist
        ChineseUnit ChinaArmy = new ChineseUnit(0, 1); //create the SINGLE ChineseUnit that is responsible for keeping track of the ChineseArmy Arraylist
        Scanner kbrd = new Scanner(System.in); //have the Scanner object ready for user input

        System.out.println("\tWelcome to the game of \"Battle for Nanking\"\n");
        System.out.println("Type in a difficulty to begin: (easy) (normal) (hard)".toUpperCase());

        while(true) {
            choice = kbrd.next();

            if (choice.equalsIgnoreCase("easy") ) {
                resources = 1000.0;
                difficulty = 0;
                System.out.println("You have choosen EASY. Good luck.");
                System.out.println("Enter any key to continue...");
                break;
            }

            else if (choice.equalsIgnoreCase("normal") ) {
                resources = 600.0;
                difficulty = 1;
                System.out.println("You have choosen NORMAL. Good luck.");
                System.out.println("Enter any key to continue...");
                break;
            }

            else if (choice.equalsIgnoreCase("hard") ) {
                resources = 200.0;
                difficulty = 2;
                System.out.println("You have choosen HARD. May your wise counsel save Nanking!");
                System.out.println("Enter any key to continue...");
                break;
            }
            else {
                System.out.println("That is an invalid input. Try again");
            }
        }    
        kbrd.next(); //wait for user to enter any key.
        Nanking city = new Nanking(resources); //construct the city

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        switch(difficulty) { 
            case 0:
            for (int i = 0; i < EASYSIZE; i++) { //build 70 Japanese Units
                double random = Math.random();
                if(random > 0.8) //creating a Japanese Tank is rare. Only .8-.99% probability will a tank be consturted
                {
                    JapaneseTank p = new JapaneseTank(i, 100.00);
                    JapanArmy.addJapaneseArmy(p); //add those constructed tanks to the JapaneseArmy
                }
                else //all other Japanese Units will be soldiers
                {
                    JapaneseSoldier p = new JapaneseSoldier(i, 100.00);
                    JapanArmy.addJapaneseArmy(p); //add those constructed soldiers to the JapaneseArmy
                }
            }

            for (int i = 0; i < (EASYSIZE+30); i++) { //build civilian units
                civilianUnit p = new civilianUnit();
                city.addCiv(p);
            }
            break;

            case 1:
            for (int i = 0; i < NORMALSIZE; i++) { //build 150 Japanese Units
                double random = Math.random();
                if(random > 0.7) //creating a Japanese Tank is slightly rare. Only .6-.99% probability will a tank be consturted
                {
                    JapaneseTank p = new JapaneseTank(i, 100.00);
                    JapanArmy.addJapaneseArmy(p); //add those constructed tanks to the JapaneseArmy
                }
                else //all other Japanese Units will be soldiers
                {
                    JapaneseSoldier p = new JapaneseSoldier(i, 100.00);
                    JapanArmy.addJapaneseArmy(p); //add those constructed soldiers to the JapaneseArmy
                }
            }

            for (int i = 0; i < (NORMALSIZE-40); i++) { //build civilian units
                civilianUnit p = new civilianUnit();
                city.addCiv(p);
            }
            break;

            case 2:
            for (int i = 0; i < HARDSIZE; i++) { //build 300 Japanese Units
                double random = Math.random();
                if(random > 0.6) //creating a Japanese Tank is common. Only .5-.99% probability will a tank be consturted
                {
                    JapaneseTank p = new JapaneseTank(i, 100.00);
                    JapanArmy.addJapaneseArmy(p); //add those constructed tanks to the JapaneseArmy
                }
                else //all other Japanese Units will be soldiers
                {
                    JapaneseSoldier p = new JapaneseSoldier(i, 100.00);
                    JapanArmy.addJapaneseArmy(p); //add those constructed soldiers to the JapaneseArmy
                }
            }

            for (int i = 0; i < (HARDSIZE-120); i++) { //build civilian units
                civilianUnit p = new civilianUnit();
                city.addCiv(p);
            }
            break;
        }

        //print out the introductory information:
        JOptionPane.showMessageDialog(null, "The time is December 1937 and Japan is at war with China. The Japanese army is raiding the \ncity of Nanking, and Chinese soldiers must defend the civilians that live in it for as long as possible.");
        JOptionPane.showMessageDialog(null, "There are two types of combat units that can purchased: a soldier, and a tank. Because the \nChinese are far behind in technological sciences, their army is weaker but have greater \nnumbers as they are the defenders at the start. Your objective is to defend the civilians as \nlong as possible against the Japanese.");
        JOptionPane.showMessageDialog(null, "Keep in mind that tanks are more expensive than infantry, but infantry are also weaker than \n tanks. Remember that once all civilians in Nanking are killed, the game is over.");
        JOptionPane.showMessageDialog(null, "The terminal is your interface. Enter \"help\" for more instructions, and \"exit\" to leave \n the game anytime. Progress will not be saved.");
        while(city.isAlive()) { //large for loop that keeps going until all cilvians are dead and nankingAlive = false

            System.out.println("Round number: " + (survival+1) + ".");
            System.out.println("You currently have " + city.getResources() + " points of resources.");
            System.out.println("\n\tWHAT WOULD YOU LIKE TO DO?"); 
            System.out.println("\n(attack)\n(build)\n(stats)\n(help)\n(exit)");

            choice = kbrd.next();

            if(choice.equalsIgnoreCase("attack")) {
                if (ChinaArmy.ChineseArmy.size() < 6) {//the rare case if the user built no units
                    JOptionPane.showMessageDialog(null, "Your army is not large enough to defend Nanking. You cannot engage without a proper army!");
                    continue;
                }

                if (ChinaArmy.headCount() == 0) {
                    JOptionPane.showMessageDialog(null, "WARNING: You are out of men to fight on the battlefield. They're all dead.");
                }
                JOptionPane.showMessageDialog(null, "The Japanese have engaged Nanking...");

                //select the desired number of units for the wave
                
                if(ChinaArmy.headCount() < JapanArmy.headCount() ) { 
                    if (ChinaArmy.headCount() < 5) {
                        rSize = ChinaArmy.headCount();
                    }
                    else
                        rSize = 5;
                }
                else if (JapanArmy.headCount() < ChinaArmy.headCount()) {
                    if (JapanArmy.headCount() < 5) {
                        rSize = JapanArmy.headCount();
                    }
                    else
                        rSize = 5;
                }   
                else { //the armies are equal in size
                    rSize = 5;
                }
                
                int ChinaCount = 0;
                for(int i = 0; i < ChinaArmy.ChineseArmy.size(); i++) { //initiate the selected armies
                    
                    if(!ChinaArmy.ChineseArmy.get(i).isDead()){ //make sure that the unit you're sending to battle is still alive
                        tempChineseArmy[ChinaCount] = ChinaArmy.ChineseArmy.get(i);
                        ChinaCount++;
                        if(ChinaCount == rSize) {
                            break;
                        }
                    }
                    
                }
                
                int JapanCount = 0;
                for(int i = 0; i < JapanArmy.JapaneseArmy.size(); i++) { //initiate the selected armies
                    
                    if(!JapanArmy.JapaneseArmy.get(i).isDead()){ //make sure that the unit you're sending to battle is still alive
                        tempJapaneseArmy[JapanCount] = JapanArmy.JapaneseArmy.get(i); 
                        JapanCount++;
                        if(JapanCount == rSize) {
                            break;
                        }
                    }
                }
                
                
                for(int i = 0; i < rSize; i++) { 
                    //the fighting takes place here 
                    tempJapaneseArmy[i].combats(tempChineseArmy[i]); //Chinese attack (deal damage) first as they are defending
                    tempChineseArmy[i].combats(tempJapaneseArmy[i]); //Japanese then attack after Chinese
                }
                
                //civilian casualties
                //after each battle as the Chinese army gets smaller, it's more likely that a civilian dies. The threshold is 100. If there are less than 100 Chinese units, the population begins to die
                double probability = 1 - (ChinaArmy.headCount()/100); 
                
                if (probability <= 0) {
                    //no civies killed. The Chinese army is large enough to defend the city
                }
                else if (probability <= .20) 
                {
                    int chance = (int)(16*Math.random()); //up to 15 civilians can be killed
                    for (int i = 0; i < chance; i++) {
                        city.killCivilian();
                    }
                    JOptionPane.showMessageDialog(null, chance + " civilians were killed as a result.");
                    
                }
                else if (probability <= .50)
                {
                    int chance = (int)(21*Math.random()); //up to 20 civilians can be killed
                    for (int i = 0; i < chance; i++) {
                        city.killCivilian();
                    }
                    JOptionPane.showMessageDialog(null, chance + " civilians were killed as a result.");
                }
                else 
                {
                    int chance = (int)(36*Math.random()); //up to 35 civilians can be killed
                    for (int i = 0; i < chance; i++) {
                        city.killCivilian();
                    }
                    JOptionPane.showMessageDialog(null, chance + " civilians were killed as a result.");
                }
                    
            }

            else if(choice.equalsIgnoreCase("build")) {
                if (city.getResources() <= 0) {
                    System.out.println("You are out of resources to build anything. Select a different option...");
                    continue;
                }
                else {
                    System.out.println("What units would you like to construct?");
                    System.out.println("\n(Soldier)COST = " + soldierCost);
                    System.out.println("(Tank)\tCOST = " + tankCost);
                    System.out.println("(None)");
                    choice = kbrd.next();
                    if(choice.equalsIgnoreCase("Soldier")) { //buy soldiers
                        System.out.println("How many soldiers would you like to purchase? (enter an integer)");

                        input = kbrd.nextInt();
                        if(input <= 0 || ((city.getResources() - input*soldierCost)) < 0) { //if the user inputs unrealistic amounts
                            JOptionPane.showMessageDialog(null, "Unrealistic amount. Try again");
                            continue;
                        }
                        else {
                            while(input > 0) { //build Chinese Units
                                ChineseSoldier p = new ChineseSoldier( ChinaArmy.ChineseArmy.size(), 100);
                                ChinaArmy.addChineseArmy(p);
                                city.minusResources(soldierCost);
                                input--;
                            }
                            continue;
                        }
                    }
                    else if (choice.equalsIgnoreCase("Tank")) { //buy tanks
                        System.out.println("How many tanks would you like to purchase? (enter an integer)");
                        input = kbrd.nextInt();
                        if(input <= 0 || ((city.getResources() - input*tankCost)) < 0) { //if the user inputs unrealistic amounts
                            JOptionPane.showMessageDialog(null, "Unrealistic amount. Try again");
                            continue;
                        }
                        else {
                            while(input > 0) { //build Chinese Units
                                ChineseTank p = new ChineseTank( ChinaArmy.ChineseArmy.size(), 100);
                                ChinaArmy.addChineseArmy(p);
                                city.minusResources(tankCost);
                                input--;
                            }
                            continue;
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Unrealistic input. Try again.");
                        continue; //user entered invalid input
                    }
                }
            }
            else if(choice.equalsIgnoreCase("stats")) {
                System.out.println("You currently have " + city.getResources() + " points of resources.");
                System.out.println("The most recent census reports that there are currently " + city.headCount() + " civilians \nstill alive in Nanking.\n");
                ChinaArmy.armyStats();
                JapanArmy.armyStats();
                continue;
            }
            else if(choice.equalsIgnoreCase("help")) {
                JOptionPane.showMessageDialog(null, "Enter \"Stats\" for resources count, civilian count, and army count");
                JOptionPane.showMessageDialog(null, "Your objective is to hold out Nanking for as long as possible");
                continue;
            }
            else if(choice.equalsIgnoreCase("exit")) { //input if the user wants to leave the game
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Try again");
                continue; //invalid choice;
            }

            survival++;     //after each pass of this while loop, the user sucessfully defends Nanking against one round. Increment survival to keep count.
            if (JapanArmy.headCount() <= 0) { //if all Japanese Troops dead, you win
                JOptionPane.showMessageDialog(null, "The Japanese Army has been defeated and Nanking is safe!");
                JOptionPane.showMessageDialog(null, "WE ARE VICTORIOUS.");
                System.exit(0);
            }
            if (ChinaArmy.headCount() == 0) { //sends a warning to the user if all Chinese Units are dead
                JOptionPane.showMessageDialog(null, "WARNING: You are out of men to fight on the battlefield.");
                System.out.println("WARNING: You are out of men to fight on the battlefield.");
            }
        }

            
            
            
            
            
        //print game over messages and various endings 
        JOptionPane.showMessageDialog(null, "Nanking has fallen to the Japanese. You have lost.");
        JOptionPane.showMessageDialog(null, "You sucessfully defended the city against " + survival + " waves of Japanese Troops.");
        switch(difficulty) { 
            case 0:
            if(survival < 4) {
                JOptionPane.showMessageDialog(null, "That is dishonorable, comrade.");
            }
            else {
                JOptionPane.showMessageDialog(null, "With the Chinese army in such high moral however, Nanking will prevail and one day be liberated!");
            }
            break;

            case 1:
            if(survival < 10) {
                JOptionPane.showMessageDialog(null, "That is dishonorable, comrade.");
                JOptionPane.showMessageDialog(null, "Your incompetence will not be forgotten among the Chinese people.");
            }
            else {
                JOptionPane.showMessageDialog(null, "With the Chinese army in such high moral however, Nanking will prevail and one day be liberated!");
            }
            break;

            case 2:
            if(survival < 15) {
                JOptionPane.showMessageDialog(null, "That is dishonorable, comrade.");
                JOptionPane.showMessageDialog(null, "Your incompetence will not be forgotten among the Chinese people.");
                JOptionPane.showMessageDialog(null, "You will be court marshalled and tried for tragic failure on behalf of the People's Liberation Army.");
            }
            else {
                JOptionPane.showMessageDialog(null, "With the Chinese army in such high moral however, Nanking will prevail and one day be liberated!");
                JOptionPane.showMessageDialog(null, "The Chinese people have deep faith in you, Commander.");
            }
            break;
        }

        System.exit(0);
    }
}