import java.util.* ;
/**
 * combatUnit
 * The super class of soldier class
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */

public class ChineseUnit extends combatUnit {   
    private final double SvsSoldier = 70;
    private final double SvsTank = 90;
    private final double TvsSoldier = 50;
    private final double TvsTank = 100;
    
    protected ArrayList<ChineseUnit> ChineseArmy = new ArrayList<ChineseUnit>(); //stores the count of how many ChineseUnits are built
    
    public ChineseUnit(int initSquadNumber, double initHealth) {
        super(initSquadNumber, initHealth);
    }
    
    protected void addChineseArmy(ChineseSoldier a) { //overloaded method to store soldier type
        ChineseArmy.add(a);
    }
    
    protected void addChineseArmy(ChineseTank a) { //overloaded method to store tank type
        ChineseArmy.add(a);
    }
    
    protected void addChineseUnit() {
        ChineseArmy.add(this);
    }
    
    protected int headCount() { //count how many Chinese troops in the ChineseArmy arraylist are still alive
        int count = 0;
        for(int i = 0; i<ChineseArmy.size(); i++) {
            if(!ChineseArmy.get(i).isDead()) {
                count++;
            }
        }
        return count;
    }
    
    protected void armyStats(){ //count how many tanks and infantry there are
        int soldierCount = 0;
        int tankCount = 0;
        for(int i = 0; i<ChineseArmy.size(); i++) {
            if(!ChineseArmy.get(i).isDead()) {
                if(ChineseArmy.get(i) instanceof ChineseSoldier)
                {
                    soldierCount++;
                }
                else if(ChineseArmy.get(i) instanceof ChineseTank) {
                    tankCount++;
                }
            }
        }
        int sum = soldierCount + tankCount;
        System.out.println("Your general reports there are " + soldierCount + " Chinese soldiers and " + tankCount + " Chinese tanks in the total army.");
        System.out.println("For a total of " + sum + " Chinese Units.");
    }
    
    protected void combats(JapaneseUnit a) {
        if (this instanceof ChineseSoldier) {
            if(a instanceof JapaneseSoldier)
            {
                this.removeHealth(SvsSoldier);
            }
            else if(a instanceof JapaneseTank) {
                this.removeHealth(SvsTank);
            }
        }
        else if (this instanceof ChineseTank) {
            if(a instanceof JapaneseSoldier)
            {
                this.removeHealth(TvsSoldier);
            }
            else if(a instanceof JapaneseTank) {
                this.removeHealth(TvsTank);
            }
        }
    }
}