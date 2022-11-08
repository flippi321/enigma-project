package enigma_project.Enigma;
import enigma_project.PinBoard.PinBoard;
import enigma_project.Wheel_Section.*;
import java.util.Locale;

/**
 * Enigma machine class
 * @author flippi321
 */
public class Enigma {
    Drum drum1;
    Drum drum2;
    Drum drum3;
    Reflector reflector;
    PinBoard pinBoard;
    String drum1_type;
    String drum2_type;
    String drum3_type;

    /**
     * Constructor for class representing an Enigma machine
     * @param drum1_type the type of wheel used by drum1
     * @param drum2_type the type of wheel used by drum2
     * @param drum3_type the type of wheel used by drum3
     */
    public Enigma(String drum1_type, String drum2_type, String drum3_type) {
        this.drum1_type = drum1_type.toUpperCase(Locale.ROOT);
        this.drum2_type = drum2_type.toUpperCase(Locale.ROOT);
        this.drum3_type = drum3_type.toUpperCase(Locale.ROOT);
        reflector = new Reflector();
        pinBoard = new PinBoard();
        resetDrums();
    }


    public String algorithm(String input, boolean encrypting) throws IllegalArgumentException {
        char[] messageList = input.toLowerCase(Locale.ROOT).toCharArray();
        StringBuilder output = new StringBuilder();
        for (char letter : messageList){
            char currentLetter = letter;
            // If decrypting, we need to swap before the encryption
            if (!encrypting){
                currentLetter = pinBoard.swap(letter);
            }
            // Encrypt Message
            char encrypt1 = leftEncrypt(currentLetter);
            // Reflect back
            char reflected = reflector.reflectLetter(encrypt1);
            // Encrypt Again
            currentLetter = rightEncrypt(reflected);
            // If encrypting, we need to swap after the encryption
            if (encrypting){
                currentLetter = pinBoard.swap(currentLetter);
            }
            // Add letter to output
            output.append(currentLetter);
            // Rotate Wheels
            drum3.tickUp(drum2.tickUp(drum1.tickUp(true)));
        }
        resetDrums();
        return output.toString();
    }

    public String encrypt(String input){
        return algorithm(input, true);
    }

    public String decrypt(String input){
        return algorithm(input, false);
    }

    private char leftEncrypt(char c){
        char l1 = drum1.leftEncrypt(c);
        char l2 = drum2.leftEncrypt(l1);
        return drum3.leftEncrypt(l2);
    }

    private char rightEncrypt(char c){
        char l1 = drum3.rightEncrypt(c);
        char l2 = drum2.rightEncrypt(l1);
        return drum1.rightEncrypt(l2);
    }

    /**
     * Method to add a connection between two letters on the Enigma PinBoard
     * @param a the first letter
     * @param b the second letter
     * @throws IllegalArgumentException if either letter is already used
     */
    public void addConnection(char a, char b) throws IllegalArgumentException{
        pinBoard.addConnection(a, b);
    }

    /**
     * Method to reset Drums back to their original positions
     */
    private void resetDrums(){
        drum1 = new Drum(drum1_type.toUpperCase(Locale.ROOT));
        drum2 = new Drum(drum2_type.toUpperCase(Locale.ROOT));
        drum3 = new Drum(drum3_type.toUpperCase(Locale.ROOT));
    }

    /**
     * Method to rotate Drum1 n number of times
     * @param n how many times the drum shall be turned
     */
    private void rotateDrum1(int n) throws IllegalArgumentException {
        drum1.setDrumPosTo(n);
    }

    /**
     * Method to rotate Drum2 n number of times
     * @param n how many times the drum shall be turned
     */
    private void rotateDrum2(int n) throws IllegalArgumentException {
        drum3.setDrumPosTo(n);
    }

    /**
     * Method to rotate Drum3 n number of times
     * @param n how many times the drum shall be turned
     */
    private void rotateDrum3(int n) throws IllegalArgumentException {
        drum3.setDrumPosTo(n);
    }

    // Getters and setters

    public Drum getDrum1() {
        return drum1;
    }

    public void setDrum1(Drum drum1) {
        this.drum1 = drum1;
    }

    public Drum getDrum2() {
        return drum2;
    }

    public void setDrum2(Drum drum2) {
        this.drum2 = drum2;
    }

    public Drum getDrum3() {
        return drum3;
    }

    public void setDrum3(Drum drum3) {
        this.drum3 = drum3;
    }

    public Reflector getReflector() {
        return reflector;
    }

    public void setReflector(Reflector reflector) {
        this.reflector = reflector;
    }
}