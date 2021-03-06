package nl.parkingsimulator.logic;

import java.util.Random;
import java.awt.*;

/**
 * AdHocCar
 *
 * @author Hanze
 * @author Jeroen Westers (Refactored to mvc)
 */
public class AdHocCar extends Car {
    private static final Color COLOR=Color.red;
	
    public AdHocCar(int carType) {
        super(carType);
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
        id = 1;
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
