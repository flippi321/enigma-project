package enigma_project.Wheel_Section;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enigma Machine Drum class
 * @author flippi321
 */
public class drum {
    char[] alphabet =
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                    'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] wheel;
    int wheelPosition;

    // Encryption Wheels
    // TODO Change Location
    char[] A =
            {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};
    char[] B =
            {'k','i','b','p','l','h','w','d','v','y','q','j','m','s','u','x','z','f','t','g','e','r','o','c','a','n'};
    char[] C =
            {'y','d','s','q','l','w','p','z','x','u','k','b','h','c','e','m','v','a','n','o','r','g','t','f','j','i'};

    /**
     * Constructor for class that represents an encryption wheel
     * @param type string representing the wheel_type enum
     */
    public drum(String type) {
        if (type.equalsIgnoreCase("A")){
            this.wheel = A;
        } else if (type.equalsIgnoreCase("B")){
            this.wheel = B;
        } else {
            this.wheel = C;
        }

        wheelPosition = 0;
    }

    /**
     * Method to tick the wheel
     * Depending on the parameters, this can either mean moving all values one step up or one step down
     */
    private boolean tick(int srcPos, int destPos){
        // Get last element
        int last_position = wheel.length-1;
        char temp = wheel[last_position];
        // Replace all values with the previous one
        // TODO test that arraycopy works as intended
        System.arraycopy(wheel, srcPos, wheel, destPos, wheel.length);
        //Replace first value with the last element
        wheel[0] = temp;

        //If wheel has reset, the next wheel needs to tick
        if(wheelPosition==last_position){
            wheelPosition = 0;
            return true;
        }
        wheelPosition++;
        return false;
    }

    /**
     * Method to tick the wheel upwards if possible
     * All values will be moved up and the last value will be put at the first position
     */
    public boolean tickUp(boolean shouldTick) {
        if (shouldTick){
            return tick(0, 1);
        }
        return false;
    }

    /**
     * Method to tick the wheel upwards
     */
    public boolean tickUp() {
        return tickUp(true);
    }

    /**
     * Method to tick the wheel downwards if possible
     * All values will be moved down and the first value will be put at the last position
     */
    public boolean tickDown(boolean shouldTick) {
        if (shouldTick){
            return tick(1, 0);
        }
        return false;
    }

    /**
     * Method to tick the wheel downwards
     * All values will be moved down and the first value will be put at the last position
     */
    public boolean tickDown() {
        return tickDown(true);
    }

    /**
     * Method to tick the drum to a specified position
     * This is used to set the initial position of the enigma drums
     * @param n how many times the wheel will tick
     */
    public void setDrumPosTo(int n){
        if (n<=0){  throw new IllegalArgumentException("Has to rotate a positive number of times"); }
        for(int i = 0; i < n; i++){
            tickUp();
        }
    }
}