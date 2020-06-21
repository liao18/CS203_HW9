/**
 * combatUnit
 * The class of ChineseTank class
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */


public class ChineseTank extends ChineseUnit {     

    private final double cost = 54.25;
    
    public ChineseTank(int initSquadNumber, double initHealth) { 
        super(initSquadNumber, initHealth);
    }
    
    protected double getCost() {
        return cost;
    }
}