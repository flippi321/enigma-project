package enigma_project.Wheel_Section;

/**
 * Enigma machine class
 * @author flippi321
 */
public class drum {
    String[] alphabeth =
            {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
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
     * This means moving all values one position up, and the last value to the first position
     */
    public boolean tick(boolean check){
        // Get last element
        int last_position = wheel.length-1;
        char temp = wheel[last_position];
        // Replace all values with the previous one
        // TODO Test ArrayCopy
        for (int i = last_position; i >= 0; i--){
            wheel[i] = wheel[i-1];
        }
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
     * Method to tick the wheel multiple times
     * Used for setting drum starting position
     * @param n how many times the wheel will tick
     */
    public void tickMultiple(int n) throws IllegalArgumentException{
        if (n<=0){  throw new IllegalArgumentException("Has to rotate a positive number of times"); }
        for(int i = 0; i < n; i++){
            tick();
        }
    }

    /**
     * Method to tick the wheel in the reverse order
     * This means moving all values one position down, and the first value to the last position
     */
    public boolean reverseTick(boolean check){
        // Get last element
        int last_position = wheel.length-1;
        char temp = wheel[0];
        // Replace all values with the next one
        // TODO Test ArrayCopy
        for (int i = 0; i < wheel.length; i++){
            wheel[i] = wheel[i+1];
        }
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
     * If it's the first wheel, it will always tick after activation
     * @return if the second wheel needs to tick
     */
    public boolean tick(){
        return tick(true);
    }

    /**
     * If it's the first wheel, it will always tick after activation
     * @return if the second wheel needs to tick
     */
    public boolean reverseTick(){
        return reverseTick(true);
    }
}