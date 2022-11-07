package enigma_project.Wheel_Section;
import java.util.*;

/**
 * Enigma Machine Drum class
 * @author flippi321
 */
public class Drum {
    List<Character> alphabet;
    List<Character> wheel;
    int wheelPosition;

    /**
     * Constructor for class that represents an encryption wheel
     * @param type string representing the wheel_type enum
     */
    public Drum(String type) throws IllegalArgumentException {
        if (!type.equalsIgnoreCase("A") & !type.equalsIgnoreCase("B") &
                !type.equalsIgnoreCase("C")){
            throw new IllegalArgumentException("Wheel Setting must be Valid letter (A-C)");
        }

        // Use Wheel A
        if (type.equalsIgnoreCase("A")){
            this.wheel = new ArrayList<>(Arrays.asList('z','y','x','w','v',
                    'u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'));
        }
        // Use Wheel B
        else if (type.equalsIgnoreCase("B")){
            this.wheel = new ArrayList<>(Arrays.asList('k','i','b','p','l',
                    'h','w','d','v','y','q','j','m','s','u','x','z','f','t','g','e','r','o','c','a','n'));
        }
        // Use Wheel C
        else {
            this.wheel = new ArrayList<>(Arrays.asList('y','d','s','q','l',
                    'w','p','z','x','u','k','b','h','c','e','m','v','a','n','o','r','g','t','f','j','i'));
        }
        // Define alphabet
        alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        wheelPosition = 0;
    }

    /**
     * Method to tick the wheel
     * Depending on the parameters, this can either mean moving all values one step up or one step down
     */
    private boolean tick(int setting) throws IllegalArgumentException {
        // Rotate Up
        if (setting==1){
            // Move last element to the front
            wheel.add(0, wheel.get(wheel.size()-1));
            wheel.remove(wheel.size()-1);
        }
        // Rotate Down
        else if (setting==-1){
            // Move first element to the back
            wheel.add(wheel.size()-1, wheel.get(0));
            wheel.remove(0);
        }
        // Invalid Input
        else {
            throw new IllegalArgumentException("Setting has to be either -1 or 1");
        }

        //If wheel has reset, the next wheel needs to tick
        if(wheelPosition==(wheel.size()-1)){
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
            tick(1);
        }
        return false;
    }

    /**
     * Method to tick the wheel downwards if possible
     * All values will be moved down and the first value will be put at the last position
     */
    public boolean tickDown(boolean shouldTick) {
        if (shouldTick){
            return tick(-1);
        }
        return false;
    }

    /**
     * Method to tick the drum to a specified position
     * This is used to set the initial position of the enigma drums
     * @param n how many times the wheel will tick
     */
    public void setDrumPosTo(int n) throws IllegalArgumentException{
        if (n <= 0){  throw new IllegalArgumentException("Has to rotate more than 0 times"); }
        for(int i = 0; i < n; i++){
            tickUp(true);
        }
    }

    /**
     * Method for scrambling a letter using the wheel
     * This method is used on encryption done before reaching the reflector
     * @param c the input character
     * @return the scrambled character
     */
    public char leftEncrypt(char c){
        int pos = alphabet.indexOf(c);
        return wheel.get(pos);
    }

    /**
     * Method for scrambling a letter using the wheel
     * This method is used on encryption done after reaching the reflector
     * @param c the input character
     * @return the scrambled character
     */
    public char rightEncrypt(char c){
        int pos = wheel.indexOf(c);
        return alphabet.get(pos);
    }

    // Getters and Setters

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public List<Character> getWheel() {
        return wheel;
    }

    public void setWheel(ArrayList<Character> wheel) {
        this.wheel = wheel;
    }

    public int getWheelPosition() {
        return wheelPosition;
    }

    public void setWheelPosition(int wheelPosition) {
        this.wheelPosition = wheelPosition;
    }
}