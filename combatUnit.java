/**
 * combatUnit
 * The super class of soldier class
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */

public class combatUnit {
    private int squadNumber;
    private double health;
    private int killRecord;
    private boolean isDead;
    
    public combatUnit(int initSquadNumber, double initHealth) {
        squadNumber = initSquadNumber;
        health = initHealth;
        killRecord = 0;
        isDead = false;
    }
    
    protected int getSquadNumber() {
        return squadNumber;
    }
    
    protected double getHealth() {
        return health;
    }
    protected void removeHealth(double damage) {
        this.health -= damage;
        if(health <= 0) {
            this.setDead();
        }
    }
      
    protected int getKillRecord() {
        return killRecord;
    }
    protected void addKillRecord(int kills) {
        killRecord += kills;
    }
    
    protected boolean isDead() {
        return isDead;
    }
    
    protected void setDead() {
        isDead = true;
    }
    
}