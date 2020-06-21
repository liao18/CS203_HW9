import java.util.* ;
/**
 * combatUnit
 * The super class of soldier and tank class
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */

public class JapaneseUnit extends combatUnit {   
    private final double SvsSoldier = 50;
    private final double SvsTank = 70;
    private final double TvsSoldier = 40;
    private final double TvsTank = 50;
    
    protected ArrayList<JapaneseUnit> JapaneseArmy = new ArrayList<JapaneseUnit>(); 
    //stores the count of how many JapaneseUnits are built //stores the count of how many JapaneseUnits are built; has large finite number

    public JapaneseUnit(int initSquadNumber, double initHealth) {
        super(initSquadNumber, initHealth);
    }
    
    protected void addJapaneseArmy(JapaneseSoldier a) { //overloaded method to store soldier type
        JapaneseArmy.add(a);
    }
    
    protected void addJapaneseArmy(JapaneseTank a) { //overloaded method to store tank type
        JapaneseArmy.add(a);
    }
    
    protected void killsCivilian(civilianUnit a) {
        a.setDead();
    }
    
    protected int headCount() { //count how many Japanese troops in the JapaneseArmy arraylist are still alive
        int count = 0;
        for(int i = 0; i<JapaneseArmy.size(); i++) {
            if(!JapaneseArmy.get(i).isDead()) {
                count++;
            }
        }
        return count;
    }
    
    protected void armyStats(){ //count how many tanks and infantry there are
        int soldierCount = 0;
        int tankCount = 0;
        for(int i = 0; i<JapaneseArmy.size(); i++) {
            if(!JapaneseArmy.get(i).isDead()) {
                if(JapaneseArmy.get(i) instanceof JapaneseSoldier)
                {
                    soldierCount++;
                }
                else if(JapaneseArmy.get(i) instanceof JapaneseTank) {
                    tankCount++;
                }
            }
        }
        int sum = soldierCount + tankCount;
        
        System.out.println("Intel reports there are " + soldierCount + " Japanese soldiers and " + tankCount + " Japanese tanks in the total army.");
        System.out.println("For a total of " + sum + " Japanese Units.");
    }
    
    protected void combats(ChineseUnit a) {
        if (this instanceof JapaneseSoldier) {
            if(a instanceof ChineseSoldier)
            {
                this.removeHealth(SvsSoldier);
            }
            else if(a instanceof ChineseTank) {
                this.removeHealth(SvsTank);
            }
        }
        else if (this instanceof JapaneseTank) {
            if(a instanceof ChineseSoldier)
            {
                this.removeHealth(TvsSoldier);
            }
            else if(a instanceof ChineseTank) {
                this.removeHealth(TvsTank);
            }
        }
        //will be a long method that must be implemented
    }
}