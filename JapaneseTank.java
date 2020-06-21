/**
 * JapaneseTank
 * The class of JapaneseTank class
 * 
 * @author Jonathan Liao
 * @version  4.8.2015
 * 
 */


public class JapaneseTank extends JapaneseUnit {     
    private final double vsTank = 70; //damage does vs a Chinese tank class
    
    public JapaneseTank(int initSquadNumber, double initHealth) { 
        super(initSquadNumber, initHealth);
    }
    
}