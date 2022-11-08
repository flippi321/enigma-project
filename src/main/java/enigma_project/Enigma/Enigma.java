package enigma_project.Enigma;
import enigma_project.PinBoard.PinBoard;
import enigma_project.Wheel_Section.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    ArrayList<Wheel_type> settings;
    int drum1StartPos;
    int drum2StartPos;
    int drum3StartPos;
    Wheel_type drum1_type;
    Wheel_type drum2_type;
    Wheel_type drum3_type;

    /**
     * Constructor for class representing an Enigma machine
     * @param drum1_type the type of wheel used by drum1
     * @param drum2_type the type of wheel used by drum2
     * @param drum3_type the type of wheel used by drum3
     */
    public Enigma(Wheel_type drum1_type, Wheel_type drum2_type, Wheel_type drum3_type) {
        this.drum1_type = drum1_type;
        this.drum2_type = drum2_type;
        this.drum3_type = drum3_type;
        drum1StartPos = 0;
        drum2StartPos = 0;
        drum3StartPos = 0;
        reflector = new Reflector();
        pinBoard = new PinBoard();
        settings = new ArrayList<>(Arrays.asList(Wheel_type.values()));
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
        drum1 = new Drum(drum1_type.name().toUpperCase(Locale.ROOT));
        drum2 = new Drum(drum2_type.name().toUpperCase(Locale.ROOT));
        drum3 = new Drum(drum3_type.name().toUpperCase(Locale.ROOT));
        drum1.setDrumPosTo(drum1StartPos);
        drum2.setDrumPosTo(drum2StartPos);
        drum3.setDrumPosTo(drum3StartPos);
    }

    /**
     * Takes in int values to set the drums
     * @param drum1Settings the first drums settings
     * @param drum2Settings the second drums settings
     * @param drum3Settings the third drums settings
     */
    public void setDrums(int drum1Settings, int drum2Settings, int drum3Settings) throws IllegalArgumentException {
        drum1_type = settings.get(drum1Settings);
        drum2_type = settings.get(drum2Settings);
        drum3_type = settings.get(drum3Settings);
        resetDrums();
    }

    /**
     * Method to change drum position to a preset
     * @param drum1pos the amount of positive rotations in the first drum
     * @param drum2pos the amount of positive rotations in the second drum
     * @param drum3pos the amount of positive rotations in the third drum
     */
    public void setDrumPositions(int drum1pos, int drum2pos, int drum3pos) {
        int maxPos = drum1.getAlphabet().size()-1;
        //The positions cannot be lower than 0
        while( drum1pos < 0 | drum2pos < 0 | drum3pos < 0){
            if (drum1pos<0){ drum1pos += maxPos; }
            if (drum2pos<0){ drum2pos += maxPos; }
            if (drum3pos<0){ drum3pos += maxPos; }
        }
        //The positions cannot be longer than the alphabet itself
        while(drum1pos > maxPos | drum2pos > maxPos | drum3pos > maxPos){
            if (drum1pos>maxPos){ drum1pos -= maxPos; }
            if (drum2pos>maxPos){ drum2pos -= maxPos; }
            if (drum3pos>maxPos){ drum3pos -= maxPos; }
        }
        drum1StartPos = drum1pos;
        drum2StartPos = drum2pos;
        drum3StartPos = drum3pos;
        resetDrums();
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