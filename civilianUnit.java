/**
 * civilianUnit
 * The class of nonsoldier class
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */

public class civilianUnit {
    private boolean isDead;
    
    
    public civilianUnit() {
        isDead = false;
    }

    protected boolean isDead() {
        return isDead;
    }
    
    protected void setDead() {
        isDead = true;
    }
}