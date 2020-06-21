import java.util.* ;

/**
 * Nanking
 * The class of the city
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */

public class Nanking {
    protected ArrayList<civilianUnit> civilianCount = new ArrayList<civilianUnit>(); //stores civlian count. Will store civilians that are still alive, and remember the ones that die
    private double resources; //the amount of resources that the player will start out with
    
    public Nanking(double initResources) { //should only construct one of these objects, EVER
        resources = initResources;
    }
    
    protected void addCiv(civilianUnit a) {
        civilianCount.add(a);
    }
    
    protected void addResources(double amount) {
        resources += amount;
    }
    
    protected void minusResources(double amount) {
        resources -= amount;
    }
    
    protected double getResources() {
        return resources;
    }
    
    protected boolean isAlive() {
        int count =0;
        for(int i = 0; i<civilianCount.size(); i++) {
            if(!civilianCount.get(i).isDead() ){
                count++;
            }
        }
        if(count > 0) 
        {
            return true;
        }
        else
            return false;
    }
    
    protected void killCivilian() { //kill a civilian at the next index
        for(int i = 0; i<civilianCount.size(); i++) {
            if(!civilianCount.get(i).isDead() ){
                civilianCount.get(i).setDead();
                break;
            }
        }
    }
    
    protected int headCount() { //count how many civilians are still alive
        int count =0;
        for(int i = 0; i<civilianCount.size(); i++) {
            if(!civilianCount.get(i).isDead() ){
                count++;
            }
        }
        return count;
    }
}