/**
 * combatUnit
 * The class of ChineseSoldier class
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */


public class ChineseSoldier extends ChineseUnit {     
    private final double vsSoldier = 35; //damage does vs a Japanese Soldier class
    private final double vsTank = 10; //damage does vs a Japanese tank class
    protected final double cost = 11.95;  
    public ChineseSoldier(int initSquadNumber, double initHealth) { 
        super(initSquadNumber, initHealth);
        
    }
    
    protected double vsSoldier() {
        return vsSoldier;
    }
    
    protected double vsTank() {
        return vsTank;
    }
    
    protected double getCost() {
        return cost;
    }

}