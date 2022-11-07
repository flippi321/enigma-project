package enigma_project.Encryption_wheels;

/**
 * Enigma machine class
 * @author flippi321
 */
public class wheel {
    String[] alphabeth =
            {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    char[] wheel;

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
    public wheel(String type) {
        if (type.equalsIgnoreCase("A")){
            this.wheel = A;
        } else if (type.equalsIgnoreCase("B")){
            this.wheel = B;
        } else {
            this.wheel = C;
        }
    }

    /**
     * Method to rotate the wheel
     * This means moving all values one position up, and the last value to the first position
     */
    public void rotate(){
        // Get last element
        int last_position = wheel.length-1;
        char temp = wheel[last_position];
        // Replace all values with the previous one
        System.arraycopy(wheel, 0, wheel, 1, last_position);
        //Replace first value with the last element
        wheel[0] = temp;
    }

    public char
}